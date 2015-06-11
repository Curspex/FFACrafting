package sx.cur.omnivion.ffacrafting.listener.player;

import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;

import sx.cur.omnivion.ffacrafting.FFACrafting;
import sx.cur.omnivion.ffacrafting.listener.FFACraftingListener;
import sx.cur.omnivion.ffacrafting.utils.InventoryUtil;

public class ListenerInteract extends FFACraftingListener {

	public ListenerInteract(FFACrafting i)
	{
		super(i, PlayerInteractEvent.class);
	}

	@Override
	public void dispatch(Event mevent)
	{
		final PlayerInteractEvent event = (PlayerInteractEvent) mevent;
		
		if (event.getMaterial() == null || !event.getMaterial().equals(Material.WORKBENCH)) return;
		
		switch (event.getAction())
		{
			case RIGHT_CLICK_AIR:
			case RIGHT_CLICK_BLOCK:
				break;

			default:
				return;
		}

		InventoryUtil.openCrafting(event.getPlayer(), true);
	}

}