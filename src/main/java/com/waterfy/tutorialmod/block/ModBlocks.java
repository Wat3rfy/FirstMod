package com.waterfy.tutorialmod.block;

import com.waterfy.tutorialmod.TutorialMod;
import com.waterfy.tutorialmod.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModBlocks {

    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering Mod Blocks for" + TutorialMod.MOD_ID);
    }

    private static void registerBlockItem(String name, Block block){
        Identifier id = Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name);
        Registry.register(
                BuiltInRegistries.ITEM,
                id,
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, id)))
        );


    }


}
