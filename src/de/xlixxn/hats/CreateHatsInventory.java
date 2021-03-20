// 
// Decompiled by Procyon v0.5.36
// 

package de.xlixxn.hats;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class CreateHatsInventory implements Listener {
    String GommeHDHatName;
    String RewiHatName;
    String AviveHDHatName;
    String LPMitKevHatName;
    String MinimicheckerHatName;
    String LumpiHatName;

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        this.GommeHDHatName = "§5GommeHD";
        this.RewiHatName = "§5Rewinside";
        this.AviveHDHatName = "§5AviveHD";
        this.LPMitKevHatName = "§5LPMitKev";
        this.MinimicheckerHatName = "§5Minimichecker";
        this.LumpiHatName = "§5Lumpi";
        final Player p = (Player) e.getWhoClicked();
        if (e.isRightClick() || e.isLeftClick()) {
            if (e.getClickedInventory() == null) {
                return;
            }
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR)) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHats")) {
                final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 27, "§eHats");
                final ItemStack ytHat = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                final SkullMeta itemmetaYT = (SkullMeta) ytHat.getItemMeta();
                itemmetaYT.setOwner("MHF_YouTube");
                itemmetaYT.setDisplayName("§4YouTube");
                ytHat.setItemMeta((ItemMeta) itemmetaYT);
                final ItemStack gommeHat = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                final SkullMeta itemmetaGomme = (SkullMeta) gommeHat.getItemMeta();
                itemmetaGomme.setOwner("GommeHD");
                itemmetaGomme.setDisplayName(this.GommeHDHatName);
                gommeHat.setItemMeta((ItemMeta) itemmetaGomme);
                final ItemStack rewiHat = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                final SkullMeta itemmetaRewi = (SkullMeta) rewiHat.getItemMeta();
                itemmetaRewi.setOwner("Rewinside");
                itemmetaRewi.setDisplayName(this.RewiHatName);
                rewiHat.setItemMeta((ItemMeta) itemmetaRewi);
                final ItemStack aviveHat = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                final SkullMeta itemmetaAvive = (SkullMeta) aviveHat.getItemMeta();
                itemmetaAvive.setOwner("AviveHD");
                itemmetaAvive.setDisplayName(this.AviveHDHatName);
                aviveHat.setItemMeta((ItemMeta) itemmetaAvive);
                final ItemStack lpmitkevHat = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                final SkullMeta itemmetaLPMITKEV = (SkullMeta) lpmitkevHat.getItemMeta();
                itemmetaLPMITKEV.setOwner("LPMitKev");
                itemmetaLPMITKEV.setDisplayName(this.LPMitKevHatName);
                lpmitkevHat.setItemMeta((ItemMeta) itemmetaLPMITKEV);
                final ItemStack miniHat = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                final SkullMeta itemmetaHat = (SkullMeta) miniHat.getItemMeta();
                itemmetaHat.setOwner("Minimichecker");
                itemmetaHat.setDisplayName(this.MinimicheckerHatName);
                miniHat.setItemMeta((ItemMeta) itemmetaHat);
                final ItemStack lumpiHat = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                final SkullMeta itemmetaLumpi = (SkullMeta) lumpiHat.getItemMeta();
                itemmetaLumpi.setOwner("Lumpi");
                itemmetaLumpi.setDisplayName(this.LumpiHatName);
                lumpiHat.setItemMeta((ItemMeta) itemmetaLumpi);

                final ItemStack xLixonHat = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                final SkullMeta itemmetaxLixon = (SkullMeta) xLixonHat.getItemMeta();
                itemmetaxLixon.setOwner("xLixon");
                itemmetaxLixon.setDisplayName("§4xLixon");
                xLixonHat.setItemMeta((ItemMeta) itemmetaxLixon);

                final ItemStack TricketyHat = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                final SkullMeta itemmetaTrickety = (SkullMeta) TricketyHat.getItemMeta();
                itemmetaTrickety.setOwner("Trickety");
                itemmetaTrickety.setDisplayName("§4Trickety");
                TricketyHat.setItemMeta((ItemMeta) itemmetaTrickety);

                final ItemStack closeInv = new ItemStack(Material.BARRIER);
                final ItemMeta closeInvMeta = closeInv.getItemMeta();
                closeInvMeta.setDisplayName("§cHat abnehmen");
                closeInv.setItemMeta(closeInvMeta);
                inv.setItem(0, ytHat);
                inv.setItem(2, gommeHat);
                inv.setItem(3, rewiHat);
                inv.setItem(4, aviveHat);
                inv.setItem(5, lpmitkevHat);
                inv.setItem(6, miniHat);
                inv.setItem(7, lumpiHat);
                inv.setItem(26, closeInv);
                inv.setItem(11, xLixonHat);
                inv.setItem(12, TricketyHat);
                p.openInventory(inv);
            }
        }
    }
}
