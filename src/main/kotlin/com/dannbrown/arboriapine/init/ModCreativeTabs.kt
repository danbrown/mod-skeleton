package com.dannbrown.arboriapine.init

import com.dannbrown.deltaboxlib.registry.generators.CreativeTabGen
import com.dannbrown.arboriapine.ModModule
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.RegistryObject

object ModCreativeTabs {
  val TABS: DeferredRegister<CreativeModeTab> = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModModule.MOD_ID)

  fun register(modBus: IEventBus) {
    TABS.register(modBus)
  }

  val CREATIVE_TAB_KEY = "mod_tab"

  val MOD_TAB: RegistryObject<CreativeModeTab> =
    CreativeTabGen(TABS, ModModule.MOD_ID).createTab(
      CREATIVE_TAB_KEY,
      { ItemStack(Items.DIAMOND) },
      CreativeModeTabs.SPAWN_EGGS,
      { parameters, output ->
      }
    )
}