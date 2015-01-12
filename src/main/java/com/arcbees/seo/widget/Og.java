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

package com.arcbees.seo.widget;

public class Og extends ContainerNode {
    private OgImage image;
    private OgType ogType;

    public void add(OgImage image) {
        this.image = image;
    }

    public void add(OgType ogType) {
        this.ogType = ogType;
    }

    public OgImage getImage() {
        return image;
    }

    public OgType getOgType() {
        return ogType;
    }
}
