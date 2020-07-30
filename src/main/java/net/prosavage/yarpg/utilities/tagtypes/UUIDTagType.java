package net.prosavage.yarpg.utilities.tagtypes;

import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class UUIDTagType implements PersistentDataType<String, UUID> {

    @Override
    public @NotNull Class<String> getPrimitiveType() {
        return String.class;
    }

    @Override
    public @NotNull Class<UUID> getComplexType() {
        return UUID.class;
    }

    @Override
    public @NotNull String toPrimitive(UUID complex, @NotNull PersistentDataAdapterContext context) {
        return complex.toString();
    }

    @Override
    public @NotNull UUID fromPrimitive(@NotNull String primitive, @NotNull PersistentDataAdapterContext context) {
        return UUID.fromString(primitive);
    }
}