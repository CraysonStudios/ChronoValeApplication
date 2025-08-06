package dev.crayson.listener

import io.papermc.paper.chat.ChatRenderer
import io.papermc.paper.command.brigadier.argument.ArgumentTypes.player
import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.HoverEvent
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class ChatListener : Listener, ChatRenderer {

    @EventHandler
    fun onPlayerChat(event: AsyncChatEvent) {
        val player = event.player
        val message = event.message()

        if (message.toString().contains("[item]") && !player.inventory.itemInMainHand.isEmpty) {
            event.renderer(this)
        }
    }

    override fun render(
        source: Player,
        sourceDisplayName: Component,
        message: Component,
        viewer: Audience
    ): Component {
        val itemInHand = source.inventory.itemInMainHand
        val itemMeta = itemInHand.itemMeta

        val itemName = if (itemMeta != null && itemMeta.hasDisplayName()) {
            itemMeta.displayName()
        } else {
            Component.text(
                itemInHand.type.name.lowercase()
                    .replace("_", " ")
                    .replaceFirstChar { it.uppercase() }
            )
        }

        val hoverTextBuilder = Component.text()
            .append(Component.text("Name: ").color(NamedTextColor.GRAY))
            .append(itemName!!).append(Component.newline())
            .append(Component.text("Amount: ${itemInHand.amount}").color(NamedTextColor.GRAY))
            .append(Component.newline())

        val lore = itemMeta?.lore()
        if (!lore.isNullOrEmpty()) {
            hoverTextBuilder.append(Component.text("Lore:").color(NamedTextColor.GRAY)).append(Component.newline())
            for (line in lore) {
                hoverTextBuilder.append(Component.text("- ").color(NamedTextColor.DARK_GRAY))
                    .append(line).append(Component.newline())
            }
        }

        val plainMessage = PlainTextComponentSerializer.plainText().serialize(message)
        val parts = plainMessage.split("[item]")


        val rebuiltMessage = Component.text()
        for ((index, part) in parts.withIndex()) {
            rebuiltMessage.append(Component.text(part))
            if (index < parts.size - 1) {
                rebuiltMessage.append(
                    itemName.hoverEvent(HoverEvent.showText(hoverTextBuilder.build()))
                )
            }
        }

        return sourceDisplayName
            .append(Component.text(": "))
            .append(rebuiltMessage)
    }
}
