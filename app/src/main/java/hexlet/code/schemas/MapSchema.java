package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        addCondition("instanceof", Objects::nonNull);
    }

    public MapSchema required() {
        super.setIsRequired();
        return this;
    }

    public MapSchema sizeof(int size) {
        super.addCondition("sizeof",
                value -> ((Map<?, ?>) value).size() == size
        );
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        super.addCondition("shape",
                value -> schemas.entrySet().stream().allMatch(item -> {
                    Object object = ((Map<?, ?>) value).get(item.getKey());
                    return item.getValue().isValid(object);
                })
        );
        return this;
    }
}
