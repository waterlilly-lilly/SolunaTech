package dev.waterlilly.soluna

import dev.waterlilly.soluna.core.SolunaCore
import dev.waterlilly.soluna.core.util.ModModule
import net.minecraft.util.Identifier

object Modules {
    val CORE = SolunaCore()
    fun init() {
        Soluna.LOGGER.info("Starting Soluna module loading...")
        CORE.init()
    }
}
