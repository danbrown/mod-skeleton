package com.dannbrown.braziliandelight.init

import com.dannbrown.braziliandelight.content.blocks.creakingHeart.CreakingHeartBlockEntity
import com.dannbrown.braziliandelight.content.blocks.eyeblossom.EyeBlossomBlockEntity
import com.dannbrown.braziliandelight.content.blocks.eyeblossom.EyeBlossomRenderer
import com.dannbrown.braziliandelight.init.ModContent.REGISTRATE

object ModBlockEntities {

  val EYEBLOSSOM_BLOCK_ENTITY = REGISTRATE
    .blockEntity<EyeBlossomBlockEntity>("eyeblossom")
    .factory { t, p, s -> EyeBlossomBlockEntity(t.get(), p, s) }
    .validBlocks(ModBlocks.EYE_BLOSSOM, ModBlocks.CLOSED_EYE_BLOSSOM)
    .renderer { ctx -> EyeBlossomRenderer(ctx) }
    .register()

  val CREAKING_HEART_BLOCK_ENTITY = REGISTRATE
    .blockEntity<CreakingHeartBlockEntity>("creaking_heart")
    .factory { t, p, s -> CreakingHeartBlockEntity(t.get(), p, s) }
    .validBlocks(ModBlocks.CREAKING_HEART)
    .register()

  fun register() {
    // init
  }
}