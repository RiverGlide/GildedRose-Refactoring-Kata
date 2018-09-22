package com.gildedrose.items;

import com.gildedrose.GildedRoseItem;
import com.gildedrose.Item;

import java.util.function.Function;

@SpecialItem(name = "Backstage passes to a TAFKAL80ETC concert")
public class BackstageItem extends GildedRoseItem {
    public BackstageItem(Item item) {
        super(item);
    }

    public Function<Integer, Integer> beforeSellBy() {
        if(daysLeft() < 5)  { return (quality) -> quality + 3; }
        if(daysLeft() < 10) { return (quality) -> quality + 2; }
        return (quality) -> quality + 1;
    }

    public Function<Integer, Integer> afterSellBy() {
        return (quality) -> 0;
    }
}
