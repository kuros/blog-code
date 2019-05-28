package in.kuros.blog.code.java.streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class CustomCollector {

    public static <T> Collector<T, Set<T>, List<T>> unique() {
        return Collector.of(
                HashSet::new,
                Set::add,
                (result1, result2) -> {
                    result1.addAll(result2);
                    return result1;
                },
                ArrayList::new,
                Collector.Characteristics.CONCURRENT,
                Collector.Characteristics.UNORDERED);
    }


    public static void main(String[] args) {
        final List<Integer> result = IntStream.of(1, 2, 3, 4, 3, 4, 5)
                .boxed()
                .collect(CustomCollector.unique());

        System.out.println(result);
    }
}
