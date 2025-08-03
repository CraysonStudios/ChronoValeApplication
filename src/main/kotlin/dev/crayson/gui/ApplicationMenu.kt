package dev.crayson.gui

import dev.crayson.additions.mm
import dev.crayson.items.SummoningGem
import dev.crayson.items.WearablePaper
import dev.triumphteam.gui.builder.item.PaperItemBuilder
import dev.triumphteam.gui.guis.Gui
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta

class ApplicationMenu : Listener {

    private fun getPlayerHead(playerName: String): ItemStack {
        val offlinePlayer: OfflinePlayer = Bukkit.getOfflinePlayer(playerName)
        val skull = ItemStack(Material.PLAYER_HEAD, 1)
        val meta = skull.itemMeta as SkullMeta
        meta.owningPlayer = offlinePlayer
        skull.itemMeta = meta
        return skull
    }


    private val cvpxHead = PaperItemBuilder.from(getPlayerHead("cvpx")).asGuiItem {
        val paper = WearablePaper.create(it.whoClicked as Player)
        it.whoClicked.inventory.addItem(paper)
        it.whoClicked.sendMessage(mm("You have received a Wearable Paper!"))
    }

    private val realMesterHead = PaperItemBuilder.from(getPlayerHead("RealMester")).asGuiItem {
        val gem = SummoningGem.create(it.whoClicked as Player)
        it.whoClicked.inventory.addItem(gem)
        it.whoClicked.sendMessage(mm("You have obtained a Summoning Gem!"))
    }

    fun createGui(invSize: Int): Gui {
        return Gui.gui()
            .rows(invSize)
            .disableAllInteractions()
            .title(mm("<green>Dev Application"))
            .create().apply {
                setItem(3, cvpxHead)
                setItem(5, realMesterHead)
            }
    }
}
