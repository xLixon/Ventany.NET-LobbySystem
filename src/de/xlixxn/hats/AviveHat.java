// 
// Decompiled by Procyon v0.5.36
// 

package de.xlixxn.hats;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class AviveHat implements Listener {
    String AviveHDNameHats;

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        this.AviveHDNameHats = "§5AviveHD";

        final Player p = (Player) e.getWhoClicked();
        final ItemStack gommeHat = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        final SkullMeta itemmetaGomme = (SkullMeta) gommeHat.getItemMeta();
        itemmetaGomme.setOwner("AviveHD");
        itemmetaGomme.setDisplayName(this.AviveHDNameHats);
        gommeHat.setItemMeta((ItemMeta) itemmetaGomme);

        if (e.isRightClick() || e.isLeftClick()) {
            if (e.getClickedInventory() == null) {
                return;
            }
            if (!e.getClickedInventory().getName().equalsIgnoreCase("§eHats")) {
                return;
            }
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR)) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.AviveHDNameHats)) {
                if (p.hasPermission("lobby.hats.avive")) {
                    p.getInventory().setHelmet(gommeHat);
                    p.sendMessage("§9Du hast jetzt folgenden Hat an:");
                    p.sendMessage(p.getInventory().getHelmet().getItemMeta().getDisplayName());
                    p.closeInventory();
                } else {
                    p.sendMessage("§cDu hast zu wenig Permissions f\u00fcr den Kopf " + this.AviveHDNameHats);
                }
            }
        }
    }
}
