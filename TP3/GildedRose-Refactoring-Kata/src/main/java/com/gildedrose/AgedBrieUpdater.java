package com.gildedrose;

public class AgedBrieUpdater extends ItemUpdater {
    public AgedBrieUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        increaseQuality();
    }
}
