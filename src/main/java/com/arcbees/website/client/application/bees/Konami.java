/**
 * Copyright 2015 ArcBees Inc.
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

package com.arcbees.website.client.application.bees;

import javax.inject.Inject;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.google.web.bindery.event.shared.EventBus;

public class Konami implements HasHandlers {
    private final EventBus eventBus;

    String script = "/*\n" +
            " * Konami-JS ~ \n" +
            " * :: Now with support for touch events and multiple instances for \n" +
            " * :: those situations that call for multiple easter eggs!\n" +
            " * Code: http://konami-js.googlecode.com/\n" +
            " * Examples: http://www.snaptortoise.com/konami-js\n" +
            " * Copyright (c) 2009 George Mandis (georgemandis.com, snaptortoise.com)\n" +
            " * Version: 1.4.2 (9/2/2013)\n" +
            " * Licensed under the MIT License (http://opensource.org/licenses/MIT)\n" +
            " * Tested in: Safari 4+, Google Chrome 4+, Firefox 3+, IE7+, Mobile Safari 2.2.1 and Dolphin Browser\n" +
            " */\n" +
            "\n" +
            "var Konami = function (callback) {\n" +
            "\tvar konami = {\n" +
            "\t\taddEvent: function (obj, type, fn, ref_obj) {\n" +
            "\t\t\tif (obj.addEventListener)\n" +
            "\t\t\t\tobj.addEventListener(type, fn, false);\n" +
            "\t\t\telse if (obj.attachEvent) {\n" +
            "\t\t\t\t// IE\n" +
            "\t\t\t\tobj[\"e\" + type + fn] = fn;\n" +
            "\t\t\t\tobj[type + fn] = function () {\n" +
            "\t\t\t\t\tobj[\"e\" + type + fn](window.event, ref_obj);\n" +
            "\t\t\t\t}\n" +
            "\t\t\t\tobj.attachEvent(\"on\" + type, obj[type + fn]);\n" +
            "\t\t\t}\n" +
            "\t\t},\n" +
            "\t\tinput: \"\",\n" +
            "\t\tpattern: \"38384040373937396665\",\n" +
            "\t\tload: function (link) {\n" +
            "\t\t\tthis.addEvent(document, \"keydown\", function (e, ref_obj) {\n" +
            "\t\t\t\tif (ref_obj) konami = ref_obj; // IE\n" +
            "\t\t\t\tkonami.input += e ? e.keyCode : event.keyCode;\n" +
            "\t\t\t\tif (konami.input.length > konami.pattern.length)\n" +
            "\t\t\t\t\tkonami.input = konami.input.substr((konami.input.length - konami.pattern.length));\n" +
            "\t\t\t\tif (konami.input == konami.pattern) {\n" +
            "\t\t\t\t\tkonami.code(link);\n" +
            "\t\t\t\t\tkonami.input = \"\";\n" +
            "\t\t\t\t\te.preventDefault();\n" +
            "\t\t\t\t\treturn false;\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}, this);\n" +
            "\t\t\tthis.iphone.load(link);\n" +
            "\t\t},\n" +
            "\t\tcode: function (link) {\n" +
            "\t\t\twindow.location = link\n" +
            "\t\t},\n" +
            "\t\tiphone: {\n" +
            "\t\t\tstart_x: 0,\n" +
            "\t\t\tstart_y: 0,\n" +
            "\t\t\tstop_x: 0,\n" +
            "\t\t\tstop_y: 0,\n" +
            "\t\t\ttap: false,\n" +
            "\t\t\tcapture: false,\n" +
            "\t\t\torig_keys: \"\",\n" +
            "\t\t\tkeys: [\"UP\", \"UP\", \"DOWN\", \"DOWN\", \"LEFT\", \"RIGHT\", \"LEFT\", \"RIGHT\", \"TAP\", " +
            "\"TAP\"],\n" +
            "\t\t\tcode: function (link) {\n" +
            "\t\t\t\tkonami.code(link);\n" +
            "\t\t\t},\n" +
            "\t\t\tload: function (link) {\n" +
            "\t\t\t\tthis.orig_keys = this.keys;\n" +
            "\t\t\t\tkonami.addEvent(document, \"touchmove\", function (e) {\n" +
            "\t\t\t\t\tif (e.touches.length == 1 && konami.iphone.capture == true) {\n" +
            "\t\t\t\t\t\tvar touch = e.touches[0];\n" +
            "\t\t\t\t\t\tkonami.iphone.stop_x = touch.pageX;\n" +
            "\t\t\t\t\t\tkonami.iphone.stop_y = touch.pageY;\n" +
            "\t\t\t\t\t\tkonami.iphone.tap = false;\n" +
            "\t\t\t\t\t\tkonami.iphone.capture = false;\n" +
            "\t\t\t\t\t\tkonami.iphone.check_direction();\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t});\n" +
            "\t\t\t\tkonami.addEvent(document, \"touchend\", function (evt) {\n" +
            "\t\t\t\t\tif (konami.iphone.tap == true) konami.iphone.check_direction(link);\n" +
            "\t\t\t\t}, false);\n" +
            "\t\t\t\tkonami.addEvent(document, \"touchstart\", function (evt) {\n" +
            "\t\t\t\t\tkonami.iphone.start_x = evt.changedTouches[0].pageX;\n" +
            "\t\t\t\t\tkonami.iphone.start_y = evt.changedTouches[0].pageY;\n" +
            "\t\t\t\t\tkonami.iphone.tap = true;\n" +
            "\t\t\t\t\tkonami.iphone.capture = true;\n" +
            "\t\t\t\t});\n" +
            "\t\t\t},\n" +
            "\t\t\tcheck_direction: function (link) {\n" +
            "\t\t\t\tx_magnitude = Math.abs(this.start_x - this.stop_x);\n" +
            "\t\t\t\ty_magnitude = Math.abs(this.start_y - this.stop_y);\n" +
            "\t\t\t\tx = ((this.start_x - this.stop_x) < 0) ? \"RIGHT\" : \"LEFT\";\n" +
            "\t\t\t\ty = ((this.start_y - this.stop_y) < 0) ? \"DOWN\" : \"UP\";\n" +
            "\t\t\t\tresult = (x_magnitude > y_magnitude) ? x : y;\n" +
            "\t\t\t\tresult = (this.tap == true) ? \"TAP\" : result;\n" +
            "\n" +
            "\t\t\t\tif (result == this.keys[0]) this.keys = this.keys.slice(1, this.keys.length);\n" +
            "\t\t\t\tif (this.keys.length == 0) {\n" +
            "\t\t\t\t\tthis.keys = this.orig_keys;\n" +
            "\t\t\t\t\tthis.code(link);\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t}\n" +
            "\n" +
            "\ttypeof callback === \"string\" && konami.load(callback);\n" +
            "\tif (typeof callback === \"function\") {\n" +
            "\t\tkonami.code = callback;\n" +
            "\t\tkonami.load();\n" +
            "\t}\n" +
            "\n" +
            "\treturn konami;\n" +
            "};" +
            "";

    @Inject
    Konami(EventBus eventBus) {
        this.eventBus = eventBus;
        ScriptInjector.fromString(script)
                .setWindow(ScriptInjector.TOP_WINDOW).inject();
        bind(this);
    }

    public native void bind(Konami konami) /*-{
        $wnd.Konami(function () {
            konami.@com.arcbees.website.client.application.bees.Konami::onKonami()()
        });
    }-*/;

    @Override
    public void fireEvent(GwtEvent<?> event) {
        eventBus.fireEvent(event);
    }

    private void onKonami() {
        KonamiEvent.fire(this);
    }
}
