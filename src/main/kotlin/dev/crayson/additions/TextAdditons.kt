package dev.crayson.additions

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage

fun mm(text: String): Component {
    return MiniMessage.miniMessage().deserialize(text)
}
