package dev.crayson

import dev.crayson.commands.GameCommands
import dev.crayson.gui.ApplicationMenu
import dev.crayson.listener.ChatListener
import dev.crayson.listener.EventListener
import dev.crayson.text.TranslationManager
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TranslatableComponent
import net.kyori.adventure.translation.GlobalTranslator
import net.kyori.adventure.translation.TranslationRegistry
import net.kyori.adventure.translation.TranslationStore
import org.bukkit.plugin.java.JavaPlugin
import revxrsal.commands.bukkit.BukkitLamp
import java.text.MessageFormat
import java.util.*


class ChronoApplication : JavaPlugin() {

    companion object {
        lateinit var instance: ChronoApplication
    }

    val lamp = BukkitLamp.builder(this).build()


    lateinit var applicationMenu: ApplicationMenu

    override fun onEnable() {
        instance = this

        TranslationManager.init()

        lamp.register(GameCommands())

        applicationMenu = ApplicationMenu()

        server.pluginManager.apply {
            registerEvents(ChatListener(),this@ChronoApplication)
            registerEvents(EventListener(),this@ChronoApplication)
            registerEvents(applicationMenu,this@ChronoApplication)
        }


        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
