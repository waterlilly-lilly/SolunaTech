package dev.waterlilly.soluna

import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Soluna : ModInitializer {
    val LOGGER: Logger = LoggerFactory.getLogger("Soluna")
    val MOD_ID: String = "soluna"
    override fun onInitialize(mod: ModContainer) {
        Modules.init()
    }

}
