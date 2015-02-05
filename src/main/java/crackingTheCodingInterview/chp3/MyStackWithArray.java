package crackingTheCodingInterview.chp3;

import java.util.Arrays;

/**
 * Created by jason on 2/3/15.
 */
public class MyStackWithArray {

    int n = 10;
    int numOfStack = 3;
    int size = n/numOfStack;
    Integer[] stacks = new Integer[n];

    int[] indexes = {-1,-1,-1,-1};

    // stackNum 1 to numOfStack
    public Object peek(int stackNum) throws Exception {

        if(stackNum > numOfStack || stackNum <=0){
            throw new Exception("no stackNum "+ stackNum);
        }

        return (indexes[stackNum]==-1)? null : stacks[indexes[stackNum]];
    }



    public void push(int stackNum , Integer element) throws Exception {

        if(stackNum > numOfStack || stackNum <=0){
            throw new Exception("no stackNum "+ stackNum);
        }


        if(indexes[stackNum]==-1){//empty stack
            //get the top
            int firstIndex = (stackNum * size) - size;
            stacks[firstIndex] = element;
            indexes[stackNum] = firstIndex;
        }else{

            int nextIndex = indexes[stackNum] + 1;
            //if index is within the range
            int nextStackBegin = ((stackNum + 1) * size) - size;
            if(nextIndex >= nextStackBegin){
                throw new Exception("out of space");
            }

            stacks[nextIndex] = element;
            indexes[stackNum] = nextIndex;
        }
        print();
    }


    public Object pop(int stackNum){

        if(indexes[stackNum]!=-1){
            Object temp = stacks[indexes[stackNum]];
            stacks[indexes[stackNum]]=null;

            int nextTop = indexes[stackNum]-1;

            //within range
            int previousStackEnd = ((stackNum) * size) - size - 1;

            if(nextTop <= previousStackEnd){
                indexes[stackNum]=-1; //empty stack
            }else{
                indexes[stackNum]=nextTop;
            }

            return temp;
        }

        return null;
    }




    public void print(){
      System.out.println(Arrays.toString(stacks));
    }


    public static void main(String[] args){

        MyStackWithArray stack = new MyStackWithArray();

        try {
            stack.push(1,11);
            stack.push(2,21);
            stack.push(3,31);

            //stack.push(4,41);

            stack.push(1,12);
            stack.push(2,22);
            stack.push(3,32);

            stack.push(1,13);
            stack.push(2,23);
            stack.push(3,33);

            System.out.println(stack.pop(1));
            stack.print();
            System.out.println(stack.pop(2));
            stack.print();
            System.out.println(stack.pop(3));
            stack.print();


            System.out.println(stack.pop(1));
            stack.print();
            System.out.println(stack.pop(2));
            stack.print();
            System.out.println(stack.pop(3));
            stack.print();


            System.out.println(stack.pop(1));
            stack.print();
            System.out.println(stack.pop(2));
            stack.print();
            System.out.println(stack.pop(3));
            stack.print();




        } catch (Exception e) {
            System.out.println(e);

        }


    }


}
