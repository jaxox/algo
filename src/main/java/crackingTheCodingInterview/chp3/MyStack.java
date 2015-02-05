package crackingTheCodingInterview.chp3;

/**
 * Created by jason on 2/3/15.
 */
public class MyStack<E> {

    Node<E> top;

    public E pop(){
        if(top!=null){
            E temp = top.element;
            top = top.next;
            return temp;
        }
        return null;
    }

    public void push(E element){

        Node<E> newNode = new Node<E>(element);

        if(top==null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
    }

    public E peek(){
        if(top==null){
            return null;
        }
        return top.element;
    }

    public void print(){

        Node<E> temp = top;

        while(temp!=null){
            System.out.print(temp.element + " --> " );
            temp = temp.next;
        }
        System.out.println();

    }


    public static void main(String[] args){

        MyStack<Integer> stack = new MyStack<Integer>();

        for(int i=0; i<10; i++){

            if(Math.random()>0.5){
                stack.push(i);
                System.out.println("push "+i);
            }else{
                System.out.println("pop " + stack.pop());
            }

            stack.print();

        }


    }


}
