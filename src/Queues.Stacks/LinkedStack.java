package Queues.Stacks;
import Lists.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public LinkedStack()
    {
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.add(0, e);
    }

    @Override
    public E top() {
        return list.get(0);
    }

    @Override
    public E pop() {
        return list.remove(0);
    }

    public static void main(String[] args) {

    }

}
