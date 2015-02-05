package crackingTheCodingInterview.chp3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jason on 2/3/15.
 */
public class MyStackWithMin {

    Node<Integer> top;
    Node<Integer> minTop;

    public void push(Integer element){

        //Normal stack
        Node<Integer> newNode = new Node<Integer>(element);
        if(top==null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }

        // Min stack
        newNode = new Node<Integer>(element);
        if(minTop==null){
            minTop = newNode;
        }else if(minTop.element >= element){
            newNode.next = minTop;
            minTop = newNode;
        }


    }


    public Integer pop(){
        if(top==null) {
            return null;
        }

        Node<Integer> result = top;
        top = top.next;
        result.next = null;

        //
        if(minTop.element == result.element){
            result = minTop;
            minTop = minTop.next;
            result.next = null;
        }

        return result.element;

    }

    public Integer min(){
        return (minTop==null)? null : minTop.element;
    }


    public Integer peek(){
        if(top==null){
            return null;
        }
        return top.element;
    }

    public void print(){

        Node<Integer> temp = top;
        while(temp!=null){
            System.out.print(temp.element + " --> " );
            temp = temp.next;
        }
        System.out.println();
        System.out.println("min="+min());


    }


    public static void main(String[] args){

        MyStackWithMin stack = new MyStackWithMin();

        for(int i=0; i<10; i++){

            if(Math.random()>0.5){
                int num = (int)(Math.random()*100);
                stack.push(num);
                System.out.println("push "+num);
            }else{
                System.out.println("pop " + stack.pop());
            }

            stack.print();

        }


    }


}
