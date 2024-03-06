package com.gildedrose;

public class ConjuredItem extends Item{
        public ConjuredItem(String name, int sellIn, int quality){
            super(name, sellIn, quality);
        }

        @Override
        public void updateQuality(){
            if(sellIn > 0){
                quality -= 2;
            } else {
                quality -= 4;
            }
        }
}
