package com.gildedrose.updater;

import com.gildedrose.Item;

public class BackstageItemUpdater extends ItemUpdater {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    private static final int MEDIUM_TIME_LEFT = 5;
    private static final int MEDIUM_QUALITY_INCREASE = 3;
    private static final int LOW_TIME_LEFT = 10;
    private static final int LOW_QUALITY_INCREASE = 2;

    public BackstageItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        Item item = this.getItem();
        if (item.sellIn < 0) {
            item.quality = super.minQuality;
        } else if (item.sellIn < MEDIUM_TIME_LEFT) {
            item.quality = item.quality + MEDIUM_QUALITY_INCREASE;
        } else if (item.sellIn < LOW_TIME_LEFT) {
            item.quality = item.quality + LOW_QUALITY_INCREASE;
        } else {
            item.quality = item.quality + 1;
        }
    }

}
