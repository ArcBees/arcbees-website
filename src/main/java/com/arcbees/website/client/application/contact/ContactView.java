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

package com.arcbees.website.client.application.contact;

import com.google.gwt.ajaxloader.client.ArrayHelper;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapTypeId;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.controls.MapTypeControlOptions;
import com.google.gwt.maps.client.controls.MapTypeStyle;
import com.google.gwt.maps.client.maptypes.MapTypeStyleElementType;
import com.google.gwt.maps.client.maptypes.MapTypeStyleFeatureType;
import com.google.gwt.maps.client.maptypes.MapTypeStyler;
import com.google.gwt.maps.client.maptypes.StyledMapType;
import com.google.gwt.maps.client.maptypes.StyledMapTypeOptions;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class ContactView extends ViewImpl implements ContactPresenter.MyView {
    interface Binder extends UiBinder<Widget, ContactView> {
    }

    public final static String MY_COOL_MAPTYPE = "eyeBleedMap";

    @UiField
    SimplePanel container;

    @Inject
    ContactView(
            Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }

    @Override
    public void drawMap() {
        MapTypeStyle style1 = MapTypeStyle.newInstance();
        style1.setElementType(MapTypeStyleElementType.GEOMETRY);
        style1.setFeatureType(MapTypeStyleFeatureType.ROAD);
        style1.setStylers(new MapTypeStyler[] {
                MapTypeStyler.newHueStyler("#FFF"),
                MapTypeStyler.newSaturationStyler(-100),
                MapTypeStyler.newLightnessStyler(100)
        });

        MapTypeStyle style2 = MapTypeStyle.newInstance();
        style2.setElementType(MapTypeStyleElementType.ALL);
        style2.setFeatureType(MapTypeStyleFeatureType.LANDSCAPE);
        style2.setStylers(new MapTypeStyler[] {
                MapTypeStyler.newHueStyler("#fbe605"),
                MapTypeStyler.newSaturationStyler(96),
                MapTypeStyler.newLightnessStyler(-44)
        });

        MapTypeStyle style3 = MapTypeStyle.newInstance();
        style3.setElementType(MapTypeStyleElementType.ALL);
        style3.setFeatureType(MapTypeStyleFeatureType.POI);
        style3.setStylers(new MapTypeStyler[] {
                MapTypeStyler.newHueStyler("#f00"),
                MapTypeStyler.newSaturationStyler(-100),
                MapTypeStyler.newLightnessStyler(9),
        });

        MapTypeStyle style4 = MapTypeStyle.newInstance();
        style4.setElementType(MapTypeStyleElementType.ALL);
        style4.setFeatureType(MapTypeStyleFeatureType.WATER);
        style4.setStylers(new MapTypeStyler[] {
                MapTypeStyler.newHueStyler("#1c1c1c"),
                MapTypeStyler.newSaturationStyler(-100),
                MapTypeStyler.newLightnessStyler(86),
        });

        MapTypeStyle[] array = { style1, style2, style3, style4 };

        JsArray<MapTypeStyle> styles = ArrayHelper.toJsArray(array);

        MapTypeControlOptions controlOptions = MapTypeControlOptions.newInstance();
        controlOptions.setMapTypeIds(new String[] { MapTypeId.ROADMAP.toString(), MY_COOL_MAPTYPE });

        MapOptions options = MapOptions.newInstance();
        options.setCenter(LatLng.newInstance(46.792136, -71.287528));
        options.setZoom(16);
        options.setMapTypeId(MapTypeId.ROADMAP);
        options.setMapTypeControlOptions(controlOptions);
        options.setMapTypeId(MY_COOL_MAPTYPE);

        StyledMapTypeOptions styledMapTypeOptions = StyledMapTypeOptions.newInstance();
        StyledMapType customMapType = StyledMapType.newInstance(styles, styledMapTypeOptions);

        MapWidget mapWidget = new MapWidget(options);

        mapWidget.setSize("100%", "400px");

        mapWidget.setCustomMapType(MY_COOL_MAPTYPE, customMapType);

        container.add(mapWidget);
    }
}
