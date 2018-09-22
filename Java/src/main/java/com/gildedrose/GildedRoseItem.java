package com.gildedrose;

import java.util.function.Function;

public class GildedRoseItem {
    private final Item item;

    public GildedRoseItem(Item item) {
        this.item = item;
    }

    public void updateSellByAndQuality() {
        decreaseSellBy();
        updateQuality();
    }

    public void updateQuality() {
        if(pastSellBy()) {
            item.quality = afterSellBy().apply(item.quality);
        }
        else {
            item.quality = beforeSellBy().apply(item.quality);
        }

        if(item.quality < 0)  { item.quality = 0;  }
        if(item.quality > 50) { item.quality = 50; }
    }

    public Function<Integer, Integer> beforeSellBy() {
        return (quality) -> quality - 1;
    }

    public Function<Integer, Integer> afterSellBy() {
        return (quality) -> quality - 2;
    }

    protected void decreaseSellBy() {
        item.sellIn--;
    }

    protected boolean pastSellBy() {
        return item.sellIn < 0;
    }

    protected int daysLeft() {
        return item.sellIn;
    }
}