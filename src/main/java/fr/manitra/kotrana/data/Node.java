package fr.manitra.kotrana.data;

/**
 * Created by manitra on 24/10/2016.
 */
public class Node<T> {
    private T element;
    private Node<T> next;

    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
