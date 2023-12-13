package com.gildedrose;

import com.gildedrose.exceptions.UnknownItemTypeExceptions;
import com.gildedrose.updater.ItemUpdater;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void updateQualityItem(Item item) {
        ItemUpdater updater;
        try {
            updater = ItemUpdaterFactory.create(item);
            updater.update();
        } catch (UnknownItemTypeExceptions e) {
            e.printStackTrace();
        }

    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQualityItem(items[i]);
        }
    }
}
