package by.bsuir.mpp.computershop.utils;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static <T> List<T> toList(Iterable<T> source) {
        List<T> result = new ArrayList<T>();
        for (T item : source) {
            result.add(item);
        }
        return result;
    }
}
