package net.minestom.server.data.type;

import net.minestom.server.data.DataType;
import net.minestom.server.inventory.Inventory;
import net.minestom.server.inventory.InventoryType;
import net.minestom.server.utils.binary.BinaryReader;
import net.minestom.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class InventoryData extends DataType<Inventory> {

    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull Inventory value) {
        final InventoryType inventoryType = value.getInventoryType();
        final int size = inventoryType.getSize();

        // Inventory title & type
        writer.writeSizedString(value.getTitle());
        writer.writeSizedString(inventoryType.name());

        // Write all item stacks
        for (int i = 0; i < size; i++) {
            writer.writeItemStack(value.getItemStack(i));
        }
    }

    @NotNull
    @Override
    public Inventory decode(@NotNull BinaryReader reader) {
        final String title = reader.readSizedString(Integer.MAX_VALUE);
        final InventoryType inventoryType = InventoryType.valueOf(reader.readSizedString(Integer.MAX_VALUE));
        final int size = inventoryType.getSize();

        Inventory inventory = new Inventory(inventoryType, title);

        // Read all item stacks
        for (int i = 0; i < size; i++) {
            inventory.setItemStack(i, reader.readItemStack());
        }

        return inventory;
    }
}
