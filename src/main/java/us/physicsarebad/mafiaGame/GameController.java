package us.physicsarebad.mafiaGame;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.entity.Player;

public class GameController {
	private playerJoinListener playerListener = new playerJoinListener();
	private RoleAssignment roles = new RoleAssignment();
	
	private boolean gameStatus = false;
	
	public GameController () {
		
	}
	/**
	 * Game start with count down
	 */
	public void startGame () {
		long start = System.currentTimeMillis(); //Start time of while loop
		long space = 0; //Variable to measure time from last while execution
		
		int spacing = 50; //How many milliseconds should each player poll be?
		
		int timesRan = 0;
		
		boolean escape = false; //Variable to hold if loop escaped
		
		while (System.currentTimeMillis() - start >= 3000 && System.currentTimeMillis() - space >= spacing) {
			if (playerListener.playerMap().get(playerListener.lastJoin()) < 8) {
				escape = true;
				break;
			}
			
			if (timesRan == 20) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					player.sendMessage(Color.LIME + "Game start in 2 seconds.");
				}
			} else if (timesRan == 40) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					player.sendMessage(Color.LIME + "Game start in 1 seconds.");
				}
			}
			
			space = System.currentTimeMillis();
			timesRan++;
		}
		if (!escape) {
			gameStatus = true;
			roles.assignRoles();
		} else {
			escape = false;
		}
		
	}
	
	public void startGameOverride () {
		gameStatus = true;
	}
	
	public void stopGame () {
		gameStatus = false;
	}
	
	public boolean isGameAlive () {
		return gameStatus;
	}
}
