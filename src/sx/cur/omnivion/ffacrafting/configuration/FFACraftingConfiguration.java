package sx.cur.omnivion.ffacrafting.configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import sx.cur.omnivion.ffacrafting.FFACrafting;

public class FFACraftingConfiguration {

	private final FFACrafting i;
	private FileConfiguration config;
	public FFACraftingConfiguration(FFACrafting i)
	{
		this.i = i;
		this.config = i.getConfig();
		this.cns();
	}
	
	private void cns()
	{
		config.options().copyDefaults(true);
		i.saveConfig();

		this.setAllowedItems(config.getStringList("allowedItems"), true);
	}
	
	public void reload()
	{
		i.reloadConfig();
		config = i.getConfig();
		this.cns();
	}

	private Set<Material> allowedItems = new HashSet<Material>();
	public Set<Material> getAllowedItems() { return this.allowedItems; }
	public void setAllowedItems(final List<String> newFormat, final boolean clear) { this.setAllowedItems(new HashSet<>(newFormat), clear); }
	@SuppressWarnings("deprecation")
	public void setAllowedItems(final Set<String> newFormat, final boolean clear)
	{
		if (clear) allowedItems.clear();

		final Logger logger = i.getLogger();

		for (final String string : newFormat)
		{
			Material material = Material.getMaterial(string);
			if (material == null)
			{
				try
				{
					final int materialid = Integer.parseInt(string);
					material = Material.getMaterial(materialid);
				}
				catch (NumberFormatException exception) {}
				if (material == null)
				{
					logger.log(Level.WARNING, "INVALID ITEM TYPE: " + string);
					continue;	
				}
			}
			
			allowedItems.add(material);
		}
	}
	
}