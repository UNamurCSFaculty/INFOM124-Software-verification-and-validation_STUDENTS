package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i] = updateItemWithCorrectRules(items[i]);
        }
    }

    private Item updateItemWithCorrectRules (Item item) {
        item.sellIn--;

        // god item...
        if(item.name.startsWith("Sulfuras")) {
            item.quality = 80;
            return item;
        }
        else {
            return updateClassicItem(item);
        }
    }

    private int setCorrectQuality(int quality) {
        if(quality < 0)
            return 0;

        else if(quality > 50)
            return 50;

        return quality;
    }

    private Item updateClassicItem(Item item) {
        if(item.sellIn >= 0)
        {
            // certain produit se bonifie
            switch (item.name) {
                case "Backstage passes": {
                    if (item.sellIn <= 5)
                        item.quality += 3;
                    else if (item.sellIn <= 10)
                        item.quality += 2;
                    else
                        item.quality += 1;
                    break;
                }
                case "Aged Brie":
                    // increase with peremption
                    item.quality += 1;
                    break;
                default:
                    // do nothing
                    break;
            }
        }
        else
        {
            switch (item.name) {
                case "Backstage passes": {
                    item.quality = 0;
                    break;
                }
                case "Aged Brie":
                    // increase with peremption
                    item.quality += 1;
                    break;
                case "Conjured":
                    // dégrade 2x plus vite
                    item.quality -= 2;
                    break;
                default:
                    // default behaviour
                    item.quality -= 1;
                    break;
            }
        }

        item.quality = setCorrectQuality(item.quality);

        return item;
    }
}
