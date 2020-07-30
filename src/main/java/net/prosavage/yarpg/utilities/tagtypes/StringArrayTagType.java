package net.prosavage.yarpg.utilities.tagtypes;

import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class StringArrayTagType implements PersistentDataType<String, String[]> {

    @Override
    public @NotNull Class<String> getPrimitiveType() {
        return String.class;
    }

    @Override
    public @NotNull Class<String[]> getComplexType() {
        return String[].class;
    }

    @Override
    public @NotNull String toPrimitive(String @NotNull [] complex, @NotNull PersistentDataAdapterContext context) {
        return String.join("||", complex);
    }

    @Override
    public String @NotNull [] fromPrimitive(@NotNull String primitive, @NotNull PersistentDataAdapterContext context) {
        return primitive.split("\\|\\|");
    }

}