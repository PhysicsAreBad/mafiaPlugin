package us.physicsarebad.mafiaGame;

import java.util.HashMap;
import java.util.Random;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.entity.Player;

public class RoleAssignment {
	//Hash Map key is player's name to string
	private HashMap<String, String> roleMap = new HashMap<String, String>();
	private playerJoinListener playerJoin = new playerJoinListener();
	
	private int i = 0;
	
	private String lastLeft;
	private boolean leftLastNight = false;
	
	private String[] roles = new String[] {"Godfather", "Mafiaso", "Jailor", "Sheriff", "Medium", "Escort", "Lookout", "Serial Killer", "Framer", "Executioner", "Vigilatie", "Vetern"};
	
	public RoleAssignment () {
		//Blank constructor
	}
	
	public void assignRoles () {
		//Random Num. Generator
		Random rand = new Random();
		
		//Hashmap of Players
		HashMap<String, Integer> playerMap = playerJoin.playerMap();
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.sendMessage(Color.LIME + "Randomizing Roles");
		} //Separate For Loop to expedite message send
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			int randomNum = rand.nextInt(playerMap.get(playerJoin.lastJoin()) - i);
			String role = roles[randomNum];
			
			roleMap.put(player.toString(), role);
			roles = (String[]) ArrayUtils.removeElement(roles, role);
			
			player.sendMessage(Color.LIME + "Your Role is " + role);
			player.sendMessage(Color.LIME + roleDesc(role));
			
			i++;
		}
		
	}
	/**
	 * Return roleMap without giving editing permission
	 * @return
	 */
	public HashMap<String, String> roleMap () {
		return roleMap;
	}
	/**
	 * Return description of role
	 * @param role
	 * @return
	 */
	public String roleDesc (String role) {
		
		//Role Descriptions
		if (role == "Godfather") {
			return "You head the mafia, and you are filled with death. You shall pick who your mafiaso kills every night. \nHe can vote for who is murdered, but that is only a suggestion as only you decide. Vote with /kill [name].\nYou win when only the Mafia are left and you must keep your operations hidden.";
		} else if (role == "Mafiaso") {
			return "You are the Godfather's right hand man. You murder who ever he chooses. \nYou can suggest who is murdered but the Godfather has the last say. You will become the Godfather on the death of the current Godfather. Vote with /kill [name]. \nYou win when only the Mafia are left and you must keep your operations hidden.";
		} else if (role == "Framer") {
			return "You are a deceiver, and a master of detail. You have the power to fool the local police force. \nSelect some one everynight to frame them as the Mafiaso. You will become the Mafiaso on the death of the current Mafiaso. Frame with /frame [name]\nYou win when only the Mafia are left and you must keep your operations hidden.";
		} else if (role == "Serial Killer") {
			return "You only live to see everyone dead. Death is your best friend! \nSelect someone to kill every night, but if an escort role-blocks you, they will be murdered by you.  Kill with /kill [name] at night. \nYou win when you are the only one left!";
		} else if (role == "Executioner") {
			return "You have been hired to kill a member of the town. \nPersuade the town to kill your target. Check your target in game with /target \nYou win only when your target is lynched by the town.";
		} else if (role == "Jailor") {
			return "As the head of the town jail, you will jail and kill who you think are against the town. \nSelect a person to jail with /jail [name] during the day and more instructions will follow \nYou win with the town.";
		} else if (role == "Sheriff") {
			return "You are the town sheriff and know that there are people here to break up the town. You must find them and persude the town to kill them. \nInvestigate with /investigate [name] \nRemember you are a target! You win with the town.";
		} else if (role == "Escort") {
			return "You stop people while they do their nightly tasks. Then instead will focus on you. \nEscort someone by doing /escort [name] at night\nYou win with the town.";
		} else if (role == "Lookout") {
			return "You spy on a certain person's house's entries every night \nLook at someone's house with /look [name]\nYou win with the town.";
		} else if (role == "Medium") {
			return "You know the vudoo sercrets and use it to help the town. \nTalk with the dead at night and you can see one final message after you die with /fmsg [name]. \nYou win with the town.";
		} else if (role == "Vigilantie") {
			return "You are a lone wolf, one who chooses who is dead with no deliberation. \n Use /kill [name] during the night after the first one to kill that player. Bewarned that killing a townie will cause suicide by you! \nYou win with the town.";
		} else if (role == "Vetern") {
			return "You are a recovering soldier who doesn't stray from his gun. \nYou can alert three times and when alert you will kill anyone who visits. When you kill a townie you lose all your alerts. \nYou win with the town.";
		}
		
		return "Error: Description not found for role: " + role + ". Contact your server admin.";
	}
	
	public void playerLeft (String player) {
		leftLastNight = true;
		roleMap.remove(player);
		lastLeft = player;
	}
 }
