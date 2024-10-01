package com.dannbrown.arboriapine.datagen.recipe

import com.dannbrown.arboriapine.ModModule
import com.dannbrown.deltaboxlib.registry.datagen.recipe.DeltaboxRecipeSlice
import net.minecraft.data.recipes.FinishedRecipe
import java.util.function.Consumer

class MainRecipeGen : DeltaboxRecipeSlice(ModModule.MOD_ID) {
  override fun name(): String {
    return "Mod Recipes"
  }
  override fun addRecipes(recipeConsumer: Consumer<FinishedRecipe>) {
  }
}