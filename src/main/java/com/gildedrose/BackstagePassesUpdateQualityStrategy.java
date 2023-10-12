package com.gildedrose;

public class BackstagePassesUpdateQualityStrategy implements UpdateQualityStrategy {
    @Override
    public void updateQuality(Item item) {
        GildedRoseUtil.increaseQuality(item);
        GildedRoseUtil.decreaseSellIn(item);
        if (GildedRoseUtil.isSellInNegative(item)) {
            item.quality = 0;
        } else if (item.sellIn <= 10) {
            GildedRoseUtil.increaseQuality(item);
            if (item.sellIn <= 5) {
                GildedRoseUtil.increaseQuality(item);
            }
        }
    }
}
