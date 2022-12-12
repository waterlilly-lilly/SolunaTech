package dev.waterlilly.soluna

import dev.waterlilly.soluna.core.SolunaCore
import dev.waterlilly.soluna.core.util.ModModule
import dev.waterlilly.soluna.lv.SolunaLV
import net.minecraft.util.Identifier

object Modules {
    val CORE = SolunaCore()
    val LV = SolunaLV()
    fun initModule(module: ModModule) {
        Soluna.LOGGER.info("Initializing module " + module.id)
    }
    fun init() {
        Soluna.LOGGER.info("Starting Soluna module loading...")
        CORE.init()
        LV.init()
    }
}
