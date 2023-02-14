package module10.task3;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrequencyOfWords {
    private static final String FILE_PATH = "src/main/java/module10/task3/words.txt";
    private String allWords;
    private Map<String, Integer> frequencyOfWords = new HashMap<>();

    public void printWordAndFrequencyTable() {
        readFileToString();
        addWordAndFrequencyToHashMap();
        sortByValuesToConsole();
    }

    public void readFileToString() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    allWords = scanner.useDelimiter("\\Z").next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("File not exists or incorrect path");
        }
    }
    public void addWordAndFrequencyToHashMap() {
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(allWords);
        while (matcher.find()) {
            String word = matcher.group();
            if (frequencyOfWords.containsKey(word)) {
                frequencyOfWords.put(word, frequencyOfWords.get(word) + 1);
            } else {
                frequencyOfWords.put(word, 1);
            }
        }
    }

    public void sortByValuesToConsole() {
        Comparator<String> valueComparator = new Comparator<>() {
            public int compare(String k1, String k2) {
                return frequencyOfWords.get(k1).compareTo(frequencyOfWords.get(k2)) > 0 ? -1 : 1;
            }
        };
        Map<String, Integer> sortedFrequencyOfWords = new TreeMap<>(valueComparator);
        sortedFrequencyOfWords.putAll(frequencyOfWords);

        for (Map.Entry<String, Integer> entry : sortedFrequencyOfWords.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

//        int maxInterimValue = 0;
//        String maxInterimKey = null;
//        while (frequencyOfWords.size() != 0) {
//            for (Map.Entry<String, Integer> entry : frequencyOfWords.entrySet()) {
//                if (entry.getValue() > maxInterimValue){
//                    maxInterimValue = entry.getValue();
//                    maxInterimKey = entry.getKey();
//                }
//            }
//            frequencyOfWords.remove(maxInterimKey);
//            System.out.println(maxInterimKey + " " + maxInterimValue);
//            maxInterimValue = 0;
//        }
    }
}
