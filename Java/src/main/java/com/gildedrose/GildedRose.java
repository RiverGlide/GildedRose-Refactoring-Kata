package com.gildedrose;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GildedRose {
    Item[] items;
    private final List<WrappedItem> wrappedItems;

    public GildedRose(Item[] items) {
        this.items = items;
        wrappedItems = Stream.of(items).map(WrappedItem::new).collect(Collectors.toList());
    }

    public void updateQuality() {
        for(WrappedItem item : wrappedItems) {
            item.updateQuality();
        }
    }
}