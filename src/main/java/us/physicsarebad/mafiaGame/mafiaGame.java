package us.physicsarebad.mafiaGame;

import org.bukkit.plugin.java.JavaPlugin;

public class mafiaGame extends JavaPlugin{
	@Override
    public void onEnable() {
		//TODO Add Listeners for player numbers so can gauge when to game init
		getLogger().info(" Mafia Plugin Developed by PhysicsAreBad.\nSource Code avaliable at https://github.com/TheKiller65YT/mafiaPlugin/\nYou can get support by emailing pluginsupport@physicsarebad.us");
		getLogger().info("This plugin is not reload friendly currently, so please restart the server if you changed anything.");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("Thank you for using the Mafia Game developed by PhysicsareBad.\nVist us at anytime at physicsarebad.us!");
    }
    
    //TODO Define all roles
}
