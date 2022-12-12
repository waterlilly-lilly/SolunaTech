package dev.waterlilly.soluna.lv

import dev.waterlilly.soluna.core.util.ModModule
import dev.waterlilly.soluna.lv.block.SolunaLVBlocks
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

class SolunaLV : ModModule {
    override val id = Identifier("soluna:lv")
    override val logger = LoggerFactory.getLogger("Soluna/LV")
    override val enabled = true

    override fun init() {
        logger.info("Initializing LV module...")
        SolunaLVBlocks.init()
        logger.info("LV module loading complete!")
    }
}
