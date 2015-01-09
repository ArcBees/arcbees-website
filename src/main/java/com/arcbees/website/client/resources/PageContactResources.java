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
    }

    @Source("img/pages/contactMapMarker.png")
    ImageResource marker();

    @Source({"com/arcbees/gsss/mixin/client/mixins.gss", "css/colors.gss", "fonts/geometria/geometria.gss", "css/pages/contact.gss"})
    Style style();
}
