package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void GildedRoseTest() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 50), //
            new Item("item", 10, 50),
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("+5 Dexterity Vest, 9, 49", items[0].toString());
        assertEquals("item, 9, 49", items[1].toString());
        assertEquals("Aged Brie, 1, 1", items[2].toString());
        assertEquals("Elixir of the Mongoose, 4, 6", items[3].toString());
        assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[4].toString());
        assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[5].toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 14, 21", items[6].toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 9, 50", items[7].toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 3, 50", items[8].toString());
        assertEquals("Conjured Mana Cake, 2, 4", items[9].toString());
    }

    @Test
    void ItemTest1() {
        Item item = new Item("item", 10, 50);
        item.chooseMethod();
        assertEquals("item, 9, 49", item.toString());
    }

    @Test
    void ItemTest2() {
        Item item = new Item("item", 0, 50);
        item.chooseMethod();
        assertEquals("item, 0, 48", item.toString());
    }


    @Test
    void BackstagePassesItemTest() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        item.chooseMethod();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 14, 21", item.toString());
    }

    @Test
    void BackstagePassesItemTest2() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48);
        item.chooseMethod();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 9, 50", item.toString());
    }

    @Test
    void BackstagePassesItemTest3() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 48);
        item.chooseMethod();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 7, 50", item.toString());
    }

    @Test
    void BackstagePassesItemTest4() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 47);
        item.chooseMethod();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 2, 50", item.toString());
    }

    @Test
    void BackstagePassesItemTest5() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47);
        item.chooseMethod();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 4, 50", item.toString());
    }

    @Test
    void BackstagePassesItemTest6() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 48);
        item.chooseMethod();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 0, 46", item.toString());
    }

    @Test
    void ConjuredItemTest() {
        Item item = new Item("Conjured Mana Cake", 3, 6);
        item.chooseMethod();
        assertEquals("Conjured Mana Cake, 2, 4", item.toString());
    }

    @Test
    void ConjuredItemTest2() {
        Item item = new Item("Conjured Mana Cake", 0, 6);
        item.chooseMethod();
        assertEquals("Conjured Mana Cake, 0, 2", item.toString());
    }


    @Test
    void SulfurasItemTest() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        item.chooseMethod();
        assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", item.toString());
    }

    @Test
    void AgedBrieTest() {
        Item item = new Item("Aged Brie", 2, 0);
        item.chooseMethod();
        assertEquals("Aged Brie, 1, 1", item.toString());
    }

    @Test
    void AgedBrieTest2() {
        Item item = new Item("Aged Brie", 2, 50);
        item.chooseMethod();
        assertEquals("Aged Brie, 1, 50", item.toString());
    }
}
