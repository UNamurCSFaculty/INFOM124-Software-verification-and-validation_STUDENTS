package com.gildedrose;

public class Conjured extends Item{
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality(){
        if(this.quality == 0){return;}
        if(this.quality > 0 && this.sellIn > 0){this.quality-=2;}

        else if (this.quality > 0 && this.sellIn <=0) {this.quality -=4;}
        this.regulateQuality();
    }

}


