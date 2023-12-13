package com.gildedrose.updater;

import com.gildedrose.Item;

public class SulfurasItemUpdater extends ItemUpdater {
    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    private static final int MAX_LEGENDARY_QUALITY = 80;

    public SulfurasItemUpdater(Item item) {
        super(item, MAX_LEGENDARY_QUALITY);
    }

    @Override
    protected void decreaseSellIn() {
        // Do nothing
    }

    @Override
    protected void updateQuality() {
        // Do nothing
    }

}
