package dev.crayson.items

import de.cubbossa.tinytranslations.MessageEncoding
import dev.crayson.ChronoApplication
import dev.crayson.additions.mm
import dev.crayson.text.Messages
import dev.triumphteam.gui.builder.item.PaperItemBuilder
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType


object SummoningGem {
    fun create(): ItemStack {
        return PaperItemBuilder.from(Material.DIAMOND)
            .name(Component.text(Messages.SUMMONING_GEM_NAME.message.toString(MessageEncoding.LEGACY_PARAGRAPH)))
            .lore(Component.text(Messages.SUMMONING_GEM_LORE.message.toString(MessageEncoding.PLAIN)))
            .build().apply {
                itemMeta = itemMeta?.apply {
                    persistentDataContainer.set(
                        NamespacedKey(ChronoApplication.instance, "chrono_type"),
                        PersistentDataType.STRING,
                        "summoning_gem"
                    )
                }
            }
    }
}
