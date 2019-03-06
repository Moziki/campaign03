package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.BinaryTree;
import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import java.util.ArrayList;
import java.util.List;

public class LinkedBinaryTree<E> implements BinaryTree<E>, Tree<E> {

    protected static class BinaryTreeNode<E> implements Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public BinaryTreeNode(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        public E getElement() {return element;}
        public Node<E> getParent() {return parent;}
        public Node<E> getLeft() {return left;}
        public Node<E> getRight() {return right;}

        public void setElement(E e) {element = e;}
        public void setParent(Node<E> parentNode) {parent = parentNode;}
        public void setLeft(Node<E> leftChild) {left = leftChild;}
        public void setRight(Node<E> rightChild) {right = rightChild;}
    }

    protected BinaryTreeNode<E> createNode(E e, BinaryTreeNode<E> parent, BinaryTreeNode<E> left, BinaryTreeNode<E> right) {
        if (e == null)
            throw new IllegalArgumentException();
        return new BinaryTreeNode<>(e, parent, left, right);
    }

    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {}


    @Override
    public Node<E> left(Node<E> p) throws IllegalArgumentException {
        BinaryTreeNode<E> node = (BinaryTreeNode<E>) validate(p);
        return node.getLeft();
    }

    @Override
    public Node<E> right(Node<E> p) throws IllegalArgumentException {
        BinaryTreeNode<E> node = (BinaryTreeNode<E>) validate(p);
        return node.getRight();
    }

    @Override
    public Node<E> sibling(Node<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Node<E> addLeft(Node<E> p, E element) throws IllegalArgumentException {
        BinaryTreeNode<E> parent = (BinaryTreeNode)validate(p);
        if (parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");
        BinaryTreeNode<E> child = createNode(element, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    @Override
    public Node<E> addRight(Node<E> p, E element) throws IllegalArgumentException {
        BinaryTreeNode<E> parent = (BinaryTreeNode)validate(p);
        if (parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");
        BinaryTreeNode<E> child = createNode(element, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    @Override
    public Node<E> root() {
        return root;
    }

    @Override
    public Node<E> setRoot(E item) {
        if (item == null){
            size = 0;
            return null;
        }
        root = createNode(item, null, null, null);
        size = 1;
        return root;
    }

    @Override
    public Node<E> parent(Node<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public Iterable<Node<E>> children(Node<E> p) throws IllegalArgumentException {
        List<Node<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null)
            snapshot.add(left(p));
        if (right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }

    @Override
    public int numChildren(Node<E> p) throws IllegalArgumentException {
        int count = 0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;

    }

    @Override
    public boolean isInternal(Node<E> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Node<E> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Node<E> p) throws IllegalArgumentException {
        return p == root;
    }
    @Override
    public Node<E> insert(E item, Node<E> father) throws IllegalArgumentException {
        if (item == null || validate(father) == null || numChildren(father) == 2) {
            throw new IllegalArgumentException();
        }
        BinaryTreeNode<E> node = new BinaryTreeNode<>(item, null, null, null);
        BinaryTreeNode<E> parent = (BinaryTreeNode<E>) father;
        if (parent.getLeft() == null) {
            node.setParent(parent);
            parent.setLeft(node);
            size++;
        } else if (parent.getRight() == null) {
            node.setParent(parent);
            parent.setRight(node);
            size++;
        } else {
            insert(item, parent.getLeft());
        }
        return node;
    }



    @Override
    public boolean remove(E item, Node<E> p) throws IllegalArgumentException {
        if (p == null || item == null) {
            return false;
        }
        if (validate(p) == null || item == null) {
            throw new IllegalArgumentException();
        }
        BinaryTreeNode<E> node = (BinaryTreeNode<E>) p;
        if (node.getLeft().getElement() == item){
            node.getLeft().setElement(null);
            node.setLeft(null);
        }
        if (node.getRight().getElement() == item) {
            node.getRight().setElement(null);
            node.setRight(null);
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public E set(Node<E> node, E element) throws IllegalArgumentException {
        Node<E> test = validate(node);
        if (element == null || test == null) {
            throw new IllegalArgumentException();
        }
        node.setElement(element);
        return element;
    }

    @Override
    public Node<E> validate(Node<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = p;
        if (node.getParent() == null && node != root)
            throw new IllegalArgumentException("p is no longer in the tree");
        return p;
    }

    @Override
    public int depth(Node<E> node) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public int subTreeSize(Node<E> node) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public boolean isLastChild(Node<E> node) throws IllegalArgumentException {
        return false;
    }
}
