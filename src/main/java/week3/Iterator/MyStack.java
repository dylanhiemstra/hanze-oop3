package week3.Iterator;

import java.util.Iterator;
import java.util.ArrayList;

public class MyStack implements Iterable<String> {

    private ArrayList<String> list = new ArrayList<>();

    public void push(String item) {
        list.add(item);
    }

    public String pop() {
        return list.remove(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = list.size() - 1;

            @Override
            public boolean hasNext() {
                return index != -1;
            }

            @Override
            public String next() {
                return list.get(index--);
            }
        };
    }
}
