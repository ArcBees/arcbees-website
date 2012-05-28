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

package com.arcbees.hive.client.application.home.slogan;

import com.arcbees.hive.client.place.NameTokens;
import com.arcbees.hive.client.resources.Resources;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

/**
 * @author Christian Goudreau
 * @author Zachary Keatts
 */
public class SloganPresenter extends PresenterWidget<SloganPresenter.MyView>
    implements SloganUiHandlers {

  /**
   * {@link SloganPresenter}'s view.
   */
  public interface MyView extends View {

    /**
     * A description is activated at all times for the slogan. This method is in
     * charge of changing that description as well as managing the special
     * effects
     * 
     * @param description Description to set the Slogan Descriptor to.
     */
    void fadeDescription(SafeHtml description);
  }

  /**
   * Description HTML template to set up in the fading slogan section.
   */
  public interface DescriptionTemplate extends SafeHtmlTemplates {
    @Template("<div><div class='{0}'></div><div class='{1}'></div>"
        + "<div class='{2}'></div><div class='{3}'>{4}</div></div>")
    SafeHtml applyTemplate(String leftStyle, String middleString,
        String rightStyle, String descriptionStyle, String test);
  }

  private final DescriptionTemplate descriptionTemplate;
  private final Resources resources;
  private final PlaceManager placeManager;

  private final String defaultDescription = "Our blog";
  private final String consultingDescription = "We join your team and increase productivity";
  private final String developmentDescripton = "We work hand in hand to build your project";
  private final String sucessDescription = "We make things happen";

  @Inject
  public SloganPresenter(final EventBus eventBus, final MyView view,
      final DescriptionTemplate descriptionTemplate, final Resources resources,
      final PlaceManager placeManager) {
    super(eventBus, view);

    this.descriptionTemplate = descriptionTemplate;
    this.resources = resources;
    this.placeManager = placeManager;
  }

  public void defaultDescription() {
    getView().fadeDescription(
        descriptionTemplate.applyTemplate(resources.style().bodBarMidG(),
            resources.style().bodBarDroiteG(),
            resources.style().bodBarGaucheG(),
            resources.style().sloganDescription(), defaultDescription));
  }

  public void showConsulting() {
    getView().fadeDescription(
        descriptionTemplate.applyTemplate(resources.style().bodBarMidB(),
            resources.style().bodBarDroiteB(),
            resources.style().bodBarGaucheB(),
            resources.style().sloganDescription(), consultingDescription));
  }

  public void showDevelopment() {
    getView().fadeDescription(
        descriptionTemplate.applyTemplate(resources.style().bodBarMidV(),
            resources.style().bodBarDroiteV(),
            resources.style().bodBarGaucheV(),
            resources.style().sloganDescription(), developmentDescripton));
  }

  public void showSuccess() {
    getView().fadeDescription(
        descriptionTemplate.applyTemplate(resources.style().bodBarMidO(),
            resources.style().bodBarDroiteO(),
            resources.style().bodBarGaucheO(),
            resources.style().sloganDescription(), sucessDescription));
  }

  @Override
  public void showConsultingSection() {
    PlaceRequest request = new PlaceRequest(NameTokens.consulting);

    placeManager.revealPlace(request);
  }

  @Override
  public void showDevelopmentSection() {
    PlaceRequest request = new PlaceRequest(NameTokens.development);

    placeManager.revealPlace(request);
  }

  @Override
  public void showSuccessStorySection() {
    PlaceRequest request = new PlaceRequest(NameTokens.successStory);

    placeManager.revealPlace(request);
  }
}
