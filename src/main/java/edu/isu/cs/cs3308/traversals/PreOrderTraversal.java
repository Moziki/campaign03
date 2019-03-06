package edu.isu.cs.cs3308.traversals;

import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.structures.impl.LinkedBinaryTree;

import java.util.List;

public class PreOrderTraversal<E> extends DepthFirstTraversal<E> implements TreeTraversal{
    public PreOrderTraversal(LinkedBinaryTree<E> t) {
        tree = t;
    }

    @Override
    public Iterable<Node<E>> traverse() {
        return null;
    }

    @Override
    public Iterable<Node<E>> traverseFrom(Node node) {
        return null;
    }

    @Override
    public Iterable<Node<E>> subTreeTraverse(Node n) {
        return null;
    }

    public void subtree(Node<E> n, List<Node<E>> l) {
        l.add(n);
        command.execute(n);
        if (tree.left(n) != null)
            subtree(tree.left(n), l);
        if (tree.right(n) != null)
            subtree(tree.left(n), l);
    }
}
