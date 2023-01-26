package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String str : x) {
                if (str.isBlank()) {
                    throw new IllegalArgumentException("this string is empty");
                } else if (str.substring(0, 1).equals(str.substring(0, 1).toLowerCase())) {
                    return false;
                }
            }

            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> evenValues = new ArrayList<>();
            for (Integer num : x) {
                if (num % 2 == 0) {
                    evenValues.add(num);
                }
            }

            x.addAll(evenValues);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            values.removeIf(o -> !o.substring(0, 1).equals(o.substring(0, 1).toUpperCase()) ||
                    !o.endsWith(".") ||
                    !(o.split(" ").length > 3));
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> resultMap = new ConcurrentHashMap<>();
            for (String str : x) {
                resultMap.putIfAbsent(str, str.length());
            }

            return resultMap;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (o1, o2) -> {
            List<Integer> resultList = new ArrayList<>();
            resultList.addAll(o1);
            resultList.addAll(o2);

            return resultList;
        };
    }
}
