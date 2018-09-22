package com.gildedrose;

import java.util.List;

import static com.gildedrose.items.WrapAllItems.wrapped;

class GildedRose {
    Item[] items;
    private final List<GildedRoseItem> gildedRoseItems;

    public GildedRose(Item[] items) {
        this.items = items;
        gildedRoseItems = wrapped(items);
    }

    public void updateQuality() {
        for(GildedRoseItem item : gildedRoseItems) {
            item.updateSellByAndQuality();
        }
    }
}