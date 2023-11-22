package com.gildedrose;

public class  Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
    public void updateSellIn(){
        if (!(this.name.equals("Sulfuras, Hand of Ragnaros")) && this.sellIn >0){
        this.sellIn -=1;
        }
    }

    public void updateQuality() {
        if (this.sellIn > 0 && this.quality > 0) {
            this.quality -= 1;
        }

        else if (this.sellIn <= 0 && this.quality > 0) {
            this.quality -=2;
            //last check on quality
            this.regulateQuality();
        }
    }
   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
    public void regulateQuality() {
        if (this.quality < 0){this.quality = 0;}
    }
}
