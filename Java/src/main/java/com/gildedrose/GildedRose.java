package com.gildedrose;

import com.gildedrose.items.LookupItem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GildedRose {
    Item[] items;
    private final List<GildedRoseItem> gildedRoseItems;

    public GildedRose(Item[] items) {
        this.items = items;
        gildedRoseItems = Stream.of(items).map(LookupItem::byName).collect(Collectors.toList());
    }

    public void updateQuality() {
        for(GildedRoseItem item : gildedRoseItems) {
            item.updateSellByAndQuality();
        }
    }
}