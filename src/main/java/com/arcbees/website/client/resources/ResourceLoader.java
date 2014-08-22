/*
 * Copyright (c) 2014 by Roler Data Transfer Services, Inc., All rights reserved.
 * This source code, and resulting software, is the confidential and proprietary information
 * ("Proprietary Information") and is the intellectual property ("Intellectual Property")
 * of Roler Data Transfer Services, Inc. ("The Company"). You shall not disclose such Proprietary Information and
 * shall use it only in accordance with the terms and conditions of any and all license
 * agreements you have entered into with The Company.
 */

package com.arcbees.website.client.resources;

import javax.inject.Inject;

public class ResourceLoader {
    @Inject
    ResourceLoader(
            AppResources appResources,
            FontsResources fontsResources) {
        appResources.normalize().ensureInjected();
        appResources.style().ensureInjected();
        fontsResources.icons().ensureInjected();
    }
}
