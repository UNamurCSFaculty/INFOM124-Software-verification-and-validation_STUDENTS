package com.gildedrose;

public class BackstagePassesItem extends Item{
        public BackstagePassesItem(String name, int sellIn, int quality){
            super(name, sellIn, quality);
        }

        @Override
        public void updateQuality(){
            if(sellIn > 10){
                quality++;
            } else if (sellIn <= 10 && sellIn > 5){
                if (quality < 49){
                    quality += 2;
                } else {
                    quality = 50;
                }
            } else if (sellIn <= 5 && sellIn > 0){
                if(quality < 48){
                    quality += 3;
                } else {
                    quality = 50;
                }

            } else {
                quality -= 2;
            }
        }
}
