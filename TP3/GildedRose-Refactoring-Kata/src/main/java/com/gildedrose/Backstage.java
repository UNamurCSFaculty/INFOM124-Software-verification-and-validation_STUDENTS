package com.gildedrose;

public class Backstage extends Item {
    public Backstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    public boolean sellInisBetween(int fst, int snd) {
        return (this.sellIn >= fst && this.sellIn <= snd);
    }
    @Override
    public void regulateQuality(){
        if(this.quality > 50){this.quality =50;}
    }
    @Override
    public void updateQuality() {
        if(this.quality == 50){return;}

        if (this.sellIn <= 0) {
            this.quality = 0;
        }
        else if (this.sellInisBetween(1, 5)) {
            this.quality += 3;
        }
        else if (this.sellInisBetween(6,10)) {
            this.quality +=2;
        }
        else {this.quality +=1;}
        //last check on quality
        this.regulateQuality();

    }

}
