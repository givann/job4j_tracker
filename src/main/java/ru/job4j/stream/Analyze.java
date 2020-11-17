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

    public static void main(String[] args) {
        List<Pupil> lT = List.of(
                new Pupil("Ivanov", List.of(new Subject("Math", 100), new Subject("Lang", 100))),
                new Pupil("Petrov", List.of(new Subject("Math", 60), new Subject("Lang", 60)))
        );

        Stream<Pupil> sP = lT.stream();
        List<Tuple> mn = averageScoreByPupil(sP);

        Map<String, Double> fCh = sP.flatMap(v -> Stream.of(v.getSubjects()))
                .collect(Collectors.groupingBy(e -> e.iterator().next().getName(),
                        Collectors.averagingDouble(value -> value.iterator().next().getScore())));

    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.getName(), Stream.of(e.getSubjects())
                        .mapToDouble(value -> value.iterator().next().getScore())
                        .average()
                        .orElse(-1)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        Map<String, Double> mapInter = stream
                .flatMap(v -> Stream.of(v.getSubjects()))
                .collect(Collectors.groupingBy(e -> e.iterator().next().getName(),
                        Collectors.averagingDouble(e -> e.iterator().next().getScore())));
        return mapInter.entrySet().stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return null;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}
