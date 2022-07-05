package com.kakaouo.mods.technoblademod;

import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mod {
    public static final String NAMESPACE = "technoblademod";
    public static final Logger logger = LogManager.getLogger("YuunaLive");
    public static ResourceLocation id(String path) {
        return new ResourceLocation(NAMESPACE, path);
    }
    private static Platform hostPlatform;

    public static Platform getPlatform() {
        return hostPlatform;
    }

    // Called by platform
    public static void init() {
        Platform platform = PlatformManager.getPlatform();
        if (platform == null) {
            throw new UnsupportedOperationException("Platform is not initialized!");
        }
        hostPlatform = platform;
        logger.debug("TechnobladeMod is running on {}!", platform.getPlatformName());
        logger.info("Technoblade never dies!");
    }
}
