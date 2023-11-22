package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(int i = 0; i < items.length; i++) {
            ItemUpdater item = ItemFactory.getItem(items[i]);
            item.update();
        }
    }
}
