package crackingTheCodingInterview.chp3;

/**
 * Created by jason on 2/3/15.
 */
public class SetOfStack {

    int noOfStack = 3;
    int size = 3;
    int[] indexes = {-1,-1,-1};
    Node[] tops = new Node[3];


    public void push(Integer element){

        int stackNum = findNextSlot();

        //Normal stack
        Node<Integer> newNode = new Node<Integer>(element);
        if(tops[stackNum]==null){
            tops[stackNum] = newNode;
        }else{
            newNode.next = tops[stackNum];
            tops[stackNum] = newNode;
        }

        indexes[stackNum]++;
    }

    private int findNextSlot()  {

        for(int i =0; i<size; i++){
            int stackSize = indexes[i];
            if(stackSize==-1 || stackSize < size-1){
                return i;
            }
        }

        //they all are full
        try {
            throw new Exception("they all are full");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;

    }


    public Integer pop(){

        int stackNum = findTopOfStacks();

        //Node top = tops[stackNum];

        if(tops[stackNum]==null){
            return null;
        }

        Node<Integer> result = tops[stackNum];
        tops[stackNum] = tops[stackNum].next;
        result.next = null;

        indexes[stackNum]--;

        return result.element;

    }

    private int findTopOfStacks() {

        for(int i = size-1; i>=0; i--){

            int stackSize = indexes[i];

            if(stackSize!=-1){
                return i;
            }
        }

        return 0;
    }


    public Integer peek(){

        int stackNum = findTopOfStacks();

        Node<Integer> top = tops[stackNum];

        if(top==null){
            return null;
        }
        return top.element;
    }

    public void print(){

      for(int i=0; i<3; i++) {
          System.out.print("S"+ i + "[ ");

          Node temp = tops[i];

          while (temp != null) {
              System.out.print(temp.element + " --> ");
              temp = temp.next;
          }
          System.out.println("]");
      }


    }


    public static void main(String[] args){

        SetOfStack stack = new SetOfStack();

        for(int i=0; i<20; i++){

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
