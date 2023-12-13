package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.quality >= 50) return;

        this.quality += 1;
    }
    @Override
    public void updateSellIn() {
        this.sellIn -= 1;
    }
}
