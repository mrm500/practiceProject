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
        list.add("echo");
        list.add("alfa");
        list.add("foxtrot");
        list.add("alfa");
        list.add("charlie");
        list.add("bravo");
        list.add("echo");
        List<String> result = sort(list);
        for (String s : result)
            System.out.println(s);
    }

    private static <T extends Comparable<T>> List<T> sort(List<T> list) {
        list.sort((T a, T b) -> a.compareTo(b));
        int indexOfLastUnique = 0;
        boolean flag = false;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) < 0) {
                if (indexOfLastUnique > 0 && list.get(indexOfLastUnique - 1).compareTo(list.get(i + 1)) >= 0){
                    indexOfLastUnique--;
                    list.add(i+1, list.get(indexOfLastUnique));
                    list.remove(indexOfLastUnique);
                }
                else {
                    list.add(indexOfLastUnique, list.get(i + 1));
                    list.remove(i + 2);
                    indexOfLastUnique++;
                }
            }
        }
        return  list;
    }
}
