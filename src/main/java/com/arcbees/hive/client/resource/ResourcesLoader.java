package com.arcbees.hive.client.resource;

import javax.inject.Inject;

import com.arcbees.hive.client.resource.team.TeamResources;

public class ResourcesLoader {
    @Inject
    ResourcesLoader(Resources resources,
                    TeamResources teamResources) {
        resources.style().ensureInjected();
        teamResources.style().ensureInjected();
    }
}
