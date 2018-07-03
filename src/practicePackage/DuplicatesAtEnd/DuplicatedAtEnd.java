package practicePackage.DuplicatesAtEnd;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class DuplicatedAtEnd {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("alfa");
        list.add("delta");
        list.add("charlie");
        list.add("alfa");
        list.add("alfa");
        list.add("charlie");
        list.add("bravo");
        list.add("echo");

        List<String> result = sort(list);
    }

    private static <T extends Comparable<T>> List<T> sort(List<T> list) {
        list.sort((T a, T b) -> a.compareTo(b));
        for (T t : list)
            System.out.println(t);
        //Pair<Integer, List<T>> pairs = new Pair<>();
        return  list;
    }
}
