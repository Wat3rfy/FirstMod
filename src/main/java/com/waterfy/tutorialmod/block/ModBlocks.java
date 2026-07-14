package com.waterfy.tutorialmod.block;

import com.waterfy.tutorialmod.TutorialMod;
import com.waterfy.tutorialmod.item.ModItems;
import jdk.jfr.Frequency;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {



    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering Mod Blocks for" + TutorialMod.MOD_ID);
    }

    public static final Block FLUORITE_BLOCK = registerBlock("fluorite_block", properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final Block RAW_FLUORITE_BLOCK = registerBlock("raw_fluorite_block", properties -> new Block(properties.strength(3f).requiresCorrectToolForDrops()));
    public static final Block FLUORITE_ORE = registerBlock("fluorite_ore", properties -> new DropExperienceBlock(UniformInt.of(2,5), properties.strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final Block FLUORITE_DEEPSLATE_ORE = registerBlock("fluorite_deepslate_ore", properties -> new DropExperienceBlock(UniformInt.of(4,6),properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final Block FLUORITE_NETHER_ORE = registerBlock("fluorite_nether_ore", properties -> new DropExperienceBlock(UniformInt.of(4,6),properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHER_ORE)));
    public static final Block FLUORITE_END_ORE = registerBlock("fluorite_end_ore", properties -> new DropExperienceBlock(UniformInt.of(4,6),properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function){
        Identifier id = Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name);
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, id)));
        registerBlockItem(name, toRegister);
        return  Registry.register(BuiltInRegistries.BLOCK, id, toRegister);
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
