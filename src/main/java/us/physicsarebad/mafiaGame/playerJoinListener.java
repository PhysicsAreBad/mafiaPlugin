package us.physicsarebad.mafiaGame;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class playerJoinListener implements Listener {
	
	private int hashMapKey = 0;
	private HashMap<String, Integer> playerMap = new HashMap<String, Integer>();
	private String lastJoin = null;
	
	private GameController game = new GameController();
	private RoleAssignment role = new RoleAssignment();
	
	public playerJoinListener () {
		
	}
 	public playerJoinListener (Plugin plugin) {
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		playerMap.put(event.getPlayer().toString(), hashMapKey);
		hashMapKey++;
		
		lastJoin = event.getPlayer().toString();
		
		for (Player player : Bukkit.getOnlinePlayers()) {
		    int onlineInt = Bukkit.getOnlinePlayers().size();
		    String onlineString = Integer.toString(onlineInt);
		    player.sendMessage(Color.LIME + event.getPlayer().toString() + " joined, " + onlineString + "/12 online.");
		}
		
		if (playerMap.get(lastJoin) >= 8) {
			game.startGame();
		}
	}
	
	@EventHandler
	public void onLeave (PlayerQuitEvent event) {
		playerMap.clear();
		hashMapKey = 0;
		if (game.isGameAlive()) {
			//Remove player from roles
			role.playerLeft(event.getPlayer().toString());
		}
		for (Player player : Bukkit.getOnlinePlayers()) {
		    playerMap.put(player.toString(), hashMapKey);
		    hashMapKey++;
		    int onlineInt = Bukkit.getOnlinePlayers().size();
		    String onlineString = Integer.toString(onlineInt);
		    player.sendMessage(Color.LIME + event.getPlayer().toString() + " left, " + onlineString + "/12 online.");
		    if (hashMapKey == onlineInt - 1) {
		    	lastJoin = player.toString();
		    }
		}
	}
	
	/**
	 * Give out the Last player in the hashmap without giving editing permissions
	 * @return
	 */
	public String lastJoin () {
		return lastJoin;
	}
	
	/**
	 * Give out HashMap without giving editing permissions
	 * @return
	 */
	public HashMap<String, Integer> playerMap () {
		return playerMap;
	}
}
