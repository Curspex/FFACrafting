package sx.cur.omnivion.ffacrafting.listener.player;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import sx.cur.omnivion.ffacrafting.FFACrafting;
import sx.cur.omnivion.ffacrafting.listener.FFACraftingListener;
import sx.cur.omnivion.ffacrafting.utils.FFACraftingMeta;

public class ListenerItemCraft extends FFACraftingListener implements FFACraftingMeta {


	public ListenerItemCraft(FFACrafting i)
	{
		super(i, PrepareItemCraftEvent.class);
	}

	@Override
	public void dispatch(Event mevent)
	{
		final PrepareItemCraftEvent event = (PrepareItemCraftEvent) mevent;

		final List<HumanEntity> viewers = event.getViewers();

		if (viewers == null || viewers.isEmpty()) return;

		final Player player = (Player) viewers.get(0);

		if (!player.hasMetadata(FFAWORKBENCH_OPEN_KEY)) return;

		if (i.config.getAllowedItems().contains(event.getRecipe().getResult().getType())) return;

		event.getInventory().setResult(new ItemStack(Material.AIR));
		
	}


}