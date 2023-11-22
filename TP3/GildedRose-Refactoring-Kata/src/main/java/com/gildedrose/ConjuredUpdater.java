package com.gildedrose;

public class ConjuredUpdater extends ItemUpdater {
    public ConjuredUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        decreaseQuality(2);
    }
}
