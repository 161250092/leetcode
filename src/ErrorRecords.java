

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ErrorRecords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        String path;
        String fileName;
        int lineNum;
        String key;
        while (sc.hasNext()) {
            path = sc.next();
            int id = path.lastIndexOf('\\');
            fileName = id < 0 ? path : path.substring(id + 1);
            lineNum = sc.nextInt();
            key = fileName + " " + lineNum;
            if (map.containsKey(key))
                map.put(key, map.get(key) + 1);
            else
                map.put(key, 1);
        }
        sc.close();

        //记录错误信息
        List<Map.Entry<String, Integer>> lists = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(lists, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> arg1, Entry<String, Integer> arg2) {
                return (arg2.getValue() - arg1.getValue()) == 0 ? (arg1.getValue() - arg2.getValue()) : (arg2.getValue() - arg1.getValue());
            }
        });

        int count = 0;
        for (Map.Entry<String, Integer> list : lists) {
            if (count < 8) {
                String[] str = list.getKey().split(" ");
                String k = str[0].length() > 16 ? str[0].substring(str[0].length() - 16) : str[0];
                String n = str[1];
                System.out.println(k + " " + n + " " + list.getValue());
            } else
                break;
            count++;
        }
    }
}