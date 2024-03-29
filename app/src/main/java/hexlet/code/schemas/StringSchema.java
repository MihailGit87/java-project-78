package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        super.conditions.put("isRequired", string -> (string instanceof String) && !string.equals(""));
    }

    public StringSchema required() {
        super.setIsRequired();
        return this;
    }

    public StringSchema minLength(int length) {
        Predicate<Object> minLength = x -> (x.toString().length() >= length);
        super.addCondition("minlength", minLength);
        return this;
    }

    public StringSchema contains(String data) {
        Predicate<Object> isContains = x -> (x.toString().contains(data));
        super.addCondition("contains", isContains);
        return this;
    }
}
