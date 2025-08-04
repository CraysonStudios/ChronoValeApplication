import net.kyori.adventure.text.Component

// Messages.kt
enum class Messages(val key: String, val defaultMessage: String, val germanMessage: String?) {

    ERROR_WRONG_INPUT(
        "chrono.errorwronginput",
        "<red>The number must be between 1 and 6",
        "<red>Die Zahl muss zwischen 1-6 sein"
    ),

    WEARABLE_PAPER_NAME(
        "item.wearablepaper.name",
        "<gradient:#CCCCCC:#FFFFFF>Wearable Paper",
        null
    ),

    WEARABLE_PAPER_LORE(
        "item.wearablepaper.lore",
        "A special piece of paper to wear on your head.",
        "Ein spezielles Stück Papier, das man auf dem Kopf trägt."
    ),

    SUMMONING_GEM_NAME(
        "item.summoninggem.name",
        "Summoning Gem",
        null
    ),

    SUMMONING_GEM_LORE(
        "item.summoninggem.lore",
        "Right-click to summon a rideable pig.",
        "Rechtsklick, um ein reitbares Schwein zu spawnen."
    );

    fun getComponent() = Component.translatable(key)
}
