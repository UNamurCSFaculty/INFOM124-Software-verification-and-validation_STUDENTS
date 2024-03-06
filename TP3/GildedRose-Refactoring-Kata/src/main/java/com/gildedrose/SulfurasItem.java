package com.gildedrose;

public class SulfurasItem extends Item{

    public SulfurasItem(String name, int sellIn, int quality){
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality(){
        quality = 80;
    }

    @Override
    public void updateSellIn(){
        sellIn = 0;
    }

}
