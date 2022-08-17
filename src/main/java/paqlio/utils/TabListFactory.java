package paqlio.utils;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;

/**
 * @author Paqlio
 * @since 17.08.2022 - 11:35
 **/
public class TabListFactory {
    public void createTabList(Audience server, Component header, Component footer) {
        server.sendPlayerListHeaderAndFooter(header,footer);
    }
}
