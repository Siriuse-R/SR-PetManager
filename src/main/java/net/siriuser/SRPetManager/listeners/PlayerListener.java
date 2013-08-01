package net.siriuser.SRPetManager.listeners;

import java.util.logging.Logger;

import net.siriuser.SRPetManager.SRPetManager;

import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerListener implements Listener {

    private final static Logger log = SRPetManager.log;
    private final static String logPrefix = SRPetManager.logPrefix;

    private final SRPetManager plugin;

    public PlayerListener (final SRPetManager plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void PreviewPetStats (final PlayerInteractEntityEvent event) {
        final Player player = event.getPlayer();
        final Entity ent = event.getRightClicked();

        if (ent instanceof Horse) {
            Horse horse = (Horse) ent;
            final double health = (int) horse.getHealth();
            final double maxhealth = (int) horse.getMaxHealth();
            final AnimalTamer owner = horse.getOwner();
            final double jPower = horse.getJumpStrength();

            if (horse.isTamed()) {
                player.sendMessage("[情報] HP: " + health + "/" + maxhealth + " 飼い主: " + owner.getName() + " ジャンプ力 " + jPower);
            } else {
                player.sendMessage("[情報] HP: " + health + "/" + maxhealth + " 飼い主: なし" + " ジャンプ力 " + jPower);
            }
        }

        if (ent instanceof Wolf) {
            Wolf wolf = (Wolf) ent;
            final double health = (int) wolf.getHealth();
            final double maxhealth = (int) wolf.getMaxHealth();
            final AnimalTamer owner = wolf.getOwner();

            if (wolf.isTamed()) {
                player.sendMessage("[情報] HP: " + health + "/" + maxhealth + " 飼い主: " + owner.getName());
            } else {
                player.sendMessage("[情報] HP: " + health + "/" + maxhealth + " 飼い主: なし");
            }
        }

        if (ent instanceof Ocelot) {
            Ocelot ocelot = (Ocelot) ent;
            final double health = (int) ocelot.getHealth();
            final double maxhealth = (int) ocelot.getMaxHealth();
            final AnimalTamer owner = ocelot.getOwner();

            if (ocelot.isTamed()) {
                player.sendMessage("[情報] HP: " + health + "/" + maxhealth + " 飼い主: " + owner.getName());
            } else {
                player.sendMessage("[情報] HP: " + health + "/" + maxhealth + " 飼い主: なし");
            }
        }
    }
}
