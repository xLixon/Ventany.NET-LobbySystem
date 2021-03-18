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

public class Lumpi implements Listener
{
    String LumpiHatName;
    
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        this.LumpiHatName = "§5Lumpi";
        final Player p = (Player)e.getWhoClicked();
        final ItemStack gommeHat = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        final SkullMeta itemmetaGomme = (SkullMeta)gommeHat.getItemMeta();
        itemmetaGomme.setOwner("Lumpi");
        itemmetaGomme.setDisplayName(this.LumpiHatName);
        gommeHat.setItemMeta((ItemMeta)itemmetaGomme);
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
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.LumpiHatName)) {
                if (p.hasPermission("lobby.hats.Lumpi")) {
                    p.getInventory().setHelmet(gommeHat);
                    p.sendMessage("§9Du hast jetzt folgenden Hat an:");
                    p.sendMessage(p.getInventory().getHelmet().getItemMeta().getDisplayName());
                    p.closeInventory();
                }
                else {
                    p.sendMessage("§cDu hast zu wenig Permissions f\u00fcr den Kopf " + this.LumpiHatName);
                }
            }
        }
    }
}
