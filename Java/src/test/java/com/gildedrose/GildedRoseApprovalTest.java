package com.gildedrose;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class GildedRoseApprovalTest {
    @Test
    public void matchesInitialRun() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("/TextRunResults.txt");
        String original = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));

        StringBuffer result = new StringBuffer();
        result.append("OMGHAI!\n");
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 30;

        for (int i = 0; i < days; i++) {
            result.append("-------- day " + i + " --------\n");
            result.append("name, sellIn, quality\n");
            for (Item item : app.items) {
                result.append(item).append("\n");
            }
            result.append("\n");
            app.updateQuality();
        }
        assertEquals(result.toString(), original);
    }
}