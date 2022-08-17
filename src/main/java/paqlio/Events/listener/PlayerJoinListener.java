package paqlio.Events.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import paqlio.minesushi;

/**
 * @author Paqlio
 * @since 17.08.2022 - 12:19
 **/
public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        var player = event.getPlayer();

        minesushi.getInstance().getTabListFactory().createTabList(
                minesushi.getInstance().getAdventureAudiences().player(player),
                minesushi.getInstance().getMiniMessage().deserialize("&5Minesushi"),
                minesushi.getInstance().getMiniMessage().deserialize("jebanie\nkrisa\nnw")
        );
    }

}
