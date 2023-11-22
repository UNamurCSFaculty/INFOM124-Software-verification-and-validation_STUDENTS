package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        assert items != null : "items undefined";
        if (items.length == 0){ return;}

        for (int i = 0; i < items.length; i++) {
            items[i].updateSellIn();

            switch (items[i].name) {
                case "Sulfuras, Hand of Ragnaros":
                    items[i] = new Sulfura(items[i].name, items[i].sellIn, items[i].quality);
                    break;

                case "Aged Brie":
                    items[i] = new AgedBrie(items[i].name, items[i].sellIn, items[i].quality);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    items[i] = new Backstage(items[i].name, items[i].sellIn, items[i].quality);
                    break;

                case "Conjured":
                    items[i] = new Conjured(items[i].name, items[i].sellIn, items[i].quality);
                    break;
                default:
                    break;
            }
            items[i].updateQuality();
        }
    }
}


//cas de base -> qualité -1 puis -2 si sellin = 0
// Sulfura -> on ne touche pas
// Age Brie -> qualité +1 jusque 50
// Backstage -> qualité +1 si sellin > 10 , +2 entre 10 et 6 et +3 entre 5 et 1 -- 0 quand sellin à 0
// Conjured -> qualité -2, -4 quand sellin à 0

//"Backstage passes to a TAFKAL80ETC concert"
//""Sulfuras, Hand of Ragnaros""
//"Aged Brie"
//"Conjured"

