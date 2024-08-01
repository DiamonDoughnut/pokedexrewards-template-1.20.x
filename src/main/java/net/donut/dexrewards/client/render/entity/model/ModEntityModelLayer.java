//package net.donut.dexrewards.client.render.entity.model;
//
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.minecraft.util.Identifier;
//
//@Environment(EnvType.CLIENT)
//public final class ModEntityModelLayer {
//    private final Identifier id;
//    private final String name;
//
//    public ModEntityModelLayer(Identifier id, String name){
//        this.id = id;
//        this.name = name;
//    }
//
//    public Identifier getId(){
//        return this.id;
//    }
//
//    public String getName(){
//        return this.name;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if(this == obj){
//            return true;
//        }
//        else if(!(obj instanceof ModEntityModelLayer)) {
//            return false;
//        }
//        else {
//            ModEntityModelLayer modEntityModelLayer = (ModEntityModelLayer) obj;
//            return this.id.equals(modEntityModelLayer.id) && this.name.equals(modEntityModelLayer.name);
//        }
//    }
//
//    public int HashCode(){
//        int i = this.id.hashCode();
//        i = 31 * i + this.name.hashCode();
//        return i;
//    }
//
//    public String toString(){return this.id + "#" + this.name;}
//}
