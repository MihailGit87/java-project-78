package hexlet.code.schemas;

import java.util.function.Predicate;
import java.util.Objects;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        addCondition("instanceOf", Objects::nonNull);
    }

    public StringSchema required() {
        super.setIsRequired();
        addCondition("isNotEmpty", string -> !string.equals(""));
        return this;
    }

    public StringSchema minLength(int length) {
        Predicate<Object> minLength = x -> (x == null || x.toString().length() >= length);
        super.addCondition("minlength", minLength);
        return this;
    }

    public StringSchema contains(String data) {
        Predicate<Object> isContains = x -> (x == null || x.toString().contains(data));
        super.addCondition("contains", isContains);
        return this;
    }
}
