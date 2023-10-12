package com.gildedrose;

public class AgedBrieUpdateQualityStrategy implements UpdateQualityStrategy {
    @Override
    public void updateQuality(Item item) {
        GildedRoseUtil.increaseQuality(item);
        GildedRoseUtil.decreaseSellIn(item);
        if (GildedRoseUtil.isSellInNegative(item) && GildedRoseUtil.canIncreaseQuality(item)) {
            GildedRoseUtil.increaseQuality(item);
        }
    }
}
