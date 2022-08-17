package paqlio.utils;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import paqlio.minesushi;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@UtilityClass
public final class LegacySerilizersUtil {

    public static final GsonComponentSerializer GSON_SERIALIZER = GsonComponentSerializer.gson();
    public static final LegacyComponentSerializer SECTION_SERIALIZER = LegacyComponentSerializer.builder()
            .character('§')
            .hexColors()
            .useUnusualXRepeatedCharacterHexFormat()
            .build();

    private static final LegacyComponentSerializer AMPERSAND_SERIALIZER = LegacyComponentSerializer.builder()
            .character('&')
            .hexColors()
            .useUnusualXRepeatedCharacterHexFormat()
            .build();

    public static Component component(String text) {
        return AMPERSAND_SERIALIZER.deserialize(text);
    }

    public static List<Object> componentMiniMessage(List<String> texts) {
        minesushi corePlugin = minesushi.getInstance();
        return texts.stream().map(text -> corePlugin.getMiniMessage().deserialize(text)).collect(Collectors.toList());
    }

    public static List<Component> component(List<String> texts) {
        return texts.stream().map(LegacySerilizersUtil::component).collect(Collectors.toList());
    }

}
