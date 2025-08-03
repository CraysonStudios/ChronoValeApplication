package dev.crayson.listener

import dev.crayson.ChronoApplication
import io.papermc.paper.command.brigadier.argument.ArgumentTypes.player
import org.bukkit.NamespacedKey
import org.bukkit.entity.EntityType
import org.bukkit.entity.Pig
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.persistence.PersistentDataType


class EventListener: Listener {

    @EventHandler
    fun onInteract(event: PlayerInteractEvent) {
        if (event.action != Action.RIGHT_CLICK_AIR && event.action != Action.RIGHT_CLICK_BLOCK) return

        val item = event.item ?: return
        val meta = item.itemMeta ?: return
        val location = event.player.location

        val container = meta.persistentDataContainer
        val type = container.get(NamespacedKey(ChronoApplication.instance, "chrono_type"), PersistentDataType.STRING)

        if (type == "summoning_gem") {
            event.isCancelled = true
            val pig = location.getWorld().spawnEntity(location, EntityType.PIG) as Pig
            pig.setSaddle(true)
        }
    }

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        val player = event.whoClicked as? Player ?: return

        if (event.slot != 39) return
        val item = event.cursor
        val meta = item.itemMeta ?: return

        val key = NamespacedKey(ChronoApplication.instance, "chrono_type")
        val type = meta.persistentDataContainer.get(key, PersistentDataType.STRING)

        if (type == "wearable_paper") {
            event.isCancelled = true
            player.inventory.helmet = item
            player.setItemOnCursor(null)
        }
    }
}