package com.kakaouo.mods.technoblademod.mixin.client;

import com.kakaouo.mods.technoblademod.entities.client.layers.PigCrownLayer;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.PigRenderer;
import net.minecraft.world.entity.animal.Pig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PigRenderer.class)
public abstract class PigRendererMixin extends LivingEntityRendererMixin<Pig, PigModel<Pig>> {
    @Inject(method = "<init>", at = @At("RETURN"))
    public void injectInit(EntityRendererProvider.Context context, CallbackInfo ci) {
        PigRenderer self = (PigRenderer) (Object) this;
        this.addLayer(new PigCrownLayer<>(self, context));
    }
}
