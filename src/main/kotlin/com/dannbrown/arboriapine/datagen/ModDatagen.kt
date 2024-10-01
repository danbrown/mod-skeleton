package com.dannbrown.arboriapine.datagen

import com.dannbrown.deltaboxlib.registry.datagen.DatagenRootInterface
import com.dannbrown.deltaboxlib.registry.datagen.recipe.DeltaboxRecipeProvider
import com.dannbrown.arboriapine.ModModule
import com.dannbrown.arboriapine.datagen.lang.ModLangGen
import com.dannbrown.arboriapine.datagen.recipe.MainRecipeGen
import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider
import net.minecraftforge.data.event.GatherDataEvent
import java.util.concurrent.CompletableFuture

class ModDatagen(output: PackOutput, future: CompletableFuture<HolderLookup.Provider>) : DatapackBuiltinEntriesProvider(output, future, BUILDER, modIds){
  companion object: DatagenRootInterface{
    override val modIds: MutableSet<String> = mutableSetOf(
      ModModule.MOD_ID
    )
    override val BUILDER: RegistrySetBuilder = RegistrySetBuilder()

    override fun gatherData(event: GatherDataEvent) {
      val generator = event.generator
      val packOutput = generator.packOutput
      val lookupProvider = event.lookupProvider
      val existingFileHelper = event.existingFileHelper
      // Builder generators above
      generator.addProvider(event.includeServer(), ModDatagen(packOutput, lookupProvider))
      // Langs
      ModLangGen.addStaticLangs(event.includeClient())
      // Recipes
      generator.addProvider(event.includeServer(), DeltaboxRecipeProvider(packOutput, listOf(MainRecipeGen())))
    }
  }
}