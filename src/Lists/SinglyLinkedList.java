package Lists;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {

	private static class Node<E> {
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

	private class SinglyLinkedListIterator<E> implements Iterator
 	{
 		Node cur;

 		public SinglyLinkedListIterator()
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
	Node<E> cur;
	Node<E> tail;
	private int size;

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

		Node<E> cur = head;

		while(i != 0 && cur != null)
		{
			cur = cur.next;
			i--;
		}

		if(cur == null)
		{
			throw new RuntimeException("cannot get");
		}
		return cur.getElement();
	}

	@Override
	public void add(int i, E e) {

		Node<E> cur = head;
		Node<E> prev = null;

		while(i != 0 && cur != null)
		{
			prev = cur;
			cur = cur.next;
			i--;
		}

		Node<E> o = new Node<>(e, cur);

		prev.next = o;
		size++;
	}

	@Override
	public E remove(int i) {
		i--;

		Node<E> cur = head;
		Node<E> prev = null;

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
		if(head == null)
		{
			throw new RuntimeException("cannot delete");
		}

		if(head.getElement().equals(key))
		{
			head = head.next;
			return;
		}

		Node<E> cur = head;
		Node<E> prev = null;

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
	public Iterator<E> iterator() {
		return new SinglyLinkedListIterator<E>();
	}

	@Override
	public int size() {
		return size;
	}	

	@Override
	public E removeFirst() {
		if(isEmpty())
		{
			throw new RuntimeException("cannot delete");
		}

		E answer = head.getElement();
		head = head.getNext();
		size--;

		if(size == 0)
		{
			tail = null;
		}
		return answer;
	}

	@Override
	public E removeLast() {
		if(head == null)
		{
			throw new RuntimeException("cannot delete");
		}

		Node<E> cur = head;
		Node<E> prev = null;

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
	public void addFirst(E e) {
		head = new Node<E> (e, head);
		size++;
	}

	@Override
	public void addLast(E e) {
		Node<E> newest = new Node<E>(e, null);

		if(isEmpty())
		{
			head = newest;
		}

		else
		{
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}

	public Node<E> reverse(Node<E> curr)
	{
		if(curr == null)
		{
			return null;
		}

		else if(curr.next == null)
		{
			return curr;
		}

		else
		{
			Node<E> next = curr.next;
			curr.next = null;
			Node<E> rest = reverse(next);
			next.next = curr;
			return rest;
		}
	}

	public SinglyLinkedList<E> recursiveCopy(Node<E> e)
	{
		if(e == null)
		{
			return new SinglyLinkedList<>();
		}

		SinglyLinkedList<E> copy = recursiveCopy(e.getNext());
		copy.add(0, e.getElement());
		return copy;
	}

	public String toString ()
	{
		String output = "";
		Node<E> cur = head;

		while(cur != null)
		{
			output += cur.getElement() + ", ";
			cur = cur.getNext();
		}

		return output;
	}
	
	public static void main(String[] args) {
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
		for (String s : alphabet) {
			sll.addFirst(s);
			sll.addLast(s);
		}
		System.out.println(sll.toString());

		sll.removeFirst();
		System.out.println(sll.toString());
		
		sll.removeLast();
		System.out.println(sll.toString());

		sll.remove(2);
		System.out.println(sll.toString());
		
		for (String s : sll) {
			System.out.print(s + ", ");
		}
	}
}
