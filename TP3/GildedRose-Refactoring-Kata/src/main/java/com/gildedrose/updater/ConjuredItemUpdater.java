package com.gildedrose.updater;

import com.gildedrose.Item;

public class ConjuredItemUpdater extends ItemUpdater {
    public static final String NAME = "Conjured Mana Cake";

    public ConjuredItemUpdater(Item item) {
        super(item);
        this.multiplier = 2;
    }

}
