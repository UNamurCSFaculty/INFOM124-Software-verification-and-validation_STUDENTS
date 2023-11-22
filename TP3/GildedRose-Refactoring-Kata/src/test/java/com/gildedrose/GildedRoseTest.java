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

    @Test()
    void sulfura(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test()
    void classicProduct(){
        Item[] items = new Item[] { new Item("Normal", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
    }

    @Test()
    void conjuredProduct(){
        Item[] items = new Item[] { new Item("Conjured", 0, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(38, app.items[0].quality);
    }

    @Test()
    void checkUpperQuality() {
        Item[] items = new Item[] { new Item("Backstage passes", 3, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test()
    void checkBackstagePasses0Day() {
        Item[] items = new Item[] { new Item("Backstage passes", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test()
    void checkBackstagePasses5Day() {
        Item[] items = new Item[] { new Item("Backstage passes", 5, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(48, app.items[0].quality);
    }

    @Test()
    void checkBackstagePasses10Day() {
        Item[] items = new Item[] { new Item("Backstage passes", 10, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(47, app.items[0].quality);
    }

    @Test()
    void checkBackstagePasses20Day() {
        Item[] items = new Item[] { new Item("Backstage passes", 20, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(46, app.items[0].quality);
    }

    @Test()
    void checkAgeBrie10Day() {
        Item[] items = new Item[] { new Item("Aged Brie", 20, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(46, app.items[0].quality);
    }

    @Test()
    void checkAgeBrieNegative10Day() {
        Item[] items = new Item[] { new Item("Aged Brie", -20, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(46, app.items[0].quality);
    }

    @Test()
    void checkRandomProduct10Day() {
        Item[] items = new Item[] { new Item("Simple test", 5, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(45, app.items[0].quality);
    }


    @Test()
    void checkItemString() {
        Item[] items = new Item[] { new Item("Simple test", 5, 45) };

        String item = items[0].toString();
        assertEquals("Simple test, 5, 45", item);
    }

}
