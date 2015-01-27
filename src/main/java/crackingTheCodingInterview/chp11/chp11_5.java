package crackingTheCodingInterview.chp11;

/**
 * Created by jason on 1/26/15.
 */
public class chp11_5 {

    static int find(String[] s, String x, int start, int end){


        if(start >end) return -1;

        if(start==end) {
            return s[start].equals(x) ? start : -1;
        }

        int mid = ( start + end ) / 2;


        if(s[mid].equals("")){
            int temp1 = find(s,x,start, mid);
            int temp2 = find(s,x,mid+1 , end);
            return (temp1>-1)? temp1 : temp2;
        }else if(s[mid].compareTo(x) > 0){
            return find(s,x, start, mid);
        }else if (s[mid].compareTo(x) <0){
            return find(s,x,mid+1, end);
        }else{
            return mid;
        }
    }


    public static void main(String[] args){

        String[] s = {"a","","b","","","c","d","","","","e"};

        System.out.println(find(s,"a",0,s.length-1));
        System.out.println(find(s,"b",0,s.length-1));
        System.out.println(find(s,"c",0,s.length-1));
        System.out.println(find(s,"d",0,s.length-1));
        System.out.println(find(s,"e",0,s.length-1));



    }


}