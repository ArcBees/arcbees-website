package com.arcbees.website.client.application.maps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.google.gwt.maps.client.LoadApi;

public class GwtMapsLoaderImpl implements GwtMapsLoader {
    private final Queue<Runnable> loadedCallbacks;

    private boolean loaded;
    private boolean pending;

    GwtMapsLoaderImpl() {
        loadedCallbacks = new LinkedList<>();
    }

    @Override
    public void loadGwtMaps() {
        loadGwtMaps(null);
    }

    @Override
    public void loadGwtMaps(final Runnable runnable) {
        if (runnable != null) {
            loadedCallbacks.add(runnable);
        }

        if (pending) {
            return;
        }

        if (loaded) {
            purgeCallbacks();
            return;
        }

        ArrayList<LoadApi.LoadLibrary> libraries = new ArrayList<>();

        pending = true;

        LoadApi.go(new Runnable() {
            @Override
            public void run() {
                loaded = true;
                pending = false;

                purgeCallbacks();
            }
        }, libraries, true);
    }

    private void purgeCallbacks() {
        while (loadedCallbacks.iterator().hasNext()) {
            loadedCallbacks.remove().run();
        }
    }
}
