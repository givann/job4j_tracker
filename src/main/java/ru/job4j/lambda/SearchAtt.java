package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> predicate = (s) -> s.getSize() > 100;
        return filterUniv(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> predicate = (s) -> s.getName().contains("bug");
        return filterUniv(list, predicate);
    }

    public static List<Attachment> filterUniv(List<Attachment> list,
                                              Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        return list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}

