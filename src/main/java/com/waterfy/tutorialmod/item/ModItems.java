package com.waterfy.tutorialmod.item;

import com.waterfy.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {


    //"Item::new" is the same as "properties -> new Item(properties)"
    public static final Item FLUORITE = registerItem("fluorite", Item::new);
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite", Item::new);

    private static Item registerItem(String name, Function<Item.Properties, Item> function){

        Identifier itemId = Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, itemId);
        return Registry.register(
                BuiltInRegistries.ITEM,
                itemId,
                function.apply(new Item.Properties().setId(key)));
    }



    public static void registerModItems(){

        TutorialMod.LOGGER.info("Registering ModItems for " + TutorialMod.MOD_ID);

        // CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS) will give subscribe us to the event
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(
            output -> {
                output.accept(FLUORITE);
                output.accept(RAW_FLUORITE);});
    }

}

