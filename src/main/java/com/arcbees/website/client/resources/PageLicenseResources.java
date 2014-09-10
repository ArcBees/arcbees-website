/*
 * Copyright 2014 ArcBees Inc.
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

import com.google.gwt.resources.client.GssResource;

public interface PageLicenseResources extends FontResources {
    interface Style extends GssResource {
        String license();

        String plan();

        String point();

        String billed();

        String price();

        String last();

        String featuredIcons();

        String bestbuy();

        String gwtp();

        String jukito();

        String chosen();

        String productSupport();

        String moreSupport();
    }

    @Source({"com/arcbees/gsss/mixin/client/mixins.gss", "css/colors.gss", "fonts/geometria/geometria.gss", "css/pages/license.gss"})
    Style style();
}
