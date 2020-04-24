package wordfinder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author JohnG;
 */
public class MainMethods implements Iterator<String> {

    public static List<String> storeFile(String file) {
        List<String> content = new ArrayList();
        try {
            FileReader in = new FileReader(file);
            BufferedReader reader = new BufferedReader(in);
            String line = null;
            while ((line = reader.readLine()) != null) {
                content.add(line + "\n");
            }
        } catch (FileNotFoundException f) {
            System.out.println("File not found..." + f.getMessage());
        } catch (IOException e) {
            System.out.println("Something went wrong..." + e.getMessage());
        }
        return content;
    }

    public static int countWords(String word, List<String> content) {
        int count = 0;
        for (String line : content) {
            String[] split = line.split(" ");
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].replace(",", "");
                split[i] = split[i].replace(".", "");
                if (split[i].equalsIgnoreCase(word)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static TreeSet<String> moreThan500(List<String> content) {
        Map<String, Integer> map = new HashMap();
        for (String line : content) {
            String[] split = line.split(" ");
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].replace(",", "");
                split[i] = split[i].replace(".", "");
                split[i] = split[i].toLowerCase();
                if (map.containsKey(split[i]) == true) {
                    int count = map.get(split[i]) + 1;
                    map.replace(split[i], count);
                } else {
                    map.put(line.split(" ")[i], 1);
                }
            }
        }
        Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();
        TreeSet<String> sortedKeys = new TreeSet();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            if (entry.getValue() > 500) {
                sortedKeys.add(entry.getKey());
                itr.next();
            }
        }
        return sortedKeys;
    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
