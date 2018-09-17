package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.GildedRoseItem;
import org.reflections.Reflections;

import java.util.HashMap;

public class LookupItem {
    private static HashMap<String,Class<?>> annotatedClasses = null;
    public static GildedRoseItem byName(Item item) {
        if(annotatedClasses == null) { annotatedClasses = findAnnotatedClasses(); }

        Class<?> classToCreate = annotatedClasses.getOrDefault(item.name, GildedRoseItem.class);
        try {
            return (GildedRoseItem) classToCreate.getConstructor(Item.class).newInstance(item);
        } catch (Exception e) {
            throw new RuntimeException("TODO - We don't handle this yet", e);
        }
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
