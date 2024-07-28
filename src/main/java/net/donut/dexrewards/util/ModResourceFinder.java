package net.donut.dexrewards.util;

import net.minecraft.resource.ResourceFinder;

public class ModResourceFinder extends ResourceFinder {
    String resourcePath;
    String fileExtension;
    public ModResourceFinder(String directoryName, String fileExtension) {
        super(directoryName, fileExtension);
        this.resourcePath = directoryName;
        this.fileExtension = fileExtension;
    }

}
