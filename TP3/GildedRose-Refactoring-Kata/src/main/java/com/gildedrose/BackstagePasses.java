package com.gildedrose;

public class BackstagePasses extends Item {
    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.sellIn <= 0) {
            return;
        }
        int qualityUpdateValue = 0;

        if (this.sellIn <= 10) {
            qualityUpdateValue += 1;
        }
        if (this.sellIn <= 5) {
            qualityUpdateValue += 1;
        }
        this.quality += qualityUpdateValue;
    }

    @Override
    public void updateSellIn() {
        this.sellIn -= 1;
    }
}
