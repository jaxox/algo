package crackingTheCodingInterview.chp3;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jason on 2/13/15.
 */
public class GraphCycle {

    static boolean dfs(GNode n , GNode previousNode){

        if(n==null){
            return false;
        }

        List<GNode> nodes = n.nodes;


        boolean result = false;

        for(GNode node : nodes){

            if(node.isVisited && node!=previousNode){
                return true;
            }

            node.isVisited = true;

            result = result || dfs(node, n);
        }


        return result;

    }

    public static void main(String[] args){

        GNode<Integer> n0 = new GNode<Integer>(0);
        GNode<Integer> n1 = new GNode<Integer>(1);
        GNode<Integer> n2 = new GNode<Integer>(2);
        GNode<Integer> n3 = new GNode<Integer>(3);
        GNode<Integer> n4 = new GNode<Integer>(4);
        GNode<Integer> n5 = new GNode<Integer>(5);
        GNode<Integer> n6 = new GNode<Integer>(6);
        GNode<Integer> n7 = new GNode<Integer>(7);

        n1.nodes.add(n2);
        n1.nodes.add(n3);

        n2.nodes.add(n1);
        n2.nodes.add(n3);

        n3.nodes.add(n1);
        n3.nodes.add(n2);



        System.out.println(GraphCycle.dfs(n1, null));


    }




}
