/*
 * Copyright (c) 2014 by Roler Data Transfer Services, Inc., All rights reserved.
 * This source code, and resulting software, is the confidential and proprietary information
 * ("Proprietary Information") and is the intellectual property ("Intellectual Property")
 * of Roler Data Transfer Services, Inc. ("The Company"). You shall not disclose such Proprietary Information and
 * shall use it only in accordance with the terms and conditions of any and all license
 * agreements you have entered into with The Company.
 */

package com.arcbees.website.client.resources;

import com.arcbees.gquery.tooltip.client.TooltipResources;

public interface PageBeesTooltipResources extends TooltipResources {
    interface Style extends TooltipStyle {
    }

    @Override
    @Source({"com/arcbees/gquery/tooltip/client/Tooltip.css", "css/pages/beesTooltip.css"})
    Style css();
}
