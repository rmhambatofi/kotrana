package fr.manitra.kotrana.ctci;

import org.junit.Before;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by manitra on 12/11/16.
 */
public class BinarySearchTreeTest {

    BinarySearchTree tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree();
        tree.add(10);
        tree.add(8);
        tree.add(12);
        tree.add(15);
        tree.add(5);
        tree.add(11);
        tree.add(9);
        tree.add(7);
        tree.add(10);
        tree.add(17);
        tree.add(2);
    }

    @Test
    public void it_should_contains_13_nodes() throws Exception {
        tree.add(1);
        tree.add(19);
        assertThat(tree.size()).isEqualTo(13);
    }

    @Test
    public void preorderTest() {
        System.out.println("-------- preorder test -------");
        tree.preorder();
        System.out.println("------------------------------");
    }

    @Test
    public void postorderTest() {
        System.out.println("-------- postorder test -------");
        tree.postorder();
        System.out.println("--------------------------");
    }

    @Test
    public void inorderTest() {
        System.out.println("-------- inorder test -------");
        tree.inorder();
        System.out.println("--------------------------");
    }

    @Test
    public void breathFirstTest() {
        System.out.println("-------- breadth first test -------");
        tree.breadthFirst();
        System.out.println("------------------------------------");
    }

    @Test
    public void queueTest() {
        Deque<String> deque = new LinkedList<>();
        deque.addLast("un");
        deque.addLast("deux");
        deque.addLast("trois");
        System.out.println(deque.poll());
        System.out.println(deque.poll());
        System.out.println(deque.poll());
    }
}