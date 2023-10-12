package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;
    private final Map<String, UpdateQualityStrategy> strategyMap;
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public GildedRose(Item[] items) {
        this.items = items;
        strategyMap = new HashMap<>();
        strategyMap.put(AGED_BRIE, new AgedBrieUpdateQualityStrategy());
        strategyMap.put(SULFURAS, new SulfurasUpdateQualityStrategy());
        strategyMap.put(BACKSTAGE_PASSES, new BackstagePassesUpdateQualityStrategy());
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateQualityStrategy strategy = strategyMap.getOrDefault(item.name, new DefaultUpdateQualityStrategy());
            strategy.updateQuality(item);
        }
    }
}
