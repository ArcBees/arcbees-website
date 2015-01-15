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

package com.arcbees.website.client.application.contact;

import com.arcbees.website.client.application.maps.GwtMapsLoader;
import com.arcbees.website.client.resources.PageContactResources;
import com.google.gwt.ajaxloader.client.ArrayHelper;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.controls.ControlPosition;
import com.google.gwt.maps.client.controls.MapTypeControlOptions;
import com.google.gwt.maps.client.controls.MapTypeStyle;
import com.google.gwt.maps.client.controls.ZoomControlOptions;
import com.google.gwt.maps.client.maptypes.MapTypeStyleElementType;
import com.google.gwt.maps.client.maptypes.MapTypeStyleFeatureType;
import com.google.gwt.maps.client.maptypes.MapTypeStyler;
import com.google.gwt.maps.client.maptypes.StyledMapType;
import com.google.gwt.maps.client.maptypes.StyledMapTypeOptions;
import com.google.gwt.maps.client.overlays.Marker;
import com.google.gwt.maps.client.overlays.MarkerOptions;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class ContactView extends ViewImpl implements ContactPresenter.MyView {
    interface Binder extends UiBinder<Widget, ContactView> {
    }

    public final static String ARCBEES_MAPTYPE = "arcbeesMapStyle";

    @UiField
    SimplePanel container;
    @UiField
    PageContactResources page;

    private final PageContactResources pageContactResources;
    private final GwtMapsLoader gwtMapsLoader;

    @Inject
    ContactView(
            Binder binder,
            PageContactResources pageContactResources,
            GwtMapsLoader gwtMapsLoader) {
        this.pageContactResources = pageContactResources;
        this.gwtMapsLoader = gwtMapsLoader;

        initWidget(binder.createAndBindUi(this));
    }

    @Override
    public void drawMap() {
        if (container.getWidget() != null) {
            return;
        }

        gwtMapsLoader.loadGwtMaps(new Runnable() {
            @Override
            public void run() {
                onMapsLoaded();
            }
        });
    }

    private void onMapsLoaded() {
        // -- HOW TO STYLE A GOOGLE MAP
        // -> First, we create the style. To help : http://software.stadtwerk.org/google_maps_colorizr/
        MapTypeStyle style1 = MapTypeStyle.newInstance();
        style1.setElementType(MapTypeStyleElementType.GEOMETRY);
        style1.setFeatureType(MapTypeStyleFeatureType.ROAD);
        style1.setStylers(new MapTypeStyler[]{
                MapTypeStyler.newHueStyler("#FFF"),
                MapTypeStyler.newSaturationStyler(-100),
                MapTypeStyler.newLightnessStyler(100)
        });

        MapTypeStyle style2 = MapTypeStyle.newInstance();
        style2.setElementType(MapTypeStyleElementType.ALL);
        style2.setFeatureType(MapTypeStyleFeatureType.LANDSCAPE);
        style2.setStylers(new MapTypeStyler[]{
                MapTypeStyler.newHueStyler("#cccccc"),
                MapTypeStyler.newSaturationStyler(-100),
                MapTypeStyler.newLightnessStyler(-10)
        });

        MapTypeStyle style3 = MapTypeStyle.newInstance();
        style3.setElementType(MapTypeStyleElementType.ALL);
        style3.setFeatureType(MapTypeStyleFeatureType.POI);
        style3.setStylers(new MapTypeStyler[]{
                MapTypeStyler.newHueStyler("#f00"),
                MapTypeStyler.newSaturationStyler(-100),
                MapTypeStyler.newLightnessStyler(9),
        });

        MapTypeStyle style4 = MapTypeStyle.newInstance();
        style4.setElementType(MapTypeStyleElementType.ALL);
        style4.setFeatureType(MapTypeStyleFeatureType.WATER);
        style4.setStylers(new MapTypeStyler[]{
                MapTypeStyler.newHueStyler("#1c1c1c"),
                MapTypeStyler.newSaturationStyler(-100),
                MapTypeStyler.newLightnessStyler(86),
        });

        MapTypeStyle[] array = {style1, style2, style3, style4};

        JsArray<MapTypeStyle> styles = ArrayHelper.toJsArray(array);

        // -> Then we tell the map to use our new style by default
        MapTypeControlOptions controlOptions = MapTypeControlOptions.newInstance();
        controlOptions.setMapTypeIds(new String[]{});
        controlOptions.setPosition(ControlPosition.TOP_RIGHT);

        // -> And tell the map what our custom style is
        StyledMapTypeOptions styledMapTypeOptions = StyledMapTypeOptions.newInstance();
        styledMapTypeOptions.setName("Arcbees");
        StyledMapType customMapType = StyledMapType.newInstance(styles, styledMapTypeOptions);

        // -> Then we define our Lat and Long
        LatLng arcbeesCoord = LatLng.newInstance(46.792097, -71.285362);

        // -> Then goes the map options
        MapOptions options = MapOptions.newInstance();
        options.setCenter(arcbeesCoord);
        options.setZoom(16);
        options.setScrollWheel(false);
        options.setMapTypeControlOptions(controlOptions);
        options.setMapTypeId(ARCBEES_MAPTYPE);
        options.setPanControl(false);
        options.setDraggable(Window.getClientWidth() > 649);

        ZoomControlOptions zoomControlOptions = ZoomControlOptions.newInstance();
        zoomControlOptions.setPosition(ControlPosition.RIGHT_CENTER);
        options.setZoomControlOptions(zoomControlOptions);

        // -> We create the map with our options
        MapWidget mapWidget = new MapWidget(options);
        mapWidget.addStyleName(page.style().map());
        mapWidget.setCustomMapType(ARCBEES_MAPTYPE, customMapType);

        // -> We define the marker
        MarkerOptions markerOptions = MarkerOptions.newInstance();
        markerOptions.setIcon(pageContactResources.marker().getSafeUri().asString());
        markerOptions.setMap(mapWidget);
        markerOptions.setPosition(arcbeesCoord);

        Marker.newInstance(markerOptions);

        // -> And finally, add it to its container
        container.add(mapWidget);
    }
}
