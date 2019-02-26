package edu.isu.cs.cs3308.traversals;

import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.traversals.commands.TraversalCommand;

public abstract class AbstractTraversal<E> implements TreeTraversal {
   Tree<E> tree;
    public AbstractTraversal(Tree<E> t) {
        tree = t;
    }
    public void setCommand(TraversalCommand cmd){}

}
