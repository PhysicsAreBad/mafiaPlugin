package us.physicsarebad.mafiaGame;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class playerJoinListener implements Listener {
	
	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
	    //TODO Add hash to store players
	}
}
