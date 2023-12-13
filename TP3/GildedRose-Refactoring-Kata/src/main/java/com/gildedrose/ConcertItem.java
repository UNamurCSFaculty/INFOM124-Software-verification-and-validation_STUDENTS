package com.gildedrose;

public class ConcertItem extends Item {
    public ConcertItem (String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality(){
        if (this.quality < 50) {
            if (this.sellIn > 5 && this.sellIn < 10) {
                this.quality += 2;
            }  else if (this.sellIn > 0 && this.sellIn < 5) {
                this.quality += 3;
            } else if (this.sellIn > 0) {
                this.quality += 1;
            } else {
                this.quality = 0;
            }
        }
    }

    @Override
    public void updateSellIn() {
        this.sellIn -= 1;
    }
}
