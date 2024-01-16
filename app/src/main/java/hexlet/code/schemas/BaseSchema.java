package hexlet.code.schemas;

import java.util.function.Predicate;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseSchema {
    private Boolean isRequired = Boolean.FALSE;
    protected final Map<String, Predicate<Object>> conditions;

    protected final void setIsRequired() {
        this.isRequired = Boolean.TRUE;
    }

    protected BaseSchema() {
        this.conditions = new HashMap<>();
    }

    public final boolean isValid(Object object) {
        if (!isRequired && !conditions.get("isRequired").test(object)) {
            return true;
        }
        for (Map.Entry<String, Predicate<Object>> condition : conditions.entrySet()) {
            if (!condition.getValue().test(object)) {
                return false;
            }
        }
        return true;
    }

    protected final void addCondition(String name, Predicate<Object> condition) {
        conditions.put(name, condition);
    }
}
