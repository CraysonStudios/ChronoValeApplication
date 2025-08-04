package dev.crayson.text

import net.kyori.adventure.key.Key
import net.kyori.adventure.translation.GlobalTranslator
import net.kyori.adventure.translation.TranslationStore
import java.text.MessageFormat
import java.util.Locale

object TranslationManager {

    val globalTranslator = GlobalTranslator.translator()
    val translationStore = TranslationStore.messageFormat(Key.key("chrono", "messages"))

    fun init() {
        for (msg in Messages.entries) {
            translationStore.register(msg.key, Locale.US, MessageFormat(msg.defaultMessage))

            msg.germanMessage?.let {
                translationStore.register(msg.key, Locale.GERMAN, MessageFormat(it))
            }
        }
        globalTranslator.addSource(translationStore)
    }
}
