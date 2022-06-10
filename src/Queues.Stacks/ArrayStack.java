package Queues.Stacks;
public class ArrayStack<E> implements Stack<E> {

    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;


    public ArrayStack()
    {
        this(CAPACITY);
    }

    public ArrayStack(int capacity)
    {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return (t + 1);
    }

    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public void push(E e) {
        t++;
        if(size() == CAPACITY)
        {
            throw new StackOverflowError("Stack full");
        }

        data[t] = e;
    }

    @Override
    public E pop() {
        if(isEmpty())
        {
            return null;
        }

        E result = data[t];
        data[t] = null;
        return null;
    }

    @Override
    public E top() {
        if(t == -1)
        {
            return null;
        }

        return data[t];
    }
}
