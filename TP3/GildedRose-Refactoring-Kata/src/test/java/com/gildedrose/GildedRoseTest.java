package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.UpdateSellIn();
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void Lose1QualityAndSellInCommonObject(){
        Item[] items = new Item[] { new Item("foo", 5, 5) };
        GildedRose app = new GildedRose(items);

        app.UpdateSellIn();
        app.updateQuality();

        assertEquals(4, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void Gain1QualityLose1SellInAgedBrie(){
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);

        app.UpdateSellIn();
        app.updateQuality();

        assertEquals(6, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void GainQualityLoseSellInBackStagePasse(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 5)};
        GildedRose app = new GildedRose(items);

        app.UpdateSellIn();
        app.updateQuality();


        assertEquals(8, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);

        assertEquals(7, app.items[1].quality);
        assertEquals(9, app.items[1].sellIn);

        assertEquals(6, app.items[2].quality);
        assertEquals(14, app.items[2].sellIn);
    }

    @Test
    void ConjuredItem(){
        Item[] items = new Item[] { new Item("Conjured", 5, 5),
            new Item("Conjured", 0, 5)};
        GildedRose app = new GildedRose(items);

        app.UpdateSellIn();
        app.updateQuality();

        assertEquals(3, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);

        assertEquals(1, app.items[1].quality);
        assertEquals(-1, app.items[1].sellIn);
    }

    @Test
    void Sulfura(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);

        app.UpdateSellIn();
        app.updateQuality();

        assertEquals(80, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    void QualityAbove50(){
        Item[] items = new Item[] { new Item("Aged Brie", 5, 49),
            new Item("Aged Brie", 5, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
        GildedRose app = new GildedRose(items);

        app.UpdateSellIn();
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);

        assertEquals(50, app.items[1].quality);
        assertEquals(4, app.items[1].sellIn);

        assertEquals(50, app.items[2].quality);
        assertEquals(4, app.items[2].sellIn);
    }

}
