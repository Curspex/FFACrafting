package sx.cur.omnivion.ffacrafting;

import org.bukkit.Bukkit;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;

import sx.cur.omnivion.ffacrafting.configuration.FFACraftingConfiguration;
import sx.cur.omnivion.ffacrafting.listener.player.ListenerCloseInv;
import sx.cur.omnivion.ffacrafting.listener.player.ListenerInteract;
import sx.cur.omnivion.ffacrafting.listener.player.ListenerItemCraft;

public class FFACrafting extends JavaPlugin {


	public static transient FFACrafting i;
	public transient FFACraftingConfiguration config;


	@Override
	public void onEnable()
	{
		i = this;
		config = new FFACraftingConfiguration(i);
		
		final EventRegistrar registrar = new EventRegistrar(i, Bukkit.getPluginManager(), true, EventPriority.HIGH);
		
		registrar.registerEvent(new ListenerInteract(i));
		registrar.registerEvent(new ListenerCloseInv(i));
		registrar.registerEvent(new ListenerItemCraft(i));
	}
	
	@Override
	public void onDisable()
	{
		i = null;
	}


}