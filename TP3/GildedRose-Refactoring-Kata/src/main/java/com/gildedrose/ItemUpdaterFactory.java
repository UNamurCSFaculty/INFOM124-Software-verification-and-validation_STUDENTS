package com.gildedrose;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.gildedrose.exceptions.UnknownItemTypeExceptions;
import com.gildedrose.updater.AgedBrieItemUpdater;
import com.gildedrose.updater.BackstageItemUpdater;
import com.gildedrose.updater.ConjuredItemUpdater;
import com.gildedrose.updater.ItemUpdater;
import com.gildedrose.updater.SulfurasItemUpdater;

/**
 * The ItemUpdaterFactory class is responsible for creating instances of
 * ItemUpdater based on the item's name.
 * It uses a map to associate each item name with its corresponding ItemUpdater
 * class.
 * To add a new item type, simply add a new entry to the map with the item's
 * name as key and the corresponding ItemUpdater class as value.
 */
public class ItemUpdaterFactory {

    private static final Map<String, Class<? extends ItemUpdater>> ITEM_UPDATER_MAP = new HashMap<>();

    static {
        ITEM_UPDATER_MAP.put(AgedBrieItemUpdater.NAME, AgedBrieItemUpdater.class);
        ITEM_UPDATER_MAP.put(BackstageItemUpdater.NAME, BackstageItemUpdater.class);
        ITEM_UPDATER_MAP.put(ConjuredItemUpdater.NAME, ConjuredItemUpdater.class);
        ITEM_UPDATER_MAP.put(SulfurasItemUpdater.NAME, SulfurasItemUpdater.class);
    }

    /**
     * Creates an instance of ItemUpdater based on the given item.
     *
     * @param item the item for which to create the ItemUpdater
     * @return the created ItemUpdater instance for the given item with the right
     *         subclass
     * @throws UnknownItemTypeExceptions if the item's name is not recognized
     */
    public static ItemUpdater create(Item item) throws UnknownItemTypeExceptions {
        Class<? extends ItemUpdater> itemUpdaterClass = ITEM_UPDATER_MAP.get(item.name);
        if (itemUpdaterClass == null) {
            itemUpdaterClass = ItemUpdater.class;
        }
        try {
            return itemUpdaterClass.getDeclaredConstructor(Item.class).newInstance(item);
        } catch (IllegalAccessException | InstantiationException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            throw new UnknownItemTypeExceptions(item.name);
        }
    }

    private ItemUpdaterFactory() {
    }
}
