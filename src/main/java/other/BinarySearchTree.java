package other;

import crackingTheCodingInterview.chp3.Node;

/**
 * Created by jason on 2/14/15.
 */
public class BinarySearchTree {

    static int nextNode(TNode n){

        if(n==null){
            return -1;
        }
        //no child
        if(n.left==null && n.right==null){
            return getMostRightParent(n);
        }

        return getMostLeftChild(n.right);
    }

    private static int getMostLeftChild(TNode<Integer> n) {

        if(n==null){
            return -1;
        }

        if(n.left==null){
            return n.element;
        }

        return getMostLeftChild(n.left);

    }

    private static int getMostRightParent(TNode<Integer> n) {

        if(n==null){
            return -1;
        }

        //if i am the left child
        if(n.parent!=null && n.parent.left==n){
            return n.parent.element;
        }

        return getMostRightParent(n.parent);

    }

    public static void main(String[] args){

        //left , right, parent , element



        TNode<Integer> n49 = new TNode<Integer>(49);
        TNode<Integer> n75 = new TNode<Integer>(75);
        TNode<Integer> n65 = new TNode<Integer>(65);
        TNode<Integer> n100 = new TNode<Integer>(100);
        TNode<Integer> n90 = new TNode<Integer>(90);
        TNode<Integer> n25 = new TNode<Integer>(25);
        TNode<Integer> n50 = new TNode<Integer>(50);

        n50.left = n25;
        n50.right= n75;
        n25.right= n49;
        n25.parent=n50;
        n49.parent=n25;
        n75.left = n65;
        n65.parent=n75;
        n75.right = n100;
        n75.parent=n50;
        n100.left = n90;
        n100.parent=n75;

//
//                      [50]
//                     /    \
//                 [25]      [75]
//                    \      /   \
//                    [49]  [65] [100]
//                                /
//                               [90]

        System.out.println(BinarySearchTree.nextNode(n50));
        System.out.println(BinarySearchTree.nextNode(n49));
        System.out.println(BinarySearchTree.nextNode(n65));
        System.out.println(BinarySearchTree.nextNode(n75));
        System.out.println(BinarySearchTree.nextNode(n100));

    }

}
