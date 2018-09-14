package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if(isLegendary(item)) { continue; }

            if (degrading(item)) {
                item.quality = item.quality - 1;
            } else {
                item.quality = item.quality + 1;
                if (backstage(item)) {
                    if (item.sellIn < 11) { item.quality = item.quality + 1; }
                    if (item.sellIn < 6)  { item.quality = item.quality + 1; }
                }
            }

            item.sellIn = item.sellIn - 1;

            if (pastSellBy(item)) {
                if(backstage(item)) {
                    item.quality = 0;
                    continue;
                }

                if (maturing(item)) {
                    item.quality = item.quality + 1;
                } else {
                    item.quality = item.quality - 1;
                }
            }
            if (item.quality < 0)  { item.quality = 0;  }
            if (item.quality > 50) { item.quality = 50; }
        }
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

    private boolean isLegendary(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

}