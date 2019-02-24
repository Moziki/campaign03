package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Node;

public class BinaryTreeNode<E> implements Node {

    public E element;
    @Override
    public Object getElement() {
        return element;
    }

    @Override
    public void setElement(Object ele) throws IllegalArgumentException {
        if (ele == null) {
            throw new IllegalArgumentException("Element is null");
        }
        element = (E)ele;
    }

    @Override
    public Node getParent() {
        return null;
    }
}
