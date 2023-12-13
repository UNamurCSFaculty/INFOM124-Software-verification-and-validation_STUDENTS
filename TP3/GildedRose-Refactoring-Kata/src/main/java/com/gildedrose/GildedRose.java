package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            switch (items[i].name){
                case "Aged Brie" :
                    Add1Quality(items[i]);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    ConcertTicketRules(items[i]);
                    break;
                case "Conjured":
                    LoseQuality(items[i], 2);
                    break;
                default:
                    LoseQuality(items[i], 1);
                    break;
            }


            if (items[i].sellIn <= 0) {
                switch (items[i].name){
                    case "Backstage passes to a TAFKAL80ETC concert":
                        items[i].quality = 0;
                        break;
                    case "Conjured":
                        LoseQuality(items[i], 2);
                        break;
                    default:
                        LoseQuality(items[i], 1);
                        break;
                }
            }
        }
    }

    public void UpdateSellIn(){
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn -= 1;
            }
        }
    }

    private void Add1Quality(Item item){
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private void LoseQuality(Item item,int nbrPointsToLose){
        for(int j = 0; j < nbrPointsToLose; j++){
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality -= 1;
                }
            }
        }
    }

    private void ConcertTicketRules(Item item){
        Add1Quality(item);
        if (item.sellIn < 11) {
            Add1Quality(item);
        }

        if (item.sellIn < 6) {
            Add1Quality(item);
        }
    }


}
