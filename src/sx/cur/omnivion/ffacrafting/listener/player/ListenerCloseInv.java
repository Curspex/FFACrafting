package sx.cur.omnivion.ffacrafting.listener.player;

import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;

import sx.cur.omnivion.ffacrafting.FFACrafting;
import sx.cur.omnivion.ffacrafting.listener.FFACraftingListener;
import sx.cur.omnivion.ffacrafting.utils.FFACraftingMeta;

public class ListenerCloseInv extends FFACraftingListener implements FFACraftingMeta {


	public ListenerCloseInv(FFACrafting i)
	{
		super(i, InventoryCloseEvent.class);
	}

	@Override
	public void dispatch(Event mevent)
	{
		final InventoryCloseEvent event = (InventoryCloseEvent) mevent;

		if (!event.getView().getType().equals(InventoryType.WORKBENCH)) return;

		if (!event.getPlayer().hasMetadata(FFAWORKBENCH_OPEN_KEY)) return;

		event.getPlayer().removeMetadata(FFAWORKBENCH_OPEN_KEY, super.i);
	}


}