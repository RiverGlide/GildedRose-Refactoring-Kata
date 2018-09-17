package com.gildedrose;

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
        decreaseQualityBy(pastSellBy() ? 2 : 1);
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

    protected void increaseQualityBy(int i) {
        item.quality += i;
        if(item.quality > 50 ) { item.quality = 50; }
    }

    protected void decreaseQualityBy(int i) {
        item.quality -= i;
        if(item.quality < 0) { item.quality = 0; }
    }

    protected void noQuality() {
        item.quality = 0;
    }
}
