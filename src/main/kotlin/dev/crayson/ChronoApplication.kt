package dev.crayson

import dev.crayson.commands.GameCommands
import dev.crayson.gui.ApplicationMenu
import dev.crayson.listener.EventListener
import dev.crayson.text.Messages
import dev.crayson.text.TinyTranslationHandler
import org.bukkit.plugin.java.JavaPlugin
import revxrsal.commands.bukkit.BukkitLamp
import java.util.Arrays

class ChronoApplication : JavaPlugin() {

    companion object {
        lateinit var instance: ChronoApplication
    }

    val lamp = BukkitLamp.builder(this).build()

    val translationHandler = TinyTranslationHandler()

    lateinit var applicationMenu: ApplicationMenu

    override fun onEnable() {
        instance = this

        translationHandler.init()

        Arrays.stream(Messages.values()).forEach { message ->
            translationHandler.translator.addMessage(message.message)
        }

        translationHandler.save()
        translationHandler.load()

        lamp.register(GameCommands())

        applicationMenu = ApplicationMenu()

        server.pluginManager.registerEvents(applicationMenu, this)
        server.pluginManager.registerEvents(EventListener(), this)


        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
