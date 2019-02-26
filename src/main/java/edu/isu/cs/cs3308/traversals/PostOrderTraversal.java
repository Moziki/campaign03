package edu.isu.cs.cs3308.traversals;

import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.structures.impl.LinkedBinaryTree;

import java.util.List;

public class PostOrderTraversal<E> extends DepthFirstTraversal<E> {
    public PostOrderTraversal(LinkedBinaryTree<E> t) {
        super(t);
    }

    public Iterable<Node<E>> subtree(Node<E> n, List<Node<E>> l) {
        if (tree.left(n) != null)
            subtree(tree.left(n), l);
        if (tree.right(n) != null)
            subtree(tree.right(n), l);
        l.add(n);
        command.execute(n);
    }
}
