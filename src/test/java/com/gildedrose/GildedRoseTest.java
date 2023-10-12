package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void testUpdateQualityDefaultItemValidSellIn() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void testUpdateQualityDefaultItemPassedSellIn() {
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void testUpdateQualityDefaultItemZeroQuality() {
        Item[] items = new Item[] { new Item("foo", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void testUpdateQualityAgedBrieValidSellIn() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void testUpdateQualityBackstagePassesValidSellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void testUpdateQualityBackstagePassesValidSellInLessThanFive() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void testUpdateQualityBackstagePassesValidSellInLessThanZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
}
