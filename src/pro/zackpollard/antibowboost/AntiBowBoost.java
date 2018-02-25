package pro.zackpollard.antibowboost;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Zack Pollard
 */
public class AntiBowBoost extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        this.getServer().getPluginManager().registerEvents(this, this);
    }

    public void onDisable() {
    }

    @EventHandler
    public void onPlayerShoot(EntityDamageByEntityEvent event) {

        if(event.getEntity().getType() == EntityType.PLAYER) {

            if (event.getDamager().getType() == EntityType.ARROW) {

                Arrow arrow = (Arrow) event.getDamager();

                if (arrow.getShooter().equals(event.getEntity())) {

                    event.setCancelled(true);
                }
            }
        }
    }
}
