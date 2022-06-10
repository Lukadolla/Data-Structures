package Queues.Stacks;
public class ArrayDeque<E> implements Deque<E> {

    public static final int CAPACITY = 1000;
    private E[] data;
    private int f = 0;
    private int size = 0;

    public ArrayDeque()
    {
        this(CAPACITY);
    }

    public ArrayDeque(int capacity)
    {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return(size == 0);
    }

    @Override
    public E first() {
        if(isEmpty())
        {
            return null;
        }

        return data[f];
    }

    @Override
    public E last() {
        if(isEmpty())
        {
            return null;
        }

        return data[size];
    }

    @Override
    public void addFirst(E e) {

        size++;
        if(size() == CAPACITY)
        {
            throw new StackOverflowError("Stack full");
        }

        data[f] = e;

    }

    @Override
    public void addLast(E e) {

        int available;

        if(size == data.length)
        {
            throw new IllegalStateException("Queue full");
        }

        available = (f + size)%data.length;
        size++;
        data[available] = e;

    }

    @Override
    public E removeFirst() {
        size--;
        if(isEmpty())
        {
            return null;
        }

        E result = data[f];
        data[f] = null;
        return null;
    }

    @Override
    public E removeLast() {
        E answer;

        if(isEmpty())
        {
            return null;
        }

        answer = data[f];
        data[f] = null;
        f = (f+1)%data.length;
        size--;

        return answer;
    }
}
