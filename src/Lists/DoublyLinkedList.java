package Lists;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {

	private class Node<E> {

		private E element;
		private Node<E> next;
		private Node<E> previous;

		public Node(E e, Node<E> p, Node<E> n)
		{
			element = e;
			next = n;
			previous = p;
		}

		public E getElement()
		{
			return element;
		}

		public Node<E> getNext()
		{
			return next;
		}

		public Node<E> getPrevious()
		{
			return previous;
		}

		public void setNext(Node<E> n)
		{
			next = n;
		}

		public void setPrevious(Node<E> p)
		{
			previous = p;
		}
	}

	private class DoublyLinkedListIterator<E> implements Iterator
	{
		Node cur;

		public DoublyLinkedListIterator()
		{
			cur = head;
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

	Node<E> head;
	Node<E> trailer;
	int size = 0;

	public DoublyLinkedList()
	{
		head = new Node<>(null, null, null);
		trailer = new Node<>(null, head, null);
		head.setNext(trailer);
	}

	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrevious(newest);
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(head == null)
		{
			return true;
		}
		return false;
	}

	@Override
	public E get(int i) {
		Node cur = head;
		Node prev = null;
		i--;

		if(head == null)
		{
			throw new RuntimeException("cannot get");
		}

		while(i > 0 && cur != null)
		{
			prev = cur;
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
		i--;
		Node cur = head;
		Node prev = null;

		while(i > 0 && cur != null)
		{
			i--;
			prev = cur;
			cur = cur.next;
		}

		Node n = new Node<E>(e, cur, prev);
		prev.next = n;
	}

	@Override
	public E remove(int i) {
		i--;

		Node cur = head;
		Node prev = null;

		while(i != 0 && cur != null)
		{
			prev = cur;
			cur = cur.next;
			i--;
		}

		if(cur == null)
		{
			throw new RuntimeException("cannot get");
		}

		prev.next = cur.next;

		return null;
	}

	private E remove(Node<E> e)
	{
		Node <E> predecessor = e.getPrevious();
		Node <E> successor = e.getNext();
		predecessor.setNext(successor);
		successor.setPrevious(predecessor);
		size--;
		return e.getElement();
	}

	@Override
	public Iterator<E> iterator() {
		return new DoublyLinkedListIterator();
	}


	@Override
	public E removeFirst() {
		if(isEmpty())
		{
			return null;
		}

		return remove(trailer.getPrevious());
	}

	@Override
	public E removeLast() {
		if(isEmpty())
		{
			return null;
		}

		return remove(trailer.getPrevious());
	}

	@Override
	public void addFirst(E e) {
		addBetween(e, head, head.getNext());
	}

	@Override
	public void addLast(E e) {
		addBetween(e, trailer.getPrevious(), trailer);
	}

	public String toString ()
	{
		String output = "";
		Node<E> cur = head.getNext();

		while(cur.getNext() != null)
		{
			output += cur.getElement() + ", ";
			cur = cur.getNext();
		}

		return output;
	}
	
	public static void main(String[] args) {
			DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
           ll.addFirst(0);
           ll.addFirst(1);
           ll.addFirst(2);
           ll.addLast(-1);
           System.out.println(ll.toString());
           
           ll.removeFirst();
           System.out.println(ll);

           ll.removeLast();
           System.out.println(ll);
           
           for(Integer e: ll) {
                   System.out.println("value: " + e);
           }
	}
}
