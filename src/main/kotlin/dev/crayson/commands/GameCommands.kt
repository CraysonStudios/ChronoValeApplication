package dev.crayson.commands

import dev.crayson.ChronoApplication
import dev.crayson.text.Messages
import org.bukkit.entity.Player
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Suggest

class GameCommands {

    @Command("application")
    fun application(player: Player, @Suggest("1", "2", "3", "4", "5", "6") rows: Int) {
        if (rows <= 0 || rows > 6) {
            player.sendMessage(Messages.ERROR_WRONG_INPUT.message)
        } else {
            val gui = ChronoApplication.instance.applicationMenu.createGui(rows)
            gui.open(player)
        }
    }
}