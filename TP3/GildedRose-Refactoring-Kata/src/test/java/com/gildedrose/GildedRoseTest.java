package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GildedRoseTest {

    @ParameterizedTest
    @CsvSource({
            "2, 10, 9, 1",
            "0, 10, 8, -1",
            "2, 0, 0, 1",
            "0, 0, 0, -1",
            "1, 20, 19, 0",
            "0, 20, 18, -1",
            "-1, 10, 8, -2",
    })
    void testUpdateQuality(int sellIn, int quality, int expectedQuality, int expectedSellIn) {
        Item[] items = new Item[] { new Item("Item", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedQuality, app.items[0].quality);
        assertEquals(expectedSellIn, app.items[0].sellIn);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 0, 1, 1",
            "2, 50, 50, 1",
            "2, 0, 1, 1",
            "0, 0, 2, -1",
            "-1, 2, 4, -2",
    })
    void testAgedBrieUpdateQuality(int sellIn, int quality, int expectedQuality, int expectedSellIn) {
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedQuality, app.items[0].quality);
        assertEquals(expectedSellIn, app.items[0].sellIn);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5, 10, 10, 5",
            "2, 50, 50, 2",
            "0, 80, 80, 0",

    })
    void testSulfurasUpdateQuality(int sellIn, int quality, int expectedQuality, int expectedSellIn) {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedQuality, app.items[0].quality);
        assertEquals(expectedSellIn, app.items[0].sellIn);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "20, 10, 11, 19",
            "10, 10, 12, 9",
            "9, 10, 12, 8",
            "9, 50, 50, 8",
            "5, 10, 13, 4",
            "4, 10, 13, 3",
            "4, 50, 50, 3",
            "1, 20, 23, 0",
            "0, 50, 0, -1",
            "-1, 20, 0, -2",

    })
    void testBackstageUpdateQuality(int sellIn, int quality, int expectedQuality, int expectedSellIn) {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedQuality, app.items[0].quality);
        assertEquals(expectedSellIn, app.items[0].sellIn);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 10, 8, 1",
            "0, 10, 6, -1",
            "2, 0, 0, 1",
            "0, 0, 0, -1",
            "1, 20, 18, 0",
            "0, 20, 16, -1",
            "-1, 10, 6, -2",
    })
    void testConjuredUpdateQuality(int sellIn, int quality, int expectedQuality, int expectedSellIn) {
        Item[] items = new Item[] { new Item("Conjured", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedQuality, app.items[0].quality);
        assertEquals(expectedSellIn, app.items[0].sellIn);
    }

}
