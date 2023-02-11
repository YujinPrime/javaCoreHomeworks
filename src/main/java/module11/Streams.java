package module11;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> names = List.of("Ivan","Mykola", "Petro", "Yevhen", "Oleg", "Serhii", "Anatolii");
        System.out.println(oddIndexNamesToString(names));

        System.out.println(sortedWordsToUpperCase(names));

        String[] numbers = {"1, 2, 0", "4, 5", "10, 11, 23"};
        System.out.println(stringArrayToSortedNumbers(numbers));

        List<Long> list = endlessStreamOfRandomNumbers(25214903917L, 11L, (long) Math.pow(2, 48))
                .limit(20)
                .collect(Collectors.toList());
        System.out.println(list);
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
//        Comparator<String> comp = (s1, s2) -> {
//            Integer d1 = Integer.parseInt(s1);
//            Integer d2 = Integer.parseInt(s2);
//            return d1.compareTo(d2);
//        };
        return Stream.of(numbers)
                .flatMap(subNumbers -> Stream.of(subNumbers.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static Stream<Long> endlessStreamOfRandomNumbers(long a, long c, long m) {
        return Stream.iterate(12321L, xn -> (a * xn + c) % m);
    }
}
