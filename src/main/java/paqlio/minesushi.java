package paqlio;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;
import paqlio.utils.LegacyColorProcessor;
import paqlio.utils.TabListFactory;

import java.lang.reflect.InvocationTargetException;

public final class minesushi extends JavaPlugin {
    private static minesushi instance;

    public static minesushi getInstance() {
        return instance;
    }
    /**
     * Adventure
     **/
    private BukkitAudiences adventureAudiences;
    private MiniMessage miniMessage;

    private final TabListFactory tabListFactory = new TabListFactory();




    @Override
    public void onEnable() {
        instance = this;
        this.adventureAudiences = BukkitAudiences.create(this);
        this.miniMessage = MiniMessage.builder()
                .postProcessor(new LegacyColorProcessor())
                .build();
        var packetName = getClass().getPackage().getName();
        for (Class<?> clazz : new Reflections(packetName + ".Events")
                .getSubTypesOf(Listener.class)) {
            try {
                Listener Listener = (Listener) clazz
                        .getConstructor()
                        .newInstance();
                getServer().getPluginManager().registerEvents(Listener, this);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e ) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public TabListFactory getTabListFactory() {
        return tabListFactory;
    }

    public BukkitAudiences getAdventureAudiences() {
        return adventureAudiences;
    }

    public MiniMessage getMiniMessage() {
        return miniMessage;
    }
}
