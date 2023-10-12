package com.gildedrose;

public class GildedRoseUtil {
    public static void increaseQuality(Item item) {
        if (canIncreaseQuality(item)) {
            item.quality += 1;
        }
    }

    public static void decreaseQuality(Item item) {
        if (hasQuality(item)) {
            item.quality -= 1;
        }
    }

    public static void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    public static boolean isSellInNegative(Item item) {
        return item.sellIn < 0;
    }

    public static boolean hasQuality(Item item) {
        return item.quality > 0;
    }

    public static boolean canIncreaseQuality(Item item) {
        return item.quality < 50;
    }
}
