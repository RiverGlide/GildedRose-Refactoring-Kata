package com.gildedrose;

public class GildedRoseItem {
    private final Item item;

    public GildedRoseItem(Item item) {
        this.item = item;
    }

    public void updateQuality() {
        item.sellIn = item.sellIn - 1;

        if (degrading(item)) {
            item.quality = item.quality - (!pastSellBy(item) ? 1 : 2);
        } else {
            item.quality = item.quality + (!pastSellBy(item) ? 1 : 2);
            if (backstage(item)) {
                if (item.sellIn < 10) { item.quality = item.quality + 1; }
                if (item.sellIn < 5)  { item.quality = item.quality + 1; }
                if (pastSellBy(item)) { item.quality = 0; }
            }
        }
        if (item.quality < 0)  { item.quality = 0;  }
        if (item.quality > 50) { item.quality = 50; }
    }

    private boolean backstage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean pastSellBy(Item item) {
        return item.sellIn < 0;
    }

    private boolean degrading(Item item) {
        return !maturing(item) && !backstage(item);
    }

    private boolean maturing(Item item) {
        return item.name.equals("Aged Brie");
    }
}
