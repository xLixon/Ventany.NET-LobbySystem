package de.apis;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.mojang.authlib.GameProfile;

public class ChangeName {
	
	 public static void changeName(String name, Player player) {
	        try {
	            Method getHandle = player.getClass().getMethod("getHandle");
	            Object entityPlayer = getHandle.invoke(player);
	            Class<?> entityHuman = entityPlayer.getClass().getSuperclass();
	            Field gameProfileField;
	            int majVersion = Integer.parseInt(Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3].replaceAll("(v|R[0-9]+)", "").split("_")[0]);
	            int minVersion = Integer.parseInt(Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3].replaceAll("(v|R[0-9]+)", "").split("_")[1]);
	            if (majVersion >= 1 && minVersion >= 9) {
	                gameProfileField = entityHuman.getDeclaredField("bS");
	            } else {
	                gameProfileField = entityHuman.getDeclaredField("bH");
	            }
	            gameProfileField.setAccessible(true);
	            gameProfileField.set(entityPlayer, new GameProfile(player.getUniqueId(), name));
	            for (Player players : Bukkit.getOnlinePlayers()) {
	                players.hidePlayer(player);
	                players.showPlayer(player);
	            }
	        } catch (NoSuchMethodException | SecurityException | InvocationTargetException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
	            e.printStackTrace();
	        }
	    }

}
