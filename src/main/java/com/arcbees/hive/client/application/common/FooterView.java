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

package com.arcbees.hive.client.application.common;

import com.arcbees.core.client.mvp.ViewImpl;
import com.arcbees.hive.client.application.common.FooterPresenter.MyView;

import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Christian Goudreau
 */
public class FooterView extends ViewImpl implements MyView {
  /**
   * This will provide a way to automatically create and inject the
   * {@link com.gwtplatform.mvp.client.View} instead of using directly
   * <code>gwt.create()</code>. You only have to inject it in the ctor.
   */
  public interface Binder extends UiBinder<Widget, FooterView> {
  }
  
  /**
   *  Template to build recent news link.
   */
  public interface RecentNewsTemplate extends SafeHtmlTemplates {
    @Template("<a href=\"{0}\">{1}</a>")
    SafeHtml link(String url, String linkText);
  }
  
  @UiField
  HTMLPanel recentNews;

  private final Provider<HTML> htmlProvider;
  private final RecentNewsTemplate recentNewsTemplate;
  
  @Inject
  public FooterView(final Binder uiBinder, final RecentNewsTemplate recentNewsTemplate, final Provider<HTML> htmlProvider) {
    initWidget(uiBinder.createAndBindUi(this));
    
    this.htmlProvider = htmlProvider;
    this.recentNewsTemplate = recentNewsTemplate;
  }

  @Override
  public void buildRecentNewsHyperlink(String display, String link) {
    HTML htmlLink = htmlProvider.get();
    
    htmlLink.setHTML(recentNewsTemplate.link(link, display));
    
    recentNews.add(htmlLink, recentNews.getElement());
  }
}
