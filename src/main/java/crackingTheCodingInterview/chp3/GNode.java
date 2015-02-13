package crackingTheCodingInterview.chp3;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jason on 2/13/15.
 */
public class GNode<E> {

    boolean isVisited;
    E element;
    List<GNode<E>> nodes = new LinkedList<GNode<E>>();

    public GNode(E element){
        this.element = element;
    }
}
