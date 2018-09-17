package com.gildedrose.items;

import com.gildedrose.GildedRoseItem;
import com.gildedrose.Item;

@SpecialItem(name = "Aged Brie")
public class MaturingItem extends GildedRoseItem {
    public MaturingItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQualityBy(pastSellBy() ? 2 : 1);
    }
}