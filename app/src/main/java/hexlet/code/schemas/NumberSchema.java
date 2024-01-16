package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super.conditions.put("isRequired", number -> (number instanceof Integer));
    }

    public NumberSchema required() {
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
                value -> (Integer) value >= min && (Integer) value <= max);
        return this;
    }
}
