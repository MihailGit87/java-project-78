package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        addCondition("isRequired", map -> (map instanceof Map<?, ?>));
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
