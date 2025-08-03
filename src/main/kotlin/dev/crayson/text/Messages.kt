package dev.crayson.text

import de.cubbossa.tinytranslations.Message
import de.cubbossa.tinytranslations.MessageBuilder
import java.util.Locale

enum class Messages(val message: Message) {


    ERROR_WRONG_INPUT(
        MessageBuilder("chrono.errorwronginput")
            .withDefault("<red>The number must be between 1 and 6")
            .withTranslation(Locale.GERMAN, "<red>Die Zahl muss zwischen 1-6 sein")
            .build()
    ),

    WEARABLE_PAPER_NAME(
        MessageBuilder("item.wearablepaper.name")
            .withDefault("<gradient:#CCCCCC:#FFFFFF>Wearable Paper")
            .build()
    ),

    WEARABLE_PAPER_LORE(
        MessageBuilder("item.wearablepaper.lore")
            .withDefault("A special piece of paper to wear on your head.")
            .withTranslation(Locale.GERMAN, "Ein spezielles Stück Papier, das man auf dem Kopf trägt.")
            .build()
    ),

    SUMMONING_GEM_NAME(
        MessageBuilder("item.summoninggem.name")
            .withDefault("Summoning Gem")
            .build()
    ),

    SUMMONING_GEM_LORE(
        MessageBuilder("item.summoninggem.lore")
            .withDefault("Right-click to summon a rideable pig.")
            .withTranslation(Locale.GERMAN, "Rechtsklick, um ein reitbares Schwein zu spawnen.")
            .build()
    );



}
