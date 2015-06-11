package sx.cur.omnivion.ffacrafting.utils;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import sx.cur.omnivion.ffacrafting.FFACrafting;

public final class InventoryUtil implements FFACraftingMeta {


	private static final MetadataValue meta = new FixedMetadataValue(FFACrafting.i, true);


	public static final void openCrafting(final Player player, final boolean addMeta)
	{
		player.openWorkbench(player.getLocation(), true);

		if (!addMeta) return;

		player.setMetadata(FFAWORKBENCH_OPEN_KEY, InventoryUtil.meta);
	}


}