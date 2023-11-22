package com.gildedrose;

import org.junit.jupiter.api.Test;
import java.lang.AssertionError;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void empty_itemlist() {
        Item[] items = new Item[]{};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,items.length);
    }
    @Test
    void decreaseQuality(){
        Item[] items = new Item[]{ new Item("foo",5, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }
    @Test
     void Sulfura_no_changes(){
        Item[] items = new Item[]{ new Item("Sulfuras, Hand of Ragnaros",5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }
    @Test
    void no_over_50_Agedbrie(){
        Item[] items = new Item[]{ new Item("Aged Brie",5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void backstage_no_incrementation() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void backstage_incrementation_plus1(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert",15, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(31, app.items[0].quality);
    }
    @Test
    void backstage_incrementation_plus2(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert",10, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(32, app.items[0].quality);
    }
    @Test
    void backstage_incrementation_plus3(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert",5, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(33, app.items[0].quality);
    }
    @Test
    void backstage_no_over_50() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void backstage_lost_value() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void conjured_normal_decrement() {
        Item[] items = new Item[]{new Item("Conjured", 10, 30),};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(28, app.items[0].quality);
    }
    @Test
    void conjured_double_decrement() {
        Item[] items = new Item[]{new Item("Conjured", 1, 30),};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(26, app.items[0].quality);
    }
    @Test
    void more_than_1item_decrement(){
        Item[] items = new Item[]{new Item("bruh", 1, 30),
        new Item("kevin Duty", 15,12)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
        assertEquals(11, app.items[1].quality);
    }
    @Test
    void no_sellin_under0(){
        Item[] items = new Item[]{new Item("bruh", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

}

