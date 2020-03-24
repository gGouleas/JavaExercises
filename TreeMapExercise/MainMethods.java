package treemapexercise;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author JohnG;
 */
public class MainMethods {

    public static SortedMap<Integer, String> valuesLessThan(TreeMap<Integer, String> map, int key) {

        SortedMap<Integer, String> submap;
        submap = map.subMap(map.firstEntry().getKey(), key); //exclude the key
        return submap;
    }

    public static SortedMap<Integer, String> portionBetweenValues(TreeMap<Integer, String> map, int startKey, int endKey){
        SortedMap<Integer, String> submap=null;
        submap = map.subMap(startKey, true, endKey, false);
        return submap;
    }
    
    public static TreeMap<Integer,String> copyToAnotherMap(TreeMap<Integer, String> map){
        TreeMap copy = new TreeMap();
        copy = map;
        return copy;
    }
}
