package com.gildedrose;

class GildedRose {
    Item[] items;
    public static final String HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                && !item.name.equals(BACKSTAGE_ITEM_NAME) && item.quality > 0 && !item.name.equals(HAND_OF_RAGNAROS)) {
                item.quality = item.quality - 1;
            } else {
                if (item.quality < 50 && item.name.equals(BACKSTAGE_ITEM_NAME) && item.sellIn < 11) {
                    item.quality = item.quality + 1;
                }
            }

            if (!item.name.equals(HAND_OF_RAGNAROS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals(BACKSTAGE_ITEM_NAME) && item.quality > 0 && !item.name.equals(HAND_OF_RAGNAROS)) {
                        item.quality = item.quality - 1;
                    } else {
                        item.quality -= item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
