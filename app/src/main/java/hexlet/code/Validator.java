package hexlet.code;

import hexlet.code.schema.NumberSchema;
import hexlet.code.schema.StringSchema;

public class Validator {

    public Validator() {
    }

    public final StringSchema string() {
        return new StringSchema();
    }

    public final NumberSchema number() {
        return new NumberSchema();
    }
}
