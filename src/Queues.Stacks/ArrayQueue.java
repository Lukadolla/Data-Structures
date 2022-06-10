package Queues.Stacks;
public class ArrayQueue<E> implements Queue<E> {

    public static final int CAPACITY = 1000;
    private E[] data;
    private int f = 0;
    private int size = 0;

    public ArrayQueue()
    {
        this(CAPACITY);
    }

    public ArrayQueue(int capacity)
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
    public void enqueue(E e) {
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
    public E first() {
        if(isEmpty())
        {
            return null;
        }

        return data[f];
    }

    @Override
    public E dequeue() {
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
