/**
 * Copyright 2015 Arcbees
 * Copyright 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.arcbees.website.rebind;

import java.io.IOException;
import java.io.PrintWriter;

import com.arcbees.website.shared.NameTokens;
import com.google.gwt.i18n.server.DefaultVisitor;
import com.google.gwt.i18n.server.Message;
import com.google.gwt.i18n.server.MessageCatalogFactory;
import com.google.gwt.i18n.server.MessageFormatUtils;
import com.google.gwt.i18n.server.MessageInterface;
import com.google.gwt.i18n.server.MessageInterfaceVisitor;
import com.google.gwt.i18n.server.MessageTranslation;
import com.google.gwt.i18n.server.MessageVisitor;
import com.google.gwt.i18n.shared.GwtLocale;

public class NameTokenFrGenerator implements MessageCatalogFactory {
    private static class PropertiesWriter extends DefaultVisitor implements Writer {
        private static String stringJoin(String joiner, String... values) {
            StringBuilder buf = new StringBuilder();
            boolean needsJoiner = false;
            for (String value : values) {
                if (needsJoiner) {
                    buf.append(joiner);
                } else {
                    needsJoiner = true;
                }
                buf.append(value);
            }
            return buf.toString();
        }

        private final PrintWriter writer;

        private String baseKey;

        public PropertiesWriter(PrintWriter writer) {
            this.writer = writer;
        }

        public void close() throws IOException {
            writer.close();
        }

        @Override
        public void endMessage(Message msg, MessageTranslation trans) {
            baseKey = null;
        }

        public MessageInterfaceVisitor visitClass() {
            return this;
        }

        @Override
        public MessageVisitor visitMessage(Message msg, MessageTranslation trans) {
            String description = msg.getDescription();
            if (description != null) {
                writer.println("# Description: " + description);
            }

            String meaning = msg.getMeaning();
            if (meaning != null) {
                writer.println("# Meaning: " + meaning);
            }

            baseKey = quoteKey(msg.getKey());

            String value;
            try {
                value = (String) NameTokens.class.getField(
                        msg.getKey().toUpperCase() + "_" + trans.getMatchedLocale().getLanguage().toUpperCase())
                        .get(null);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                value = msg.getDefaultMessage();
            }

            writer.println(baseKey + "=" + propertiesMessage(value, msg.getDefaultMessage()));

            return this;
        }

        @Override
        public void visitMessageInterface(MessageInterface msgIntf, GwtLocale sourceLocale) {
            writer.println("# Messages from " + msgIntf.getQualifiedName());
            writer.println();
        }

        @Override
        public void visitTranslation(String[] formNames, boolean isDefault,
                MessageFormatUtils.MessageStyle style, String msg) {
            if (isDefault) {
                // default message is processed in processDefaultMessageBefore
                return;
            }

            if (msg == null) {
                msg = "";
            }

            String key = baseKey;
            key += "[" + stringJoin("|", formNames) + "]";
            writer.println(key + "=" + propertiesMessage(msg, msg));
        }

        private String propertiesMessage(String value, String defaultMessage) {
            if (value == null) {
                value = defaultMessage;
            }

            return quoteValue(value);
        }

        /**
         * Quote keys for use in a properties file.
         * <p/>
         * In addition to the usual quoting, all spaces are backslash-quoted.
         *
         * @param str key to quote
         * @return quoted key
         */
        private String quoteKey(String str) {
            str = str.replace("\\", "\\\\");
            str = str.replace(" ", "\\ ");
            return quoteSpecial(str);
        }

        /**
         * Quote strings for use in a properties file.
         *
         * @param str string to quote
         * @return quoted string
         */
        private String quoteSpecial(String str) {
            return str.replaceAll("([\f\t\n\r$!=:#])", "\\\\$1");
        }

        /**
         * Quote values for use in a properties file.
         * <p/>
         * In addition to the usual quoting, leading spaces are backslash-quoted.
         *
         * @param str value to quote
         * @return quoted value
         */
        private String quoteValue(String str) {
            str = str.replace("\\", "\\\\");
            if (str.startsWith(" ")) {
                int n = 0;
                while (n < str.length() && str.charAt(n) == ' ') {
                    n++;
                }
                str = str.substring(n);
                while (n-- > 0) {
                    str = "\\ " + str;
                }
            }
            return quoteSpecial(str);
        }
    }

    public String getExtension() {
        return ".properties";
    }

    public Writer getWriter(Context context, String fileName) {
        PrintWriter pw = context.createTextFile(fileName, "UTF-8");

        if (pw == null) {
            return null;
        }

        return new PropertiesWriter(pw);
    }
}
