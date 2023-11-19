package hexlet.code.schema;

import java.util.Objects;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super();
        addCondition("instanceof",
                value -> {
                    if (value != null) {
                        return value instanceof Integer;
                    }
                    return true;
                }
        );
    }

    public NumberSchema required() {
        addCondition("required",
                Objects::nonNull
        );
        return this;
    }

    public NumberSchema positive() {
        addCondition("positive",
                value -> {
                    if (value instanceof Integer) {
                        return (Integer) value > 0;
                    }
                    return true;
                }
        );
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
