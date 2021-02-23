package net.minestom.server.entity.metadata.other;

import net.minestom.server.entity.Entity;
import net.minestom.server.entity.Metadata;
import net.minestom.server.entity.metadata.BaseEntityMeta;
import net.minestom.server.particle.Particle;
import net.minestom.server.particle.ParticleType;
import org.jetbrains.annotations.NotNull;

public class AreaEffectCloudMeta extends BaseEntityMeta {

    public AreaEffectCloudMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    public float getRadius() {
        return super.metadata.getIndex((byte) 7, .5F);
    }

    public void setRadius(float value) {
        super.metadata.setIndex((byte) 7, Metadata.Float(value));
    }

    public int getColor() {
        return super.metadata.getIndex((byte) 8, 0);
    }

    public void setColor(int value) {
        super.metadata.setIndex((byte) 8, Metadata.VarInt(value));
    }

    public boolean isSinglePoint() {
        return super.metadata.getIndex((byte) 9, false);
    }

    public void setSinglePoint(boolean value) {
        super.metadata.setIndex((byte) 9, Metadata.Boolean(value));
    }

    public Particle getParticle() {
        return super.metadata.getIndex((byte) 10, new Particle(ParticleType.EFFECT, null));
    }

    public void setParticle(Particle value) {
        super.metadata.setIndex((byte) 11, Metadata.Particle(value));
    }

}
