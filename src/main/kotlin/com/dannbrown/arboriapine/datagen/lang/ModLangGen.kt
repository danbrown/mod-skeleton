package com.dannbrown.arboriapine.datagen.lang

import com.dannbrown.arboriapine.ModModule
import com.dannbrown.arboriapine.init.ModCreativeTabs

object ModLangGen {
  fun addStaticLangs(doRun: Boolean) {
    if (!doRun) return // avoid running in the server-side
    // Creative tabs
    ModModule.REGISTRATE.addCreativeTabLang(ModCreativeTabs.CREATIVE_TAB_KEY, ModModule.NAME)

  }
}