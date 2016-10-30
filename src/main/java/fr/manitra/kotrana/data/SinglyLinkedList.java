package fr.manitra.kotrana.data;

/**
 * Created by manitra on 24/10/2016.
 */
public class SinglyLinkedList<T> {
    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public T last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(T element) {
        head = new Node<>(element, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(T element) {
        Node<T> newNode = new Node<>(element, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T answer = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return answer;
    }
}
