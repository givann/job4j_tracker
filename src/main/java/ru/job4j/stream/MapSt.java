package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MapSt {
    static Map<String, Student> listToMap(List<Student> list) {
        Map<String, Student> mSt = list.stream()
                .distinct()
                .collect(Collectors.toMap(name -> name.getSurname(), student -> student,
                        (name, student) -> name));
        return mSt;
    }
}
