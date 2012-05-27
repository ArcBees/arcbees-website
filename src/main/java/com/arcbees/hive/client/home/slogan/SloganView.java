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

package com.arcbees.hive.client.home.slogan;

import com.arcbees.core.client.mvp.ViewWithUiHandlers;
import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.arcbees.hive.client.home.slogan.SloganPresenter.MyView;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.query.client.Function;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import static com.google.gwt.query.client.GQuery.$;

/**
 * @author Christian Goudreau
 * @author Zachary Keatts
 */
public class SloganView extends ViewWithUiHandlers<SloganUiHandlers> implements
    MyView {
  /**
   * This will provide a way to automatically create and inject the
   * {@link com.gwtplatform.mvp.client.View} instead of using directly
   * <code>gwt.create()</code>. You only have to inject it in the ctor.
   */
  public interface Binder extends UiBinder<Widget, SloganView> {
  }

  @UiField
  HTML fadeBlockOne;
  @UiField
  HTML fadeBlockTwo;

  private Integer fadeDelay = 250;
  private Boolean blockFade = false;
  private String lastDesc = "";

  /**
   * {@link Function} that insure that we wait until every fade animation is
   * finished before unblocking upcoming fade animation.
   */
  private Function fadeFunction = new Function() {
    @Override
    public void f(Element e) {
      blockFade = false;
    }
  };

  @Inject
  public SloganView(final Binder uiBinder,
      final UiHandlersStrategy<SloganUiHandlers> uiHandlersStrategy) {
    super(uiHandlersStrategy);

    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void fadeDescription(SafeHtml desc) {
    // Make sure that fading effect isn't blocked.
    if (!blockFade && !lastDesc.equals(desc.toString())) {
      lastDesc = desc.toString();

      if (fadeBlockTwo.isVisible() && !fadeBlockOne.isVisible()) {
        switchFade(fadeBlockOne, fadeBlockTwo.getElement(), desc);
      } else if (!fadeBlockTwo.isVisible()) {
        switchFade(fadeBlockTwo, fadeBlockOne.getElement(), desc);
      }
    }
  }

  @UiHandler("consulting")
  void onConsultingClicked(ClickEvent e) {
    getUiHandlers().showConsultingSection();
  }

  @UiHandler("development")
  void onDevelopmentClicked(ClickEvent e) {
    getUiHandlers().showDevelopmentSection();
  }

  @UiHandler("success")
  void onSuccessClicked(ClickEvent event) {
    getUiHandlers().showSuccessStorySection();
  }

  /**
   * Used to start the animation that switch the opacity of the two fade block.
   * 
   * @param fadeBlock The fade block to show.
   * @param element The {@link Element} of the second block to hide.
   * @param desc The description of the first block to set.
   */
  private void switchFade(HTML fadeBlock, Element element, SafeHtml desc) {
    fadeBlock.setHTML(desc);

    if (fadeBlock.isAttached()) {
      blockFade = true;

      $(fadeBlock).fadeIn(fadeDelay, fadeFunction);
      $(element).fadeOut(fadeDelay, fadeFunction);
    } else {
      fadeBlockOne.setVisible(false);
      fadeBlockTwo.setVisible(false);

      fadeBlock.setVisible(true);
    }
  }
}
