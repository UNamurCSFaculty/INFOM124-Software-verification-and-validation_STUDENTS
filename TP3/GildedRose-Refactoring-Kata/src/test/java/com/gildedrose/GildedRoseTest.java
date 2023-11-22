package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].getName());
    }

    @Test
    void updateSimpleItemSellIn() {
        Item[] items = new Item[] { new Item("Test", 10, 10)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].getSellIn());
    }

    @ParameterizedTest
    @CsvSource(delimiter = ';', textBlock = """
        Test;10;9
        Test;-2;8
        Aged Brie;-2;12
        Backstage passes to a TAFKAL80ETC concert;-2;0
        Conjured;5;8
        Conjured;-2;6
        Backstage passes to a TAFKAL80ETC concert;9;12
        Sulfuras, Hand of Ragnaros;10;10
        Aged Brie;10;11
        """)
    void updateQuality(String name, int sellIn, int expected) {
        Item[] items = new Item[] { new Item(name, sellIn, 10)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expected, app.items[0].getQuality());
    }

    @Test
    void updateFewItems() {
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 10, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10),
            new Item("Truc", 10, 10)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(10, app.items[0].getQuality());
        assertEquals(13, app.items[1].getQuality());
        assertEquals(9, app.items[2].getQuality());
    }
}
