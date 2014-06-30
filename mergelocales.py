#  Copyright 2010 Philippe Beaudoin
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.


"""
This module contains a script for merging java properties
files for GWT internationalisation with UIBinder. For more
information on the motivation for this script, see:
  http://code.google.com/p/google-web-toolkit/issues/detail?id=4355


Invoke in this way:
   mergelocales Extras_dir LocalizableResource_dir

For example:
   mergelocales ./extras/myproject ./src/com/google/gwt/i18n/client/


The typical use case:
  - You use internationalisation markup directly in your UIBinder
    xml files
  - You may or may not use Constants or Messages resources within
    your java files
  - You want to keep all your translations in a central file

The required setup:
  - All your use of the <ui:msg> markup in the xml file MUST contain
    a description, otherwise you risk getting unexpected DEPRECATED
    messages.
  - You need the file
      src/com/google/gwt/i18n/client/LocalizableResource.properties
    This file will contain all the default locale translations. It
    must be named exactly this (see link above for details).
  - In the same directory you need
      LocalizableResource_xxxx.properties
    for each locale you want to support. For example, xxxx should be
    fr if you want to translate to french.
  - You need to GWT-compile your project with the "-extra" flag to
    generate extra files, including UIBinder translations.
    For example: "-extra extras"
  - If you use Constant or Message to define translations that are
    used within your java code but not within UIBinder, then you
    should add a non-UIBinder section to your LocalizableResource
    file. This sections should begin with:
        ### NON-UIBINDER TRANSLATIONS
    And the following lines should contain all the non-UIBinder
    translations.

The result:
  - The LocalizableResource.properties file will be updated in the
    following way:
     - It will contain all the UIBinder translations found.
     - It will contain all the non-UIBinder translations that were
       there before.
     - It will contain all the UIBinder translations that were there
       before but that were not found within UIBinder files. These
       will be noted "# TODO: DEPRECATED (CONSIDER REMOVING)".
  - Each locale-specific LocalizableResource_xxxx.properties files
    will be updated:
     - They will contain all the keys found in UIBinder files,
       together with their old translation if available or with their
       default locale text and the comment "# TODO: TRANSLATE" if no
       translation exist. If some of these have new descriptions, a
       comment "# TODO: CONFIRM TRANSLATION (DESCRIPTION CHANGED)"
       will be added to the translation.
     - It will contain all the non-UIBinder keys that were found in
       LocalizableResource.properties, together with their old
       translation if available or with their default locale text and
       the comment "# TODO: TRANSLATE" if no translation exist.
     - It will contain all the UIBinder translations that were there
       before but that were
       not found within UIBinder files. These will be noted
       "# TODO: DEPRECATED (CONSIDER REMOVING)".

The .properties files in LocalizableResource_dir will be overwritten.
Although the new files should contain all the translations that were
on the original, be on the safe side and backup your files before
invoking this script. Needless to say, this script comes with no
warranty whatsoever, but please feel free to contact me if you have
any questions, if you found bugs, or simply if you found the script
useful.

Created on 2010-02-25

@author: Philippe Beaudoin  (philippe.beaudoin@gmail.com)
"""

import os
import re
import copy

import sys
import getopt

nonUIBinderComment = '### NON-UIBINDER TRANSLATIONS\n'
deprecatedComment = '# TODO: DEPRECATED (CONSIDER REMOVING)\n'
translateComment = '# TODO: TRANSLATE\n'
confirmComment = '# TODO: CONFIRM TRANSLATION (DESCRIPTION CHANGED)\n'

deprecated_comment_issued = False
translate_comment_issued = False
confirm_comment_issued = False


def main():
    # parse command line options
    try:
        opts, args = getopt.getopt(sys.argv[1:], "h", ["help"])
    except getopt.error, msg:
        print(msg)
        print("for help use --help")
        sys.exit(2)
        # process options
    for o, _ in opts:
        if o in ("-h", "--help"):
            print(__doc__)
            sys.exit(0)
    if len(args) != 2:
        print("Needs exactly two arguments.")
        print("for help use --help")

    # process arguments
    merge_locales(args[0], args[1])


class InvalidProperty(Exception):
    """
    Exception raised when a property cannot be properly parsed from a text file.
    """

    def __init__(self, value):
        self.value = value

    def __str__(self):
        return repr(self.value)


