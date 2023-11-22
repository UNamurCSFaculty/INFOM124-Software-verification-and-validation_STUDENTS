package com.gildedrose;

public class BackstagePassesUpdater extends ItemUpdater {

    public BackstagePassesUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (getSellIn() < 0) {
            setQuality(0);
        } else {
            increaseQuality();
            if (getSellIn() < 11) {
                increaseQuality();
            }
            if (getSellIn() < 6) {
                increaseQuality();
            }
        }
    }
}
