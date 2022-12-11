package dev.waterlilly.soluna

import dev.waterlilly.soluna.core.SolunaCore
import dev.waterlilly.soluna.core.block.SolunaCoreBlocks
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Soluna : ModInitializer {
    val LOGGER: Logger = LoggerFactory.getLogger("Soluna")
    override fun onInitialize(mod: ModContainer) {
        Modules.init()
    }

}
