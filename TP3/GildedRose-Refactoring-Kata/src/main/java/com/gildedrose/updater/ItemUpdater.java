package com.gildedrose.updater;

import com.gildedrose.Item;

/**
 * The ItemUpdater class is responsible for updating the quality and sell-in
 * value of an item.
 * It provides methods to update the item's quality and sell-in value based on
 * certain rules.
 *
 * This class should be subclassed for each item type with specific rules to
 * update quality and sellIn. Subclasses only need to override methods that does
 * not follow the default rules.
 */
public class ItemUpdater {
    public static final String NAME = "Default";

    private static final int DEFAULT_MAX_QUALITY = 50;
    private static final int DEFAULT_MIN_QUALITY = 0;

    protected int maxQuality = 50;
    protected int minQuality = 0;
    protected int multiplier = 1;

    public Item getItem() {
        return item;
    }

    private Item item;

    public ItemUpdater(Item item) {
        this(item, DEFAULT_MAX_QUALITY, DEFAULT_MIN_QUALITY);
    }

    public ItemUpdater(Item item, int maxQuality) {
        this(item, maxQuality, DEFAULT_MIN_QUALITY);
    }

    public ItemUpdater(Item item, int maxQuality, int minQuality) {
        this.item = item;
        this.maxQuality = maxQuality;
        this.minQuality = minQuality;
    }

    protected void guardQuality() {
        if (item.quality > maxQuality) {
            item.quality = maxQuality;
        }
        if (item.quality < minQuality) {
            item.quality = minQuality;
        }
    }

    protected void decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    protected void updateQuality() {
        if (item.sellIn < 0) {
            item.quality = item.quality - (2 * multiplier);
        } else {
            item.quality = item.quality - (1 * multiplier);
        }
    }

    public void update() {
        decreaseSellIn();
        updateQuality();
        guardQuality();
    }
}
