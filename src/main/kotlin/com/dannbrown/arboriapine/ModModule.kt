package com.dannbrown.arboriapine

import com.dannbrown.deltaboxlib.registry.DeltaboxRegistrate
import com.dannbrown.arboriapine.datagen.ModDatagen
import com.dannbrown.arboriapine.init.ModCreativeTabs
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.eventbus.api.EventPriority
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import org.apache.logging.log4j.LogManager
import thedarkcolour.kotlinforforge.forge.DIST

@Mod(ModModule.MOD_ID)
class ModModule {
  companion object {
    const val MOD_ID = "arboriapine"
    const val NAME = "Arboria Series: Pine"
    val LOGGER = LogManager.getLogger()
    val REGISTRATE = DeltaboxRegistrate(MOD_ID)


    // mod compatibility
    fun register(modBus: IEventBus, forgeEventBus: IEventBus) {
      LOGGER.info("$MOD_ID has started!")
      ModCreativeTabs.register(modBus)
      ModItems.register(modBus)

      REGISTRATE.registerEventListeners(modBus)
      modBus.addListener(::commonSetup)
      modBus.addListener(EventPriority.LOWEST) { event: GatherDataEvent -> ModDatagen.gatherData(event) }
    }

    fun registerClient(modBus: IEventBus, forgeEventBus: IEventBus) {
      modBus.addListener(::clientSetup)
    }

    // RUN SETUP
    private fun commonSetup(event: FMLCommonSetupEvent) {
    }

    // Run Client Setup
    private fun clientSetup(event: FMLClientSetupEvent) {
    }
  }

  init {
    val modBus = FMLJavaModLoadingContext.get().modEventBus
    val forgeEventBus = MinecraftForge.EVENT_BUS
    register(modBus, forgeEventBus)
    // client
    if (DIST.isClient) {
      // register main mod client content
      registerClient(modBus, forgeEventBus)
    }
  }
}
