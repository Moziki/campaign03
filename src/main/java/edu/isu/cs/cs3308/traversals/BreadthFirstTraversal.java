package edu.isu.cs.cs3308.traversals;

import com.google.common.collect.Lists;
import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class BreadthFirstTraversal<E> extends AbstractTraversal<E> {
    public BreadthFirstTraversal(Tree<E> t) {
        super(t);
    }

    @Override
    public Iterable<Node<E>> traverse() {
        traverseFrom(tree.root());
        return null;
    }

    @Override
    public Iterable<Node<E>> traverseFrom(Node node) {

        List<Node<E>> snapshot = Lists.newArrayList();
        LinkedList<Node<E>> queue = Lists.newLinkedList();
        if (!tree.isEmpty()) {
            queue.addFirst(node);
            while (!queue.isEmpty()) {
                Node<E> n = queue.removeFirst();
                snapshot.add(n);
                for (Node<E> c : tree.children(n))
                    queue.addFirst(c);
            }
        }
        return snapshot;
    }
}


