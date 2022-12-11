package dev.waterlilly.soluna.core

import dev.waterlilly.soluna.Soluna
import dev.waterlilly.soluna.core.block.SolunaCoreBlocks
import dev.waterlilly.soluna.core.util.ModModule
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

class SolunaCore : ModModule {
    override val id = Identifier(Soluna.MOD_ID, "core")
    override val logger = LoggerFactory.getLogger("Soluna/Core")
    override val enabled = true
    override fun init() {
        logger.info("Initializing core module...")
        SolunaCoreBlocks.init()
        logger.info("Core module loading complete!")
    }
}
