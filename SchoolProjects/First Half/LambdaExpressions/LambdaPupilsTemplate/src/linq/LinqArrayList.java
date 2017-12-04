package linq;

import java.util.ArrayList;

public class LinqArrayList<T> extends ArrayList<T> implements LinqIterable<T>{

    @Override
    public boolean add(T e) {
        return super.add(e);
    }
    
}