class Property(object):
    """
    A property is a single element of translation.
    """

    def __init__(self, non_ui_binder):
        """
        Initialises a new property.
        """
        self.comments = None
        self.key = None
        self.value = None
        self.non_ui_binder = non_ui_binder

    def get_from_file(self, file):
        """
        Get the next property from a file. Throws a InvalidProperty exception
        if the property is not correctly formatted. This method will replace the
        comments, key and value of this Property object.

        @param file: The opened file object to read from.
        @return: True on success, False on EOF.
        """

        # Skip blank lines. Return false if EOF is reached
        line = read_non_blank_line(file)
        if not line:
            return False

        # Read the comment block
        self.comments = ''
        while line.startswith('#'):
            self.comments += line
            line = file.readline()

        # Read the key/value
        index = line.find('=')
        if index < 0:
            # Comment-only property, that's fine, may be non-UIBinder though
            if self.comments == nonUIBinderComment:
                self.non_ui_binder = True
            return True

        self.key = line[:index].strip()
        if len(self.key) == 0:
            raise InvalidProperty(
                'Invalid key found. File: %s.\nLine: %sComment block: %s' % (file.name, line, self.comments))

        self.value = line[index + 1:]
        while self.value.endswith('\\\n'):
            self.value += file.readline()

        return True

    def is_deprecated(self):
        """
        Check if this property is marked as deprecated.

        @return: True if it is marked as deprecated, false otherwise.
        """
        return self.comments.find(deprecatedComment) >= 0

    def set_deprecated(self):
        """
        Ensures that this property is marked as deprecated, by including an appropriate comment.
        """
        if not self.is_deprecated():
            self.comments += deprecatedComment
        global deprecated_comment_issued
        deprecated_comment_issued = True

    def unset_deprecated(self):
        """
        Ensures that this property is not marked as deprecated, by removing any such comment.
        """
        while self.is_deprecated():
            index = self.comments.find(deprecatedComment)
            self.comments = self.comments[:index] + self.comments[index + len(deprecatedComment):]

    def set_translation_needed(self):
        """
        Ensures that this property indicates that it requires translation, by including an appropriate comment.
        """
        if self.comments.find(translateComment) < 0:
            self.comments += translateComment
        global translate_comment_issued
        translate_comment_issued = True

    def set_confirm_translation(self):
        """
        Ensures that this property indicates that its translation should be confirmed, by including an appropriate
        comment.
        """
        if self.comments.find(confirmComment) < 0:
            self.comments += confirmComment
        global confirm_comment_issued
        confirm_comment_issued = True

    def comment_matches(self, other_property):
        """
        Check that the comment matches between both properties. The comments are considered to
        match if they are exactly the same when the "# TODO:" comments are removed.

        @param other_property: The other property with which to compare.
        @return: True if the comment matches, False otherwise.
        """
        return strip_to_do_comments(self.comments) == strip_to_do_comments(other_property.comments)

    def __str__(self):
        result = self.comments
        if self.key is not None:
            result += self.key + '=' + self.value
        return result + '\n'


class PropertyCollection(object):
    """
    A collection of Property object that can be merged or written to files
    """

    def __init__(self):
        """
        Initializes a new collection of Property objects.
        """
        self.properties = []
        self.map = {}
        self.index_non_ui_binder = None

    def add(self, propertyarg):
        """
        Adds an object of type Property to the collection

        @param propertyarg: The Property object to add
        """
        if propertyarg.key is not None:
            self.map[propertyarg.key] = propertyarg
        if propertyarg.non_ui_binder:
            if self.index_non_ui_binder is None:
                self.index_non_ui_binder = len(self.properties)
            self.properties.append(propertyarg)
        else:
            if self.index_non_ui_binder is None:
                self.properties.append(propertyarg)
            else:
                self.properties.insert(self.index_non_ui_binder, propertyarg)

    def merge_with(self, other_collection, mark_deprecated, mark_translation):
        """
        Merge this collection with another one. Any key that is found in the other collection but not
        in this one will be added. If the markDeprecated parameter is true, any key that is found in
        this collection but not in the other one will be marked as deprecated. If the markTranslation
        parameter is true, comments will be added to indicate translations that need to be performed.

        @param other_collection: The collection to merge into this one.
        @param mark_deprecated: A boolean. True if deprecated translations should be indicated, false otherwise.
        @param mark_translation: A boolean. True means that "# TODO: TRANSLATE" and "# TODO: CONFIRM TRANSLATION"
        comments will be added when needed.
        """

        # Bring properties over
        for collection_property in other_collection.properties:
            if collection_property.key is None:
                continue   # Don't merge comment-only properties
            if not collection_property.key in self.map:
                property_copy = copy.copy(collection_property)
                self.add(property_copy)
                if mark_translation:
                    property_copy.set_translation_needed()
            elif collection_property.comments != '':
                # Empty comments mean non-UIBinder translations OR deprecated translations, skip them.
                # Non-empty comments are copied over, with a confirmation comment if requested.
                my_property = self.map[collection_property.key]
                if not my_property.comment_matches(collection_property):
                    my_property.comments = collection_property.comments
                    if mark_translation:
                        my_property.set_confirm_translation()

        if not mark_deprecated:
            return

        # Mark deprecated properties
        for collection_property in self.properties:
            if collection_property.key is None:
                continue   # Don't consider comment-only properties
            if not collection_property.key in other_collection.map:
                collection_property.set_deprecated()
            elif not collection_property.non_ui_binder:
                # Tricky. Properties that have been removed from all UIBinder files will be
                # found in the resource file, but without comment. (Properties found in UIBinder
                # all have comments because we _require_ that the user provides a description.)
                other_property = other_collection.map[collection_property.key]
                if other_property.comments == '' or other_property.is_deprecated():
                    collection_property.set_deprecated()

    def __str__(self):
        result = ''
        for one_property in self.properties:
            result += str(one_property)
        return result


