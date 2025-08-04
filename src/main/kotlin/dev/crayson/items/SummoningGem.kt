package dev.crayson.items

import dev.crayson.ChronoApplication
import dev.triumphteam.gui.builder.item.PaperItemBuilder
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType


object SummoningGem {
    fun create(player: Player): ItemStack {
        val locale = player.locale()
        return PaperItemBuilder.from(Material.DIAMOND)
            .name(Messages.SUMMONING_GEM_NAME.getComponent())
            .lore(Messages.SUMMONING_GEM_LORE.getComponent())
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
