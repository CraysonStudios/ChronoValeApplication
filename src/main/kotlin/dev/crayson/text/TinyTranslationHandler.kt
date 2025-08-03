package dev.crayson.text

import de.cubbossa.tinytranslations.MessageTranslator
import de.cubbossa.tinytranslations.TinyTranslations
import de.cubbossa.tinytranslations.storage.properties.PropertiesMessageStorage
import de.cubbossa.tinytranslations.storage.properties.PropertiesStyleStorage
import java.io.File
import java.util.Locale

class TinyTranslationHandler {

    lateinit var translator: MessageTranslator
        private set

    fun init() {
        val langFolder = File("./plugins/ChronoApplication", "lang")
        if (!langFolder.exists()) {
            langFolder.mkdirs()
        }

        translator = TinyTranslations.application("ChronoApplication")

        translator.messageStorage = PropertiesMessageStorage(langFolder)
        translator.styleStorage = PropertiesStyleStorage(File(langFolder, "styles.properties"))

        save()
        load()
    }

    fun save() {
        translator.saveLocale(Locale.ENGLISH)
        translator.saveLocale(Locale.GERMAN)
    }

    fun load() {
        translator.loadStyles()
        translator.loadLocales()
    }
}
