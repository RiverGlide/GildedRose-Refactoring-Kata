package com.gildedrose.items;

import com.gildedrose.GildedRoseItem;
import com.gildedrose.Item;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class WrapAllItems {
    private static HashMap<String,Class<?>> annotatedClasses = null;

    public static List<GildedRoseItem> wrapped(Item[] items) {
        return Stream.of(items)
                .map(WrapAllItems::byItemName)
                .collect(toList());
    }

    public static GildedRoseItem byItemName(Item item) {
        return createFrom(classOf(item), item);
    }

    private static GildedRoseItem createFrom(Class<?> classOfItem, Item item) {
        try {
            return (GildedRoseItem) classOfItem.getConstructor(Item.class).newInstance(item);
        } catch (Exception e) {
            throw new RuntimeException("TODO - We don't handle this yet", e);
        }
    }

    private static Class<?> classOf(Item item) {
        if(annotatedClasses == null) { annotatedClasses = findAnnotatedClasses(); }

        return annotatedClasses.getOrDefault(item.name, GildedRoseItem.class);
    }

    private static HashMap<String, Class<?>> findAnnotatedClasses() {
        HashMap<String, Class<?>> result = new HashMap<>();

        Reflections reflections = new Reflections("com.gildedrose.items");
        for(Class<?> annotatedClass : reflections.getTypesAnnotatedWith(SpecialItem.class)) {
            result.put(annotatedClass.getAnnotation(SpecialItem.class).name(), annotatedClass);
        }

        return result;
    }
}