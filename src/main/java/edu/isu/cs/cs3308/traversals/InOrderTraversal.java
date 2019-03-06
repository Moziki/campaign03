package edu.isu.cs.cs3308.traversals;

import com.google.common.collect.Lists;
import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.structures.impl.LinkedBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal<E> extends DepthFirstTraversal<E> implements TreeTraversal{
    public InOrderTraversal(LinkedBinaryTree<E> t) {
        tree = t;
    }

    @Override
    public Iterable<Node<E>> traverse() {
        traverseFrom(tree.root());
        return null;
    }

    @Override
    public Iterable<Node<E>> traverseFrom(Node node) {
        subTreeTraverse(node);
        return null;
    }

    @Override
    public Iterable<Node<E>> subTreeTraverse(Node n) {
        List<Node<E>> list = Lists.newArrayList();
        if (!tree.isEmpty()) {
            subtree(n, list);
        }
        return list;
    }

    public void subtree(Node<E> n, List<Node<E>> l) {
        if (tree.left(n) != null)
            subtree (tree.left(n), l);
        l.add(n);
        command.execute(n);
        if (tree.right(n) != null)
            subtree(tree.right(n), l);

    }
}
