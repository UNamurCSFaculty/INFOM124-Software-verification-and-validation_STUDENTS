package com.gildedrose;

public class ConjuredItem extends Item {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality(){

        if (this.quality <= 0) {
            return;
        }

        if (this.sellIn <= 0 && this.quality >= 4){
            this.quality -= 4;
        } else {
            this.quality -= 2;
        }
    }

    @Override
    public void updateSellIn() {
        this.sellIn -= 1;
    }
}
