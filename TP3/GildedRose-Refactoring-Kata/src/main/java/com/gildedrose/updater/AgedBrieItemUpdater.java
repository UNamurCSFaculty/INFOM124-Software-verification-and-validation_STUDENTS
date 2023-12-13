package com.gildedrose.updater;

import com.gildedrose.Item;

public class AgedBrieItemUpdater extends ItemUpdater {
    public static final String NAME = "Aged Brie";

    public AgedBrieItemUpdater(Item item) {
        super(item);
        this.multiplier = -1;
    }

}
