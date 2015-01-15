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

package com.arcbees.website.client.resources;

import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface PageContactResources extends FontResources {
    interface Style extends CssResource {
        String contact();

        String social();

        String headerBg();

        String quebec();

        String workWithUs();

        String contactSlider();

        String map();
    }

    @Source("img/pages/contactMapMarker.png")
    ImageResource marker();

    @Source("img/pages/contact1.jpg")
    ImageResource contact1();

    @Source("img/pages/contact2.jpg")
    ImageResource contact2();

    @Source("img/pages/contact3.jpg")
    ImageResource contact3();

    @Source("img/pages/contact4.jpg")
    ImageResource contact4();

    @Source("img/pages/contact5.jpg")
    ImageResource contact5();

    @Source("img/pages/contact6.jpg")
    ImageResource contact6();

    @Source("img/pages/contact7.jpg")
    ImageResource contact7();

    @Source("img/pages/contact8.jpg")
    ImageResource contact8();

    @Source("img/pages/contact9.jpg")
    ImageResource contact9();

    @Source("img/pages/contact10.jpg")
    ImageResource contact10();

    @Source("img/pages/contact11.jpg")
    ImageResource contact11();

    @Source("img/pages/contact12.jpg")
    ImageResource contact12();

    @Source("img/pages/contact13.jpg")
    ImageResource contact13();

    @Source("img/pages/contact14.jpg")
    ImageResource contact14();

    @Source("img/pages/contact15.jpg")
    ImageResource contact15();

    @Source("img/pages/contact16.jpg")
    ImageResource contact16();

    @Source("img/pages/contact11.jpg")
    ImageResource contact17();

    @Source({"com/arcbees/gsss/mixin/client/mixins.gss", "css/colors.gss", "fonts/geometria/geometria.gss", "css/pages/contact.gss"})
    Style style();
}
