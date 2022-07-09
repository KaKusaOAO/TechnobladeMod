package com.kakaouo.mods.technoblademod.entities.client.layers;

import com.kakaouo.mods.technoblademod.Mod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Pig;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Objects;

public class PigCrownLayer<T extends Pig, M extends PigModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation CROWN_TEXTURE = Mod.id("textures/entity/pig/crowned.png");
    private final PigModel<T> model;

    public PigCrownLayer(RenderLayerParent<T, M> renderLayerParent, EntityRendererProvider.Context context) {
        super(renderLayerParent);
        this.model = new PigModel<>(context.bakeLayer(ModelLayers.PIG_SADDLE));
    }

    @Override
    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull T entity, float f, float g, float h, float j, float k, float l) {
        if (!entity.hasCustomName()) return;
        Component name = Objects.requireNonNull(entity.getCustomName());
        // if (!"Technoblade".equals(ChatFormatting.stripFormatting(name.getString()))) return;

        String str = ChatFormatting.stripFormatting(name.getString());
        if (str == null) return;
        if (!str.toLowerCase(Locale.ROOT).contains("techno")) return;

        this.getParentModel().copyPropertiesTo(this.model);
        this.model.prepareMobModel(entity, f, g, h);
        this.model.setupAnim(entity, f, g, j, k, l);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(CROWN_TEXTURE));
        this.model.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}
