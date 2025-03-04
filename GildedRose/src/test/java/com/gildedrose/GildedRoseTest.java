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


    // test pour les items standard
    @Test
    void testStandardItem() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void testStandardItemQuality1() {
        Item[] items = new Item[] { new Item("foo", 10, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testItemQuality0() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testStandardItemSellInStandard() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void testStandardItemSellIn0() {
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void testStandardItemSellInNegative() {
        Item[] items = new Item[] { new Item("foo", -5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    // test pour AGED_BRIE
    @Test
    void testAgedBrieQuality50() {
        Item[] items = new Item[] { new Brie(10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testAgedBrieQualityStandard() {
        Item[] items = new Item[] { new Brie(10, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(31, app.items[0].quality);
    }

    @Test
    void testAgedBrieSellIn0() {
        Item[] items = new Item[] { new Brie(0, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, app.items[0].quality);
    }

    // test pour BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT
    @Test
    void testBackstageQuality50() {
        Item[] items = new Item[] { new Concert(10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testBackstageSellInStandard() {
        Item[] items = new Item[] { new Concert(30, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void testBackstageSellIn10() {
        Item[] items = new Item[] { new Concert(10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void testBackstageSellIn10Quality49() {
        Item[] items = new Item[] { new Concert(10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testBackstageSellIn5() {
        Item[] items = new Item[] { new Concert(5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
    }

    @Test
    void testBackstageSellIn5Quality49() {
        Item[] items = new Item[] { new Concert(5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testBackstageSellIn0() {
        Item[] items = new Item[] { new Concert(0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    // test pour SULFURAS_HAND_OF_RAGNAROS
    @Test
    void testSulfurasQuality() {
        Item[] items = new Item[] { new Sulfuras() };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void testSulfurasSellIn() {
        Item[] items = new Item[] { new Sulfuras() };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

}
