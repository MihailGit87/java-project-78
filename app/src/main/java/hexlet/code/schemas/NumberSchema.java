package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        addCondition("instanceof", Objects::nonNull);
    }

    public NumberSchema required() {
        addCondition("isNumber", number -> (number instanceof Integer));
        super.setIsRequired();
        return this;
    }

    public NumberSchema positive() {
        addCondition("positive",
                value -> (Integer) value > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCondition("range",
                value -> {
                    if (value instanceof Integer) {
                        return (Integer) value >= min && (Integer) value <= max;
                    }
                    return true;
                }
        );
        return this;
    }
}
