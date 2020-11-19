package ru.job4j.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(e -> Stream.of(e.getSubjects()))
                .mapToInt(e -> e.iterator().next().getScore())
                .average()
                .orElse(-1);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.getName(), e.getSubjects().stream()
                        .mapToDouble(Subject::getScore)
                        .average()
                        .orElse(-1)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(e -> e.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.getName(), e.getSubjects().stream()
                        .mapToDouble(Subject::getScore)
                        .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(e -> e.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}
