package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void sulfurasQuality() {
        Item[] items = new Item[] { new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80), new LegendaryItem("Sulfuras, Hand of Ragnaross", -1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[1].quality);
        assertEquals(-1, app.items[1].sellIn);
    }

    @Test
    void negativeQuality(){
        Item[] items = new Item[] {new BasicItem("TucS0Q1", 0, 1), new BasicItem("TucS0Q2", 0, 2), new BasicItem("TucS1Q2", 1, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
        assertEquals(1, app.items[2].quality);
    }

    @Test
    void conjuredItem(){
        Item[] items = new Item[] {new ConjuredItem("Cs", 0, 4), new ConjuredItem("Cs2", 1, 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
        assertEquals(2, items[1].quality);
    }

    @Test
    void updateSellAb(){
        Item[] item = new Item[] {new AgedBrieItem("Cs", 3, 3)};
        GildedRose app = new GildedRose(item);
        app.updateQuality();
        assertEquals(2, item[0].sellIn);
    }

    @Test
    void updateSellBi(){
        Item[] item = new Item[] {new BasicItem("Bi", 2, 0)};
        GildedRose app = new GildedRose(item);
        app.updateQuality();
        assertEquals(1, item[0].sellIn);
    }

    @Test
    void updateSellCi(){
        Item[] item = new Item[] {new ConcertItem("Ci", 4, 9)};
        GildedRose app = new GildedRose(item);
        app.updateQuality();
        assertEquals(3, item[0].sellIn);
    }

    @Test
    void updateSellLi(){
        Item[] item = new Item[] {new LegendaryItem("Li", 28, 80)};
        GildedRose app = new GildedRose(item);
        app.updateQuality();
        assertEquals(28, item[0].sellIn);
    }
}

