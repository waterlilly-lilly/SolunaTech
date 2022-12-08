package dev.waterlilly.soluna.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import dev.waterlilly.soluna.Soluna;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
	@Inject(method = "init", at = @At("TAIL"))
	public void soluna$onInit(CallbackInfo ci) {
		Soluna.INSTANCE.getLOGGER().info("This line is printed by an example mod mixin!");
	}
}
