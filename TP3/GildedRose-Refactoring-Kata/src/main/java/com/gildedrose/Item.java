package com.gildedrose;

public class Item {
    protected String name;
    protected int sellIn;
    protected int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void chooseMethod(){
        switch (name) {
            case "Sulfuras, Hand of Ragnaros": {
                SulfurasItem sulfurasItem = new SulfurasItem(this.name, this.sellIn, this.quality);
                sulfurasItem.updateQuality();
                sulfurasItem.updateSellIn();
                // Optionally, you might want to update the original item's values with those of the agedBrieItem
                this.name = sulfurasItem.name;
                this.sellIn = sulfurasItem.sellIn;
                this.quality = sulfurasItem.quality;
                break;
            }
            case "Aged Brie": {
                // Cast Item to AgedBrieItem and update Quality and sellIn
                AgedBrieItem agedBrieItem = new AgedBrieItem(this.name, this.sellIn, this.quality);
                agedBrieItem.updateQuality();
                agedBrieItem.updateSellIn();
                // Optionally, you might want to update the original item's values with those of the agedBrieItem
                this.name = agedBrieItem.name;
                this.sellIn = agedBrieItem.sellIn;
                this.quality = agedBrieItem.quality;
                break;
            }
            case "Backstage passes to a TAFKAL80ETC concert": {
                BackstagePassesItem backstagePassesItem = new BackstagePassesItem(this.name, this.sellIn, this.quality);
                backstagePassesItem.updateQuality();
                backstagePassesItem.updateSellIn();
                // Optionally, you might want to update the original item's values with those of the agedBrieItem
                this.name = backstagePassesItem.name;
                this.sellIn = backstagePassesItem.sellIn;
                this.quality = backstagePassesItem.quality;
                break;
            }
            case "Conjured Mana Cake": {
                ConjuredItem conjuredItem = new ConjuredItem(this.name, this.sellIn, this.quality);
                conjuredItem.updateQuality();
                conjuredItem.updateSellIn();
                // Optionally, you might want to update the original item's values with those of the agedBrieItem
                this.name = conjuredItem.name;
                this.sellIn = conjuredItem.sellIn;
                this.quality = conjuredItem.quality;
                break;
            }
            default:
                updateQuality();
                updateSellIn();
                break;
        }


    }

    public void updateQuality(){
        assert quality > 0 && quality <= 50;
        if(sellIn > 0){
            quality--;
        } else {
            quality -= 2;
        }
    }

    public void updateSellIn(){
        if(sellIn > 0){
            sellIn--;
        } else {
            sellIn = 0;
        }
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
