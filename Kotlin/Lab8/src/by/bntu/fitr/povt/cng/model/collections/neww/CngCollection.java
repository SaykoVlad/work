package by.bntu.fitr.povt.cng.model.collections.neww;

import java.util.Collection;

public interface CngCollection<T> extends Iterable<T>{

    int size();
    boolean isEmpty();
    void addAll(Collection c);
    boolean contains(Object o);
    Object []toArray();
    boolean containsAll(Collection c);
    void clear();



}
