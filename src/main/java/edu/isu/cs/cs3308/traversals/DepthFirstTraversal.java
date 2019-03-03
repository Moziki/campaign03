package edu.isu.cs.cs3308.traversals;

import com.google.common.collect.Lists;
import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.structures.impl.LinkedBinaryTree;

import java.util.List;

public abstract class DepthFirstTraversal<E> extends AbstractTraversal<E> {
    public DepthFirstTraversal(LinkedBinaryTree<E> t) {
        super(t);
    }

    @Override
    public Iterable<Node<E>> traverse() {
       return traverseFrom(tree.root());
    }

    @Override
    public Iterable<Node<E>> traverseFrom(Node node) {
        return subTreeTraverse(node);
    }

    public Iterable<Node<E>> subTreeTraverse(Node n) {
        List<Node<E>> snapshot = Lists.newArrayList();
        if (!tree.isEmpty())
            subtree(n, snapshot);
        return snapshot;
    }
}
