package hexlet.code.schema;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        super();
        addCondition("instanceof",
                value -> {
                    if (value != null) {
                        return value instanceof Map;
                    }
                    return true;
                }
        );
    }

    public MapSchema required() {
        addCondition("required",
                Objects::nonNull
        );
        return this;
    }

    public MapSchema sizeof(int size) {
        addCondition("sizeof",
                value -> ((Map<?, ?>) value).size() == size
        );
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCondition("shape",
                value -> schemas.entrySet().stream().allMatch(item -> {
                    Object object = ((Map<?, ?>) value).get(item.getKey());
                    return item.getValue().isValid(object);
                })
        );
        return this;
    }
}
