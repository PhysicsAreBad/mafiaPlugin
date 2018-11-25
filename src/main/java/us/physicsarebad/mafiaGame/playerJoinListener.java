package us.physicsarebad.mafiaGame;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.Plugin;

public class playerJoinListener implements Listener {
	
	private int hashMapKey = 0;
	HashMap<Integer, String> playerMap = new HashMap<Integer, String>();
	public playerJoinListener () {
		
	}
 	public playerJoinListener (Plugin plugin) {
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		hashMapKey++;
		playerMap.put(hashMapKey, event.getPlayer().toString());
		
		if (playerMap.get(8) != null) {
			//TODO Start game count down and low player interrupt
		}
	}
}
