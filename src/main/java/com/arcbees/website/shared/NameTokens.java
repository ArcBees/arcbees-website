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

package com.arcbees.website.shared;

import java.util.Map;

import javax.inject.Inject;

import com.arcbees.website.client.NameTokensConstants;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

public class NameTokens {
    public static final String HOME = "!/";
    public static final String BEES = "!/bees";
    public static final String BEES_FR = "!/abeilles";
    public static final String CAREERS = "!/careers";
    public static final String CAREERS_FR = "!/carrieres";
    public static final String CONTACT = "!/contact";
    public static final String CONTACT_FR = "!/contact";
    public static final String EXPERTISE = "!/expertise";
    public static final String EXPERTISE_FR = "!/expertise";
    public static final String SUPPORT = "!/support";
    public static final String SUPPORT_FR = "!/support";
    public static final String SHOP = "!/shop";
    public static final String SHOP_FR = "!/boutique";
    public static final String SERVICES = "!/services";
    public static final String SERVICES_FR = "!/services";

    public static final String PRODUCTS_BASE = "!/products";
    public static final String PRODUCTS_BASE_FR = "!/produits";
    public static final String GAE = PRODUCTS_BASE + "/gae-studio";
    public static final String GAE_FR = PRODUCTS_BASE_FR + "/gae-studio";
    public static final String CHOSEN = PRODUCTS_BASE + "/chosen";
    public static final String CHOSEN_FR = PRODUCTS_BASE_FR + "/chosen";
    public static final String JUKITO = PRODUCTS_BASE + "/jukito";
    public static final String JUKITO_FR = PRODUCTS_BASE_FR + "/jukito";
    public static final String GWTP = PRODUCTS_BASE + "/gwtp";
    public static final String GWTP_FR = PRODUCTS_BASE_FR + "/gwtp";
    public static final String GQUERY = PRODUCTS_BASE + "/gquery";
    public static final String GQUERY_FR = PRODUCTS_BASE_FR + "/gquery";
    public static final String PRODUCTS = GWTP;
    public static final String PRODUCTS_FR = GWTP_FR;

    public static final String BEE_CHRISTIAN = BEES + "/christian-goudreau";
    public static final String BEE_CHRISTIAN_FR = BEES_FR + "/christian-goudreau";
    public static final String BEE_CHRISTOPHER = BEES + "/christopher-viel";
    public static final String BEE_CHRISTOPHER_FR = BEES_FR + "/christopher-viel";
    public static final String BEE_FRANCOIS = BEES + "/francois-dion";
    public static final String BEE_FRANCOIS_FR = BEES_FR + "/francois-dion";
    public static final String BEE_GENEVIEVE = BEES + "/genevieve-doyle";
    public static final String BEE_GENEVIEVE_FR = BEES_FR + "/genevieve-doyle";
    public static final String BEE_JASON = BEES + "/jason-lemay";
    public static final String BEE_JASON_FR = BEES_FR + "/jason-lemay";
    public static final String BEE_JEANCHRISTOPHE = BEES + "/jean-christophe-lariviere";
    public static final String BEE_JEANCHRISTOPHE_FR = BEES_FR + "/jean-christophe-lariviere";
    public static final String BEE_JOEL = BEES + "/joel-trottier-hebert";
    public static final String BEE_JOEL_FR = BEES_FR + "/joel-trottier-hebert";
    public static final String BEE_JULIEN = BEES + "/julien-dramaix";
    public static final String BEE_JULIEN_FR = BEES_FR + "/julien-dramaix";
    public static final String BEE_LARRY = BEES + "/larry-matte";
    public static final String BEE_LARRY_FR = BEES_FR + "/larry-matte";
    public static final String BEE_MANON = BEES + "/manon-gruaz";
    public static final String BEE_MANON_FR = BEES_FR + "/manon-gruaz";
    public static final String BEE_MAXIME = BEES + "/maxime-meriouma-caron";
    public static final String BEE_MAXIME_FR = BEES_FR + "/maxime-meriouma-caron";
    public static final String BEE_PHILIPPEA = BEES + "/philippe-araujo";
    public static final String BEE_PHILIPPEA_FR = BEES_FR + "/philippe-araujo";
    public static final String BEE_PHILIPPEB = BEES + "/philippe-beaudoin";
    public static final String BEE_PHILIPPEB_FR = BEES_FR + "/philippe-beaudoin";
    public static final String BEE_SIMONPIERRE = BEES + "/simon-pierre-gingras";
    public static final String BEE_SIMONPIERRE_FR = BEES_FR + "/simon-pierre-gingras";

    static {
        Map<String, String> keys = Maps.newHashMap();
        keys.put(HOME, HOME);
        keys.put(BEES, BEES_FR);
        keys.put(CAREERS, CAREERS_FR);
        keys.put(CONTACT, CONTACT_FR);
        keys.put(EXPERTISE, EXPERTISE_FR);
        keys.put(SUPPORT, SUPPORT_FR);
        keys.put(SHOP, SHOP_FR);
        keys.put(SERVICES, SERVICES_FR);
        keys.put(PRODUCTS_BASE, PRODUCTS_BASE_FR);
        keys.put(GAE, GAE_FR);
        keys.put(CHOSEN, CHOSEN_FR);
        keys.put(JUKITO, JUKITO_FR);
        keys.put(GWTP, GWTP_FR);
        keys.put(GQUERY, GQUERY_FR);
        keys.put(PRODUCTS, PRODUCTS_FR);

        keys.put(BEE_CHRISTIAN, BEE_CHRISTIAN_FR);
        keys.put(BEE_CHRISTOPHER, BEE_CHRISTOPHER_FR);
        keys.put(BEE_FRANCOIS, BEE_FRANCOIS_FR);
        keys.put(BEE_GENEVIEVE, BEE_GENEVIEVE_FR);
        keys.put(BEE_JASON, BEE_JASON_FR);
        keys.put(BEE_JEANCHRISTOPHE, BEE_JEANCHRISTOPHE_FR);
        keys.put(BEE_JOEL, BEE_JOEL_FR);
        keys.put(BEE_JULIEN, BEE_JULIEN_FR);
        keys.put(BEE_LARRY, BEE_LARRY_FR);
        keys.put(BEE_MANON, BEE_MANON_FR);
        keys.put(BEE_MAXIME, BEE_MAXIME_FR);
        keys.put(BEE_PHILIPPEA, BEE_PHILIPPEA_FR);
        keys.put(BEE_PHILIPPEB, BEE_PHILIPPEB_FR);
        keys.put(BEE_SIMONPIERRE, BEE_SIMONPIERRE_FR);

        placeKeys = HashBiMap.create(keys);
    }

    private static final BiMap<String, String> placeKeys;

    @Inject
    private static NameTokensConstants nameTokens;

    public static boolean isEn(String nameToken) {
        return placeKeys.containsKey(nameToken);
    }

    public static String translate(String nameToken) {
        if (isEn(nameToken)) {
            return placeKeys.get(nameToken);
        } else {
            return placeKeys.inverse().get(nameToken);
        }
    }

    public static String getBees() {
        return nameTokens.BEES();
    }
}
