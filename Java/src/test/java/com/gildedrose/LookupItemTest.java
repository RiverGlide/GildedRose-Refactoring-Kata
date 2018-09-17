package com.gildedrose;

import com.gildedrose.items.LegendaryItem;
import com.gildedrose.items.LookupItem;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class LookupItemTest {
    @Test
    public void findALegendaryItem() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 1, 80);
        GildedRoseItem gildedRoseItem = LookupItem.byName(sulfuras);

        assertThat(gildedRoseItem.getClass(), is(equalTo(LegendaryItem.class)));
    }

    @Test
    public void findAnOrdinaryItemWhenNotASpecialType() {
        Item notSpecialItem = new Item("Standard Item", 5, 10);
        GildedRoseItem gildedRoseItem = LookupItem.byName(notSpecialItem);

        assertThat(gildedRoseItem.getClass(), is(equalTo(GildedRoseItem.class)));
    }
}
