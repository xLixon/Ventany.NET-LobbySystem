// 
// Decompiled by Procyon v0.5.36
// 

package de.lobbyplus.items;

import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.Listener;

public class Spawn implements Listener
{
    String displayNameSpawnItem;
    
    public Spawn() {
        this.displayNameSpawnItem = "§6§lSpawn";
    }
    
    public void spawnItem(final InventoryOpenEvent e) {
        final HumanEntity p = e.getPlayer();
        final ItemStack itemSpawn = new ItemStack(Material.MAGMA_CREAM);
        final ItemMeta itemmetaHide = itemSpawn.getItemMeta();
        itemmetaHide.setDisplayName(this.displayNameSpawnItem);
        itemSpawn.setItemMeta(itemmetaHide);
        p.getInventory().setItem(14, itemSpawn);
    }
    
    public void onInteract(final PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            e.getItem();
        }
    }
}
