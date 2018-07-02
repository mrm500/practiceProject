package practicePackage.mapSort;

import java.util.*;

public class MapSort {
    public static void main(String[] args){
        HashMap<String, String > map = new HashMap<>();
        map.put("royal", "enfeild");
        map.put("alpha", "romero");
        map.put("aston", "martin");
        map.put("rolls", "royce");
        LinkedHashMap<String,String> sortedMap = new LinkedHashMap<>(sort(map));
        System.out.println(sortedMap.toString());
    }

    static <K,V extends Comparable<V>> Map<K,V> sort(Map<K,V> map){
        ArrayList<Map.Entry<K,V>> sortedList = new ArrayList<>(map.entrySet());
        sortedList.sort((Map.Entry<K,V> a,Map.Entry<K,V> b) -> a.getValue().compareTo(b.getValue()));
        LinkedHashMap<K,V> result = new LinkedHashMap<>();
        for (Map.Entry<K,V> e : sortedList)
            result.put(e.getKey(),e.getValue());
        return result;
    }
}
