package com.gildedrose;

public class AgedBrieItem extends Item {
    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality(){
        if (this.quality < 50) {
            this.quality += 1;
        }
    }

    @Override
    public void updateSellIn() {
        this.sellIn -= 1;
    }
}
