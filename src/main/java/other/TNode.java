package other;

/**
 * Created by jason on 2/14/15.
 */
public class TNode<E> {
    //Say tree node
    TNode<E> parent;
    TNode<E> left;
    TNode<E> right;
    E element;

    public TNode(E element){
        this.element = element;
    }

    public TNode(TNode left, TNode right, TNode parent, E element){
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.element = element;
    }


}
