package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        UpdatableItem[] items = new UpdatableItem[] { new UpdatableItem("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void testItemStringRepr() {
        UpdatableItem[] items = new UpdatableItem[] { new UpdatableItem("foo", 0, 0) };
        assertEquals("foo, 0, 0", items[0].toString());
    }

    @Test
    void testUpdatableItemAsItem() {
        UpdatableItem[] items = new UpdatableItem[] { new UpdatableItem("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void testSellInAndQualityDecreasing() {
        UpdatableItem[] items = new UpdatableItem[] {
            new UpdatableItem("foo", 3, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void testSellInAndQualityNotDecreasingIfSulfuras() {
        UpdatableItem[] items = new UpdatableItem[] {
            new UpdatableItem("Sulfuras, Hand of Ragnaros", 3, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }

    @Test
    void testQualityDoubleDecreasingIfSellInDatePassed() {
        UpdatableItem[] items = new UpdatableItem[] {
            new UpdatableItem("foo", 0, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void testQualityIncreasingIfAgedBrie() {
        UpdatableItem[] items = new UpdatableItem[] {
            new UpdatableItem("Aged Brie", 0, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void testQualityShouldStopAt50() {
        UpdatableItem[] items = new UpdatableItem[] {
            new UpdatableItem("Backstage passes to a TAFKAL80ETC concert", 4, 49)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testQualityIncreasingIfMoreThan10DaysLeft() {
        UpdatableItem[] items = new UpdatableItem[] {
            new UpdatableItem("Backstage passes to a TAFKAL80ETC concert", 20, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void testQualityDoubleIncreasingIfPassIn10DaysLeft() {
        UpdatableItem[] items = new UpdatableItem[] {
            new UpdatableItem("Backstage passes to a TAFKAL80ETC concert", 9, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void testQualityTripleIncreasingIfPassIn10DaysLeft() {
        UpdatableItem[] items = new UpdatableItem[] {
            new UpdatableItem("Backstage passes to a TAFKAL80ETC concert", 4, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void testQualityZeroIfPassSellInPassed() {
        UpdatableItem[] items = new UpdatableItem[] {
            new UpdatableItem("Backstage passes to a TAFKAL80ETC concert", 0, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testSellInAndQualityNotDecreasingIfSulfurasEvenConjured() {
        UpdatableItem[] items = new UpdatableItem[] {
            new UpdatableItem("Sulfuras, Hand of Ragnaros", 3, 10, "Conjured")
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }

    @Test
    void testConjuredDoubleDecreasing() {
        UpdatableItem[] items = new UpdatableItem[] {
            new UpdatableItem("foo", 3, 10, "Conjured")
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void testConjuredQuatrupleDecreasingIfSellInPassed() {
        UpdatableItem[] items = new UpdatableItem[] {
            new UpdatableItem("foo", 0, 10, "Conjured")
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void testSellInOutOfBoundNegative() {
        UpdatableItem[] items = new UpdatableItem[] { new UpdatableItem("foo", -1, -1) };
        assertEquals(0, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testSellInOutOfBoundQalityBeyondFifty() {
        UpdatableItem[] items = new UpdatableItem[] { new UpdatableItem("foo", 0, 51) };
        GildedRose app = new GildedRose(items);
        assertEquals(50, app.items[0].quality);
    }

}
