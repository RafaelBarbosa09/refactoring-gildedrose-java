package com.gildedrose;

public class DefaultUpdateQualityStrategy implements UpdateQualityStrategy {
    @Override
    public void updateQuality(Item item) {
        GildedRoseUtil.decreaseQuality(item);
        GildedRoseUtil.decreaseSellIn(item);
        if (GildedRoseUtil.isSellInNegative(item) && GildedRoseUtil.hasQuality(item)) {
            GildedRoseUtil.decreaseQuality(item);
        }
    }
}
