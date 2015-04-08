package com.arcbees.website.client.application.support;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.plugins.effects.PropertiesAnimation;

public class ScrollToAnimation extends Animation {
   private final Element element;

   private int target;
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
