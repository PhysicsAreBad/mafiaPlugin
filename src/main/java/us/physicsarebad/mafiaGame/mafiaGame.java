package us.physicsarebad.mafiaGame;

import org.bukkit.plugin.java.JavaPlugin;

public class mafiaGame extends JavaPlugin{
	@Override
    public void onEnable() {
        // TODO Insert logic to be performed when the plugin is enabled
		getLogger().info("Mafia Plugin Developed by PhysicsAreBad.");
		getLogger().info("Source Code avaliable ");
    }
    
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }
}
