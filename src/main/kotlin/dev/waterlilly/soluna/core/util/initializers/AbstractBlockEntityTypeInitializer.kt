package dev.waterlilly.soluna.core.util.initializers

import dev.waterlilly.soluna.core.block.entity.ElectricMachineBlockEntity
import dev.waterlilly.soluna.core.util.ModModule
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.datafixer.TypeReferences
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Util
import net.minecraft.util.math.Direction
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder
import team.reborn.energy.api.EnergyStorage
import java.util.function.BiFunction

abstract class AbstractBlockEntityTypeInitializer(protected val module: ModModule) {
    fun<T: BlockEntity> register(path: String, builder: QuiltBlockEntityTypeBuilder<T>): BlockEntityType<T>? {
        if(!module.enabled) return null
        module.logger.debug("Register block " + module.identifier(path))
        val type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, module.identifier(path).toString()) // TODO i should probably figure out what this does
        val blockEntity = Registry.register(Registries.BLOCK_ENTITY_TYPE, module.identifier(path), builder.build(type))
        EnergyStorage.SIDED.registerForBlockEntity(
            { entity, _ -> (entity as ElectricMachineBlockEntity).energyStorage },
            blockEntity
        )
        return blockEntity
    }
}
