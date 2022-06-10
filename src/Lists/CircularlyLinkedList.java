package Lists;

import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {

	private class Node<E> {
		private E element;

		private Node<E> next;

		public Node(E e, Node<E> n)
		{
			element = e;
			next = n;
		}

		public E getElement()
		{
			return element;
		}

		public Node<E> getNext()
		{
			return next;
		}

		public void setNext(Node<E> n)
		{
			next = n;
		}
	}

	Node<E> tail = null;
	int size = 0;

	private class CircularlyLinkedListIterator<E> implements Iterator
	{
		Node cur;

		public CircularlyLinkedListIterator()
		{
			cur = tail;
		}

		@Override
		public boolean hasNext() {
			return cur != null;
		}

		@Override
		public E next() {
			E rest = (E) cur.getElement();
			cur = cur.getNext();
			return rest;
		}
	}

	private CircularlyLinkedList()
	{
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E get(int i) {
		Node cur = tail;

		while(i != 0 && cur != null)
		{
			cur = cur.next;
			i--;
		}

		if(cur == null)
		{
			throw new RuntimeException("cannot get");
		}
		return (E) cur.getElement();
	}

	@Override
	public void add(int i, E e) {
		Node cur = tail;
		Node prev = null;

		while(i != 0 && cur != null)
		{
			prev = cur;
			cur = cur.next;
			i--;
		}

		Node o = new Node(e, cur);

		prev.next = o;
		size++;
	}

	@Override
	public E remove(int i) {
		i--;

		Node cur = tail;
		Node prev = null;

		while(i != 0 && cur != null)
		{
			prev = cur;
			cur = cur.next;
			i--;
		}

		if(cur == null)
		{
			throw new RuntimeException("cannot remove");
		}

		prev.next = cur.next;

		return null;
	}

	public void remove(String key)
	{
		if(tail == null)
		{
			throw new RuntimeException("cannot delete");
		}

		if(tail.getElement().equals(key))
		{
			tail = tail.next;
			return;
		}

		Node cur = tail;
		Node prev = null;

		while(cur != null && !cur.getElement().equals(key))
		{
			prev = cur;
			cur = cur.next;
		}

		if(cur == null)
		{
			throw new RuntimeException("cannot delete");
		}

		prev.next = cur.next;
	}

	@Override
	public E removeFirst() {
		if(tail == null)
		{
			throw new RuntimeException("cannot delete");
		}

		Node cur = tail;
		Node prev = null;

		tail = cur.next;
		size--;

		return null;
	}

	@Override
	public E removeLast() {
		if(tail == null)
		{
			throw new RuntimeException("cannot delete");
		}

		Node cur = tail;
		Node prev = null;

		while(cur.getNext() != null)
		{
			prev = cur;
			cur = cur.next;
		}

		prev.next = null;
		size--;
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		return new CircularlyLinkedListIterator<E>();
	}

	@Override
	public void addFirst(E e) {
		tail = new Node<E>(e, tail);
		size++;
	}

	@Override
	public void addLast(E e) {
		Node<E> newest = new Node<E>(e, null);
		Node<E> last = tail;

		if(last == null)
		{
			tail = newest;
		}

		else
		{
			while(last.getNext() != null)
			{
				last = last.getNext();
			}
			last.setNext(newest);
		}
		size++;
	}

	public void rotate() {
		if(tail != null)
		{
			tail = tail.getNext();
		}

		else
		{
			throw new RuntimeException("cannot rotate");
		}
	}

	public String toString ()
	{
		String output = "";
		Node cur = tail;

		while(cur != null)
		{
			output += cur.getElement() + ", ";
			cur = cur.getNext();
		}

		return output;
	}
	
	
	public static void main(String[] args) {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
		for(int i = 10; i < 20; ++i) {
			ll.addLast(i);
		}

		System.out.println(ll);

		ll.removeFirst();
		System.out.println(ll);

		ll.removeLast();

		ll.rotate();
		System.out.println(ll);

		ll.removeFirst();
		ll.rotate();
		System.out.println(ll);

		ll.removeLast();
		ll.rotate();
		System.out.println(ll);

		for (Integer e : ll) {
			System.out.println("value: " + e);
		}

	}
}
