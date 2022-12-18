package dev.waterlilly.soluna

import dev.waterlilly.soluna.core.SolunaCore
import dev.waterlilly.soluna.lv.SolunaLV

object Modules {
    /**
     * The core module. Contains all the most important stuff. Cannot be disabled.
     */
    val CORE = SolunaCore()

    /**
     * The Low-Voltage Electronics module. Contains electronics that run at voltages below 400 volts.
     */
    val LV = SolunaLV()

    /**
     * Initializes all the modules.
     */
    fun init() {
        Soluna.LOGGER.info("Starting Soluna module loading...")
        CORE.init()
        LV.init()
    }
}
