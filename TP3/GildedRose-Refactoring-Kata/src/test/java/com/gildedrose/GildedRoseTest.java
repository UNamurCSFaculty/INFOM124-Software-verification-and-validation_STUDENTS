package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateStock();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void gildedRoseTest() {
        Item[] items = new Item[] {new StdItem("épée longue", 30, 1),
                                new ConjuredItem("épée conjurée", 5, 10),
                                new BackstagePasses("passe backstage", 10, 10),
                                new LegendaryItem("Sulfuras", 50, 50),
                                new AgedBrie("Brie maturé", 10, 5)};

        GildedRose gildedRose = new GildedRose(items);

        for(int i = 4; i >= 0; i--) {
            gildedRose.updateStock();
        }

        int sulfurasQuality = gildedRose.items[3].quality;
        assertEquals(50, sulfurasQuality);

        int agedBrieQuality = gildedRose.items[4].quality;
        assertEquals(10, agedBrieQuality);
    }

}
