package sx.cur.omnivion.ffacrafting.listener;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;

import sx.cur.omnivion.ffacrafting.FFACrafting;

public abstract class FFACraftingListener implements EventExecutor, Listener {

	protected final FFACrafting i;
	protected final Class<? extends Event> clazz;
	public FFACraftingListener(FFACrafting i, Class<? extends Event> clazz)
	{
		this.i = i;
		this.clazz = clazz;
	}
	
	public final Class<? extends Event> getClazz()
	{
		return this.clazz;
	}
	
	@Override
	public final void execute(Listener listener, Event mevent)
	{
		if (mevent.getClass() == this.getClazz()) this.dispatch(mevent);
	}
	
	public abstract void dispatch(Event mevent);

}