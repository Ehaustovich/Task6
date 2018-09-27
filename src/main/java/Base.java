import java.util.*;
import java.io.*;

public class Base {
    public static void main(String[] args) throws FileNotFoundException {
        //сортируем в алфавитном порядке
        System.out.println("Сортировка слов в алфавитном порядке:");
        Scanner scanner = new Scanner(new FileReader("File.txt"));
        ArrayList<String> words = new ArrayList<String>();
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }
        Collections.sort(words, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        for (String word : words) System.out.print(word + " ");

        //считаем, сколько раз встречается каждое слово
        System.out.println("\nСколько раз встречается каждое слово в файле:");
        Scanner sc = new Scanner(new FileReader("File.txt"));
        Map<String, Integer> stat = new HashMap<String, Integer>();
        while (sc.hasNext()) {
            String word = sc.next();
            Integer count = stat.get(word);
            if (count == null) {
                count = 0;
            }
            stat.put(word, ++count);
        }
        //выводим статистику
        for (String word : stat.keySet()) {
            System.out.println(word + ": " + stat.get(word));
        }
        //выводим слово, встречающееся максимальное количество раз, и количество раз
        System.out.println("Самое повторяющееся слово:");
        int p = 0;
        for (String w : stat.keySet()) {
            if (p < stat.get(w)) {
                p = stat.get(w);
            }
        }
        for (String w : stat.keySet()) {
            if (p == stat.get(w)) {
                System.out.println(w + " (встречается " + stat.get(w) + " раз)");
            }
        }


        scanner.close();


    }
}