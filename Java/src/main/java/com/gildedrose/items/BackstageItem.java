package com.gildedrose.items;

import com.gildedrose.GildedRoseItem;
import com.gildedrose.Item;

@SpecialItem(name = "Backstage passes to a TAFKAL80ETC concert")
public class BackstageItem extends GildedRoseItem {
    public BackstageItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseSellBy();

        increaseQualityBy(1);
        if (daysLeft() < 10) { increaseQualityBy(1); }
        if (daysLeft() < 5)  { increaseQualityBy(1); }

        if (pastSellBy())    { noQuality(); }
    }
}
