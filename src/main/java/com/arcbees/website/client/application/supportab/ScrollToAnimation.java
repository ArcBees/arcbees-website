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

package com.arcbees.website.client.application.supportab;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.plugins.effects.PropertiesAnimation;

public class ScrollToAnimation extends Animation {
   private final Element element;

   private final int target;
   private int start;
   private int gap;

   public ScrollToAnimation(Element element, int target) {
       this.element = element;
       this.target = target;
   }

   @Override
   protected void onStart() {
       start = element.getScrollTop();

       gap = Math.abs(target - start);
       super.onStart();
   }

   @Override
   protected void onUpdate(double progress) {
       double value;
       if (target < start) {
           value = start - gap * progress;
       } else {
           value = start + gap * progress;
       }
       element.setScrollTop((int) value);
   }

   @Override
   protected double interpolate(double progress) {
       return PropertiesAnimation.EasingCurve.easeInOut.interpolate(progress);
   }
}
