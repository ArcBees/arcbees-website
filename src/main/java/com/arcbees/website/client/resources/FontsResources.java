/*
 * Copyright (c) 2014 by Roler Data Transfer Services, Inc., All rights reserved.
 * This source code, and resulting software, is the confidential and proprietary information
 * ("Proprietary Information") and is the intellectual property ("Intellectual Property")
 * of Roler Data Transfer Services, Inc. ("The Company"). You shall not disclose such Proprietary Information and
 * shall use it only in accordance with the terms and conditions of any and all license
 * agreements you have entered into with The Company.
 */

package com.arcbees.website.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.GssResource;

public interface FontsResources extends ClientBundle {
    public interface Icons extends GssResource {
    }

    @Source("fonts/icons/icons.ttf")
    DataResource iconsTtf();

    @Source("fonts/icons/icons.eot")
    DataResource iconsEot();

    @Source("fonts/icons/icons.svg")
    DataResource iconsSvg();

    @Source("fonts/icons/icons.woff")
    DataResource iconsWoff();

    @Source("fonts/icons/icons.gss")
    Icons icons();
}
