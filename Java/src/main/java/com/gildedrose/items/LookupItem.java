package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.WrappedItem;
import org.reflections.Reflections;

import java.util.HashMap;

public class LookupItem {
    private static HashMap<String,Class<?>> annotatedClasses = null;
    public static WrappedItem byName(Item item) {
        if(annotatedClasses == null) { annotatedClasses = findAnnotatedClasses(); }
        try {
            return (WrappedItem) annotatedClasses.get(item.name).getConstructor(Item.class).newInstance(item);
        } catch (Exception e) {
            throw new RuntimeException("TODO - We don't handle this yet", e);
        }
    }

    private static HashMap<String, Class<?>> findAnnotatedClasses() {
        HashMap<String, Class<?>> result = new HashMap<>();

        Reflections reflections = new Reflections("com.gildedrose.items");
        for(Class<?> annotatedClass : reflections.getTypesAnnotatedWith(GildedRoseItem.class)) {
            result.put(annotatedClass.getAnnotation(GildedRoseItem.class).name(), annotatedClass);
        }

        return result;
    }
}
