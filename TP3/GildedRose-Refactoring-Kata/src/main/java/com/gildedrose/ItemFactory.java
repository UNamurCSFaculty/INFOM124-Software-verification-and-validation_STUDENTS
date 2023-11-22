package com.gildedrose;

public class ItemFactory {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public static final String CONJURED = "Conjured";

    private ItemFactory() {
        // Private default constructor
    }

    public static ItemUpdater getItem(Item item) {
        switch(item.name) {
            case AGED_BRIE:
                return new AgedBrieUpdater(item);
            case SULFURAS:
                return new SulfurasUpdater(item);
            case BACKSTAGE_PASSES:
                return new BackstagePassesUpdater(item);
            case CONJURED:
                return new ConjuredUpdater(item);
            default:
                return new ItemUpdater(item);
        }
    }
}
