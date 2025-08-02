package dev.crayson

import org.bukkit.plugin.java.JavaPlugin
import revxrsal.commands.Lamp
import revxrsal.commands.bukkit.BukkitLamp
import revxrsal.commands.bukkit.actor.BukkitCommandActor

class PaperTemplate : JavaPlugin() {

    companion object {
        lateinit var instance: PaperTemplate
    }

    val lamp = BukkitLamp.builder(this).build()

    override fun onEnable() {
        instance = this

        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
