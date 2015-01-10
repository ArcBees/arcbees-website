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

package com.arcbees.website.client.application;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.plugins.effects.PropertiesAnimation;

class ScrollTopAnimation extends Animation {
    private Element element;
    private int start;

    public ScrollTopAnimation(Element element) {
        this.element = element;
    }

    @Override
    protected void onStart() {
        start = element.getScrollTop();
        super.onStart();
    }

    @Override
    protected void onUpdate(double progress) {
        double value = start - start * progress;
        element.setScrollTop((int) value);
    }

    @Override
    protected double interpolate(double progress) {
        return PropertiesAnimation.EasingCurve.easeInOut.interpolate(progress);
    }
}
