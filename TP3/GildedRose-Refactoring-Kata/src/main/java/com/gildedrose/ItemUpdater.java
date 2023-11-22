package com.gildedrose;

public class ItemUpdater {
    private Item item;

    public ItemUpdater(Item item) {
        this.item = item;
    }

    public void update() {
        decreaseQuality(1);
        decreaseSellIn();
    }

    protected void decreaseQuality(int mult) {
        if(getSellIn() < 0)
            item.quality -= mult*2;
        else
            item.quality -= mult;
    }

    protected void increaseQuality() {
        if(item.quality < 50) {
            if(item.sellIn < 0) {
                // Si la qualité augmente, elle augmente de 2
                item.quality += 2;
            } else {
                // Si la qualité augmente, elle augmente de 1
                item.quality++;
            }
        }
    }

    protected void setQuality(int quality) {
        if(quality < 50 && quality >= 0)
            item.quality = quality;
    }

    protected int getSellIn() {
        return item.sellIn;
    }

    protected void decreaseSellIn() {
        item.sellIn--;
    }
}
