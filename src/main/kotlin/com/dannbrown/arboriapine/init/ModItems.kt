package com.dannbrown.arboriapine

import com.dannbrown.deltaboxlib.registry.generators.ItemGen
import net.minecraftforge.eventbus.api.IEventBus

object ModItems {
  val ITEMS = ItemGen(ModModule.REGISTRATE)

  fun register(bus: IEventBus){
  }
}