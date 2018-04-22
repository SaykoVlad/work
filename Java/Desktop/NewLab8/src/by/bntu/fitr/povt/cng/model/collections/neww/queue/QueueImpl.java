package by.bntu.fitr.povt.cng.model.collections.neww.queue;

import by.bntu.fitr.povt.cng.model.collections.neww.AbstractCollection;

import java.util.Collection;
import java.util.Iterator;

public class QueueImpl<T> extends AbstractCollection<T> implements QueueInterface<T> {

    private Object []queue = new Object[4];
    private int sizeVar;
    private int queueArraySize = 4;


    public QueueImpl(){

    }

    public QueueImpl(T...ts){
        for (T t : ts) {
            enqueue(t);
        }
    }

    @Override
    public void enqueue(T t) {
        if (sizeVar == queueArraySize - 1){
            resize(queueArraySize * 2);
        }
        queue[sizeVar++] = t;
    }

    @Override
    public T dequeue() {
        T t = (T) queue[0];
        Object []objects = new Object[queue.length - 1];
        System.arraycopy(queue, 1, objects, 0, queue.length - 1);
        queue = objects;
        sizeVar--;
        return t;
    }

    @Override
    public T peek() {
        return (T) queue[0];
    }

    @Override
    public int size() {
        return sizeVar;
    }

    @Override
    protected void add(T t) {
        enqueue(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < sizeVar;
            }

            @Override
            public T next() {
                return (T) queue[index++];
            }
        };
    }

    @Override
    public void clear() {
        queue = new Object[4];
        sizeVar = 0;
    }

    @Override
    public int hashCode() {
        final int HASHCONST = 31;
        int result = 1;
        Iterator iterator = this.iterator();
        while(iterator.hasNext()){
            result +=  result * HASHCONST + iterator.next().hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode() && obj.getClass() == this.getClass();
    }

    //PRIVATE METHODS

    private void resize(int newLength) {
        queueArraySize = newLength;
        Object[] newArray = new Object[newLength];
        System.arraycopy(queue, 0, newArray, 0, sizeVar);
        queue = newArray;
    }
}
