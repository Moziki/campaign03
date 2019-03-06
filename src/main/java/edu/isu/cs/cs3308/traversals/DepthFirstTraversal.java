package edu.isu.cs.cs3308.traversals;

import com.google.common.collect.Lists;
import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.structures.impl.LinkedBinaryTree;

import java.util.List;

public abstract class DepthFirstTraversal<E> extends AbstractTraversal<E> implements TreeTraversal{


    @Override
    public abstract Iterable<Node<E>> traverse();

    @Override
    public abstract Iterable<Node<E>> traverseFrom(Node node);

    public abstract Iterable<Node<E>> subTreeTraverse(Node n);

    public abstract void subTree(Node<E> p, List<Node<E>> l);


}
