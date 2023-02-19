package module11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        System.out.println(System.lineSeparator() + "++++++++++ TASK 1 ++++++++++");
        List<String> names = List.of("Ivan","Mykola", "Petro", "Yevhen", "Oleg", "Serhii", "Anatolii");
        System.out.println(oddIndexNamesToString(names));

        System.out.println(System.lineSeparator() + "++++++++++ TASK 2 ++++++++++");
        System.out.println(sortedWordsToUpperCase(names));

        System.out.println(System.lineSeparator() + "++++++++++ TASK 3 ++++++++++");
        String[] numbers = {"1, 2, 0", "4, 5", "10, 11, 23"};
        System.out.println(stringArrayToSortedNumbers(numbers));

        System.out.println(System.lineSeparator() + "++++++++++ TASK 4 ++++++++++");
        System.out.println(endlessStreamOfRandomNumbers(25214903917L, 11L, (long) Math.pow(2, 48))
                .limit(10)
                .toList());

        System.out.println(System.lineSeparator() + "++++++++++ TASK 5 ++++++++++");
        Stream<Integer> first = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> second = Stream.of(7, 8, 9, 10);
        System.out.println(zip(first, second)
                .toList());
    }

    public static String oddIndexNamesToString(List<String> list) {
        return list.stream()
                .filter(name -> list.indexOf(name) % 2 != 0)
                .map(name -> list.indexOf(name) + "." + name)
                .collect(Collectors.joining(", "));
    }

    public static List<String> sortedWordsToUpperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static String stringArrayToSortedNumbers(String[] numbers) {
        return Stream.of(numbers)
                .flatMap(subNumbers -> Stream.of(subNumbers.split(", ")))
                .sorted(Comparator.comparingInt(Integer::parseInt))
                .collect(Collectors.joining(", "));
    }

    public static Stream<Long> endlessStreamOfRandomNumbers(long a, long c, long m) {
        return Stream.iterate(12321L, seed -> (a * seed + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> mixedElements = new ArrayList<>();
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            mixedElements.add(firstIterator.next());
            mixedElements.add(secondIterator.next());
        }
        return mixedElements.stream();

//        Iterator<T> secondIterator = second.iterator();
//        return first
//                .flatMap(element -> secondIterator.hasNext()
//                        ? Stream.of(element, secondIterator.next())
//                        : Stream.empty());
    }
}
