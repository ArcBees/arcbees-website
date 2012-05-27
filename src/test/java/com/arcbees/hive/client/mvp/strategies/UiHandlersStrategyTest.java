///*
// * Copyright 2010 ArcBees Inc.
// *
// * Licensed under the Apache License, Version 2.0 (the "License"); you may not
// * use this file except in compliance with the License. You may obtain a copy of
// * the License at
// *
// * http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
// * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
// * License for the specific language governing permissions and limitations under
// * the License.
// */
//
//package com.arcbees.hive.client.mvp.strategies;
//
//import com.arcbees.hive.client.mvp.strategies.UiHandlersStrategyTest.ProvidedDummyView.ProvidedUiHandlers;
//import com.arcbees.hive.client.mvp.strategies.UiHandlersStrategyTest.SettedDummyView.SettedUiHandlers;
//import com.arcbees.hive.client.mvp.strategies.uihandlers.ProviderUiHandlersStrategy;
//import com.arcbees.hive.client.mvp.strategies.uihandlers.SetterUiHandlersStrategy;
//
//import com.google.inject.Inject;
//import com.google.inject.TypeLiteral;
//
//import com.gwtplatform.mvp.client.UiHandlers;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.mockito.Mockito.verify;
//
//import org.jukito.JukitoModule;
//import org.jukito.JukitoRunner;
//import org.jukito.TestSingleton;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
///**
// * This unit test look if every {@link UiHandlersStrategy}s are working as
// * expected.
// *
// * @author Christian Goudreau
// */
//@RunWith(JukitoRunner.class)
//public class UiHandlersStrategyTest {
//  /**
//   * Guice test module.
//   */
//  public static class Module extends JukitoModule {
//    @Override
//    protected void configureTest() {
//      bind(new TypeLiteral<UiHandlersStrategy<ProvidedUiHandlers>>() {
//      }).to(new TypeLiteral<ProviderUiHandlersStrategy<ProvidedUiHandlers>>() {
//      }).in(TestSingleton.class);
//      bind(new TypeLiteral<UiHandlersStrategy<SettedUiHandlers>>() {
//      }).to(new TypeLiteral<SetterUiHandlersStrategy<SettedUiHandlers>>() {
//      }).in(TestSingleton.class);
//
//      bindMock(ProvidedUiHandlers.class).in(TestSingleton.class);
//      bindMock(SettedUiHandlers.class).in(TestSingleton.class);
//
//      bind(ProvidedDummyView.class).in(TestSingleton.class);
//      bind(SettedDummyView.class).in(TestSingleton.class);
//    }
//  }
//
//  abstract static class DummyViewWithUiHandler<H extends UiHandlers> implements
//      UiHandlersStrategy<H> {
//    private final UiHandlersStrategy<H> uiHandlersStrategy;
//
//    @Inject
//    public DummyViewWithUiHandler(UiHandlersStrategy<H> uiHandlersStrategy) {
//      this.uiHandlersStrategy = uiHandlersStrategy;
//    }
//
//    @Override
//    public void setUiHandlers(H uiHandlers) {
//      uiHandlersStrategy.setUiHandlers(uiHandlers);
//    }
//
//    @Override
//    public H getUiHandlers() {
//      return uiHandlersStrategy.getUiHandlers();
//    }
//  }
//
//  static class ProvidedDummyView extends
//      DummyViewWithUiHandler<ProvidedDummyView.ProvidedUiHandlers> {
//    interface ProvidedUiHandlers extends UiHandlers {
//      void onSomethingHappenned();
//    }
//
//    @Inject
//    public ProvidedDummyView(
//        UiHandlersStrategy<ProvidedUiHandlers> uiHandlersStrategy) {
//      super(uiHandlersStrategy);
//    }
//  }
//
//  static class SettedDummyView extends
//      DummyViewWithUiHandler<SettedDummyView.SettedUiHandlers> {
//    interface SettedUiHandlers extends UiHandlers {
//      void onSomethingHappened();
//    }
//
//    @Inject
//    public SettedDummyView(
//        UiHandlersStrategy<SettedUiHandlers> uiHandlersStrategy) {
//      super(uiHandlersStrategy);
//    }
//  }
//
//  @Test
//  public void testProvidedUiHandlers(ProvidedDummyView providedDummyView,
//      ProvidedUiHandlers myProvidedUiHandlers) {
//    assertNotNull(providedDummyView.getUiHandlers());
//
//    providedDummyView.getUiHandlers().onSomethingHappenned();
//
//    verify(myProvidedUiHandlers).onSomethingHappenned();
//  }
//
//  @Test
//  public void testSettedUiHandlers(SettedDummyView settedDummyView,
//      SettedUiHandlers mySettedUiHandlers) {
//    assertNull(settedDummyView.getUiHandlers());
//
//    settedDummyView.setUiHandlers(mySettedUiHandlers);
//
//    assertNotNull(settedDummyView.getUiHandlers());
//
//    settedDummyView.getUiHandlers().onSomethingHappened();
//
//    verify(mySettedUiHandlers).onSomethingHappened();
//  }
//}