def strip_to_do_comments(comment):
    """
    Remove all the # TODO: comments from the passed comment, returns the result.

    @param comment: The comment from which to strip the TODO comments.
    @return: The stripped result.
    """
    comments_to_strip = [deprecatedComment, translateComment, confirmComment]

    for commentToStrip in comments_to_strip:
        length = len(comment)
        index = comment.find(commentToStrip)
        while index != -1:
            comment = comment[:index] + comment[index + length:]
            index = comment.find(commentToStrip)

    return comment


def read_non_blank_line(file):
    """
    Eats all the blank lines from a file. A line is blank if it only contains spaces
    followed by a new line.

    @param file: The opened file to eat blanks from.
    @return: The first non-blank line read. An empty string if EOF is reached.
    """

    line = '\n'
    while re.match(r'\s*\n', line, re.L):
        line = file.readline()
    return line


def enumerate_property_files(path):
    """
    Looks in the specified directory for all property files, that is, files ending in .properties.

    @param path: The directory to look in.
    @return: A list of files.
    """

    return filter(lambda filename: filename.endswith('.properties'),
                  os.listdir(path))


def read_properties_from_file(filename):
    """
    Read all the properties from a given file.

    @param filename: The name of the file to read properties from.
    @return: A property collection
    """

    file = open(filename, 'r')

    try:
        properties = PropertyCollection()
        non_ui_binder = False
        while True:
            property_read = Property(non_ui_binder)
            result = property_read.get_from_file(file)
            if not result:
                break
            property_read.unset_deprecated()
            properties.add(property_read)
            if property_read.non_ui_binder:
                non_ui_binder = True
    finally:
        file.close()

    if not non_ui_binder:
        # Add an empty non-UIBinder section
        property_read = Property(True)
        property_read.comments = nonUIBinderComment
        properties.add(property_read)

    return properties


def find_locale(filename):
    """
    Identifies the locale given the filename of a property file.
    For example file_fr.properties will return fr.
    If there is no locale in the filename, returns the empty string.

    @param filename: The filename from which to extract the locale.
    @return: The locale or the empty string for the default locale.
    """
    locale = ''  # Default locale when none is found
    match = re.match(r'[^_]*_([^\.]*)\.properties', filename)
    if match:
        locale = match.group(1)
    return locale


def merge_locales(extras_dir, resources_dir):
    """
    The main process of this script.

    Takes every property file in extrasDir and merge them to the
    default locale file in resourcesDir. Then it merges this resource file with every other
    non-default local file in the directory.
    """
    extras_dir = os.path.abspath(extras_dir)
    resources_dir = os.path.abspath(resources_dir)
    extra_files = enumerate_property_files(extras_dir)
    incoming_properties = PropertyCollection()
    for filename in extra_files:
        locale = find_locale(filename)
        if locale != '':
            print("Skipping non-default locale in extra directory: " + filename)
            continue
        pathname = os.path.join(extras_dir, filename)
        print("Processing translations in: " + pathname)
        new_properties = read_properties_from_file(pathname)
        incoming_properties.merge_with(new_properties, False, False)

    resource_files = enumerate_property_files(resources_dir)
    default_locale_filename = None
    for filename in resource_files:
        if find_locale(filename) == '':
            if default_locale_filename is not None:
                print("Found multiple default locale resources. Using: %s  (Disregarding: %s)" % (
                    default_locale_filename, filename))
                continue
            default_locale_filename = filename

    pathname = os.path.join(resources_dir, default_locale_filename)
    print("Merging all translations into default locale: " + pathname)
    default_locale_properties = read_properties_from_file(pathname)
    default_locale_properties.merge_with(incoming_properties, True, False)
    file = open(pathname, 'w')
    try:
        file.write(str(default_locale_properties))
    finally:
        file.close()

    for filename in resource_files:
        if find_locale(filename) != '':
            pathname = os.path.join(resources_dir, filename)
            print("Merging all translations into non-default locale: " + pathname)
            other_locale_properties = read_properties_from_file(pathname)
            other_locale_properties.merge_with(default_locale_properties, True, True)
            file = open(pathname, 'w')
            try:
                file.write(str(other_locale_properties))
            finally:
                file.close()

    if deprecated_comment_issued:
        print("Deprecated translations found. Look for: '%s'." % deprecatedComment.strip())
    if confirm_comment_issued:
        print("Some translations could require confirmation. Look for: '%s'." % confirmComment.strip())
    if translate_comment_issued:
        print("Some properties need to be translated. Look for: '%s'." % translateComment.strip())


if __name__ == "__main__":
    main()
