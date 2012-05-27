/*
 * Copyright 2010 ArcBees Inc.
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

package com.arcbees.hive.client.home;

import com.arcbees.core.client.mvp.ViewWithUiHandlers;
import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.arcbees.hive.client.home.HomePresenter.MyView;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.Properties;
import com.google.gwt.query.client.plugins.effects.PropertiesAnimation.Easing;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.plugins.Effects.Effects;

/**
 * @author Christian Goudreau
 */
public class HomeView extends ViewWithUiHandlers<HomeUiHandlers> implements
    MyView {
  /**
   * {@link HomeView}'s {@link UiBinder}.
   */
  public interface Binder extends UiBinder<Widget, HomeView> {
  }

  @UiField
  HTMLPanel topPanel;
  @UiField
  HTMLPanel bottomPanel;
  @UiField
  SimplePanel panel1;
  @UiField
  SimplePanel panel2;
  @UiField
  SimplePanel panel3;
  @UiField
  SimplePanel panel4;
  @UiField
  AbsolutePanel resizablePanel;

  private final int panel1RightOffset = 0;
  private final int panel2RightOffset = 888;
  private final int panel3RightOffset = panel2RightOffset * 2;
  private final int panel4RightOffset = panel2RightOffset * 3;

  private int lastOffset = 0;

  @Inject
  public HomeView(final Binder uiBinder,
      UiHandlersStrategy<HomeUiHandlers> uiHandlersStrategy) {
    super(uiHandlersStrategy);

    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void setInSlot(Object slot, Widget content) {
    if (content != null) {
      if (slot == HomePresenter.TYPE_SetTopContent) {
        topPanel.clear();
        topPanel.add(content, topPanel.getElement());
      } else if (slot == HomePresenter.TYPE_SetBottomContent1) {
        getUiHandlers().clearSlot(HomePresenter.TYPE_SetBottomContent2);
        getUiHandlers().clearSlot(HomePresenter.TYPE_SetBottomContent3);
        getUiHandlers().clearSlot(HomePresenter.TYPE_SetBottomContent4);
        
        if (panel1.getWidget() == null) {
          panel1.add(content);
        }
      } else if (slot == HomePresenter.TYPE_SetBottomContent2) {
        getUiHandlers().clearSlot(HomePresenter.TYPE_SetBottomContent1);
        getUiHandlers().clearSlot(HomePresenter.TYPE_SetBottomContent3);
        getUiHandlers().clearSlot(HomePresenter.TYPE_SetBottomContent4);
        
        if (panel2.getWidget() == null) {
          panel2.add(content);
        }
      } else if (slot == HomePresenter.TYPE_SetBottomContent3) {
        getUiHandlers().clearSlot(HomePresenter.TYPE_SetBottomContent1);
        getUiHandlers().clearSlot(HomePresenter.TYPE_SetBottomContent2);
        getUiHandlers().clearSlot(HomePresenter.TYPE_SetBottomContent4);
        
        if (panel3.getWidget() == null) {
          panel3.add(content);
        }
      } else if (slot == HomePresenter.TYPE_SetBottomContent4) {
        getUiHandlers().clearSlot(HomePresenter.TYPE_SetBottomContent1);
        getUiHandlers().clearSlot(HomePresenter.TYPE_SetBottomContent2);
        getUiHandlers().clearSlot(HomePresenter.TYPE_SetBottomContent3);
        
        if (panel4.getWidget() == null) {
          panel4.add(content);
        }
      }
    }
  }

  private void move(final int offset, final int height) {
    int adjustedOffset = lastOffset - offset;

    getUiHandlers().resize(height + topPanel.getOffsetHeight());
    
    $(resizablePanel).as(Effects).animate(
        Properties.create("{ " + "height: '" + String.valueOf(height) + "px'}"),
        400, Easing.LINEAR, new Function() {
          @Override
          public void f(Element e) {
          }
        });
    
    $(bottomPanel).as(Effects).animate(
        Properties.create("{ " + "left: '+=" + String.valueOf(adjustedOffset)
            + "px'}"), 400, Easing.LINEAR, new Function() {
          @Override
          public void f(Element e) {
          }
        });

    lastOffset = offset;
  }

  @Override
  public void resizeSlot(Object slot, Integer size) {
    if (slot == HomePresenter.TYPE_SetBottomContent1) {
      move(panel1RightOffset, size);
    } else if (slot == HomePresenter.TYPE_SetBottomContent2) {
      move(panel2RightOffset, size);
    } else if (slot == HomePresenter.TYPE_SetBottomContent3) {
      move(panel3RightOffset, size);
    } else if (slot == HomePresenter.TYPE_SetBottomContent4) {
      move(panel4RightOffset, size);
    }
  }
}
