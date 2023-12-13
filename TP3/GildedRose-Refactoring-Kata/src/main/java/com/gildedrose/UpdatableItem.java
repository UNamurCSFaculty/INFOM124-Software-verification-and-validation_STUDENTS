package com.gildedrose;

public class UpdatableItem extends Item {

    private final String typeItem;

    public UpdatableItem(String name, int sellIn, int quality, String typeItem) {
        super(name, sellIn, quality);
        this.typeItem = typeItem;
        if(this.sellIn < 0) this.sellIn = 0;
        if(this.quality < 0) this.quality = 0;
        else if (this.quality > 50) this.quality = 50;
    }

    public UpdatableItem(String name, int sellIn, int quality) {
        this(name, sellIn, quality, "Normal");
    }

    public void updateQuality() {
        if(!this.isSulfuras()) {
            if (this.isAgedBrie()) {
                this.updateQualityAgedBrie();
            } else if (this.isBackStagePass()) {
                this.updateQualityBackStagePass();
            } else {
                this.updateQualityGeneralCase();
            }
            this.decrementSellInDate();
        }
    }

    private void updateQualityBackStagePass() {
        if(this.isSellInDatePassed()) {
            this.quality = 0;
        } else {
            this.incrementQuality(this.getIncrementValueForBackStagePass());
        }
    }

    private int getIncrementValueForBackStagePass() {
        if(this.isSellInDateInLastDays(5)) return 3;
        if(this.isSellInDateInLastDays(10)) return 2;
        return 1;
    }

    private void updateQualityGeneralCase() {
        this.decrementQuality(this.getQualityDecrementValue());
    }

    private void updateQualityAgedBrie() {
        this.incrementQuality(1);
    }

    private int getQualityDecrementValue() {
        int result = 1;
        if(isSellInDatePassed()){
            result = 2;
        }
        if(isConjured()) {
            result = result * 2;
        }
        return result;
    }

    private void decrementQuality(int decrementValue) {
        this.quality = this.quality-decrementValue;
        if(this.isMinQualityReached()){
           this.quality = 0;
        }
    }

    private void incrementQuality(int incrementValue) {
        this.quality = this.quality+incrementValue;
        if(this.isMaxQualityReached()) {
            this.quality = 50;
        }
    }

    private void decrementSellInDate() {
        if(!isSellInDatePassed()) {
            this.sellIn = this.sellIn - 1;
        }
    }

    private boolean isSellInDatePassed() {
        return this.sellIn <= 0;
    }

    private boolean isSellInDateInLastDays(int dayLast) {
        return this.sellIn <= dayLast;
    }

    private boolean isMinQualityReached() {
        return this.quality <= 0;
    }

    private boolean isMaxQualityReached() {
        return this.quality >= 50;
    }

    private boolean isAgedBrie() {
        return this.name.equals("Aged Brie");
    }

    private boolean isBackStagePass() {
        return this.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras() {
        return this.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isConjured() {
        return this.typeItem.equals("Conjured");
    }

}
