package com.gildedrose;

public class BasicItem extends Item {
    public BasicItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality(){

        if (this.quality <= 0) {
            return;
        }

        if (this.sellIn <= 0 && this.quality >= 2){
                this.quality -= 2;
        } else {
            this.quality -= 1;
        }
    }

    @Override
    public void updateSellIn() {
        this.sellIn -= 1;
    }
}
