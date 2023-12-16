package hexlet.code.schemas;

import java.util.function.Predicate;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseSchema {
    private Boolean isRequired = Boolean.FALSE;
    private final Map<String, Predicate<Object>> conditions;

    protected final void setIsRequired() {
        this.isRequired = Boolean.TRUE;
    }

    protected BaseSchema() {
        this.conditions = new HashMap<>();
    }

    public final boolean isValid(Object object) {

        if (object == null) {
            return ! isRequired;
        }
        return conditions.values().stream().allMatch(n -> n.test(object));
    }
//        if (!isRequired) {
//            return true;
//        }
//        for (Map.Entry<String, Predicate<Object>> condition : conditions.entrySet()) {
//            if (!condition.getValue().test(object)) {
//                isRequired = false;
//                break;
//            }
//        }

//        for (Map.Entry<String, Predicate<Object>> condition : conditions.entrySet()) {
//            if (!condition.getValue().test(object)) {
//                return false;
//            }
//        }

//        if (!conditions.values().stream()
//                .allMatch(predicate -> predicate.test(object))) {
//            return false;
//        }

//        boolean requiredPredicate = conditions.get("isRequired").test(object);
//        if (!isRequired && requiredPredicate) {
//            return true;
//        }
//        for (Map.Entry<String, Predicate<Object>> condition : conditions.entrySet()) {
//            if (!conditions.values().stream()
//                .allMatch(predicate -> predicate.test(object))) {
//                return false;
//            }
//        }
//        return true;
//    }
//        return true;


    protected final void addCondition(String name, Predicate<Object> condition) {
        conditions.put(name, condition);
    }
}
