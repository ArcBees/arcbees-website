/*
 * Copyright 2015 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.arcbees.website.client.application.support;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Provider;

import com.arcbees.website.client.ExperimentHolder;
import com.google.common.collect.Lists;

public class SupportViewProvider implements Provider<SupportPresenter.MyView> {
    private final ExperimentHolder experimentHolder;
    private final List<SupportPresenter.MyView> views;

    @Inject
    SupportViewProvider(
            ExperimentHolder experimentHolder,
            Set<SupportPresenter.MyView> views) {
        this.experimentHolder = experimentHolder;
        this.views = Lists.newArrayList(views);
    }

    @Override
    public SupportPresenter.MyView get() {
        return views.get(experimentHolder.getVariationId());
    }
}
