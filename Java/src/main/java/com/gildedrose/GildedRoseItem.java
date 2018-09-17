package com.gildedrose;

public class GildedRoseItem {
    private final Item item;

    public GildedRoseItem(Item item) {
        this.item = item;
    }

    public void updateQuality() {
        decreaseSellBy();

        if (degrading(item)) {
            decreaseQualityBy(pastSellBy(item) ? 2 : 1);
        } else {
            increaseQualityBy(1);
            if (backstage(item)) {
                if (item.sellIn < 10) { increaseQualityBy(1); }
                if (item.sellIn < 5)  { increaseQualityBy(1); }
                if (pastSellBy(item)) { item.quality = 0; }
            }
        }
    }

    private boolean backstage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    protected boolean pastSellBy(Item item) {
        return item.sellIn < 0;
    }

    protected void decreaseSellBy() {
        item.sellIn--;
    }

    protected boolean pastSellBy() {
        return pastSellBy(item);
    }

    private boolean degrading(Item item) {
        return !backstage(item);
    }

    protected void increaseQualityBy(int i) {
        item.quality += i;
        if(item.quality > 50 ) { item.quality = 50; }
    }

    protected void decreaseQualityBy(int i) {
        item.quality -= i;
        if(item.quality < 0) { item.quality = 0; }
    }
}
