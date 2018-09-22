package com.gildedrose.items;

import com.gildedrose.GildedRoseItem;
import com.gildedrose.Item;

@SpecialItem(name = "Sulfuras, Hand of Ragnaros")
public class LegendaryItem extends GildedRoseItem {
    public LegendaryItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        // do nothing
    }

    public void decreaseSellBy() {
        //do nothing
    }
}
