package dev.crayson.items

import de.cubbossa.tinytranslations.MessageEncoding
import dev.crayson.ChronoApplication
import dev.crayson.additions.mm
import dev.crayson.text.Messages
import dev.triumphteam.gui.builder.item.ItemBuilder
import dev.triumphteam.gui.builder.item.PaperItemBuilder
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

object WearablePaper {
    fun create(player: Player): ItemStack {
        val locale = player.locale()
        return PaperItemBuilder.from(Material.PAPER)
            .name(Component.text(Messages.WEARABLE_PAPER_NAME.message.toString(MessageEncoding.LEGACY_PARAGRAPH)))
            .lore(Component.text(Messages.WEARABLE_PAPER_LORE.message.toString(MessageEncoding.LEGACY_PARAGRAPH, locale)))
            .build().apply {
                itemMeta = itemMeta.apply {
                    persistentDataContainer.set(
                        NamespacedKey(ChronoApplication.instance, "chrono_type"),
                        PersistentDataType.STRING,
                        "wearable_paper"
                    )
                }
            }
    }
}
