package us.physicsarebad.mafiaGame;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class mafiaGame extends JavaPlugin{
	//playerJoinListener playerJoin = null;
	
	@Override
    public void onEnable() {
		//TODO Add Listeners for player numbers so can gauge when to game init
		getLogger().info(" Mafia Plugin Developed by PhysicsAreBad.\nSource Code avaliable at https://github.com/TheKiller65YT/mafiaPlugin/\nYou can get support by emailing pluginsupport@physicsarebad.us");
		getLogger().info("This plugin is not reload friendly currently, so please restart the server if you changed anything.");
		
		/*playerJoin =*/ new playerJoinListener(this);
    }
    
    @Override
    public void onDisable() {
        getLogger().info("Thank you for using the Mafia Game developed by PhysicsareBad.\nVist us at anytime at physicsarebad.us!");
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("mafia")) { // If the player typed /basic then do the following, note: If you only registered this executor for one command, you don't need this
    		if (args[0] == "help") { //Send plugin help message
    			sender.sendMessage(Color.BLUE + "\t Mafia Help \n" + Color.YELLOW + "/mafia help - This command \n/mafia roles - List roles for the Mafia Game \n/mafia info - Basic info about this plugin \n /whisper - whisper to player while in-game");
    			if (sender.hasPermission("mafia.admin")) { //Show admin commands
    				sender.sendMessage(Color.YELLOW + "/mafia start - Overrides and starts the game \n/mafia stop - overrides end and stops the game");
    			}
    		}
    		return true;
    	} else if (cmd.getName().equalsIgnoreCase("w") || cmd.getName().equalsIgnoreCase("whisper")) { //Whisper Function
			Player messagePlayer = Bukkit.getPlayer(args[0]);
			String message = null;
			//Construct Whispered MSG
			for (int i = 0; i <= args.length; i ++) {
				if (i == 0) {
					
				} else {
					message = message + " " + args[i];
				}
			}
			//Send Constructed Message
			messagePlayer.sendMessage(message);
			
			return true;
		} 
    	return false; 
    }
    //TODO Define all roles
}