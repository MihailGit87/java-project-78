package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addCondition("isRequired", number -> (number instanceof Integer));
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
