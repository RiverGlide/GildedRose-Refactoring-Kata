package com.gildedrose.items;

import com.gildedrose.GildedRoseItem;
import com.gildedrose.Item;

import java.util.function.Function;

@SpecialItem(name = "Aged Brie")
public class MaturingItem extends GildedRoseItem {
    public MaturingItem(Item item) {
        super(item);
    }

    public Function<Integer, Integer> beforeSellBy() {
        return (quality) -> quality + 1;
    }

    public Function<Integer, Integer> afterSellBy() {
        return (quality) -> quality + 2;
    }
}