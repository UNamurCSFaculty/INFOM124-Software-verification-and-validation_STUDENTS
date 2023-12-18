package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    @Override
    public void updateQuality(){
        if(this.quality <50 && this.sellIn >0){this.quality +=1;}
    }
}
