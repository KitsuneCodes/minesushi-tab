package paqlio.utils;

/**
 * @author Paqlio
 * @since 17.08.2022 - 11:15
 **/
import net.kyori.adventure.text.Component;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import static paqlio.utils.LegacySerilizersUtil.component;


public class LegacyColorProcessor implements UnaryOperator<Component> {
    @Override
    public Component apply(Component component) {
        return component
                .replaceText(builder -> builder.match(Pattern.compile(".*"))
                        .replacement(((matchResult, builder1) -> component(matchResult.group()))));
    }
}
