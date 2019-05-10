package util;


import java.util.ArrayList;
import java.util.List;

public class ListGenerator {
    public static List<Integer> getNumberList(int n){
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=n; i++){
            list.add(i);
        }
        return list;
    }
}
