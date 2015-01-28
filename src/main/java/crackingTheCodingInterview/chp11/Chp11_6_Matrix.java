package crackingTheCodingInterview.chp11;



/**
 * Created by jason on 1/27/15.
 */
public class Chp11_6_Matrix {

      Point find(int[][] matrix, int target, Point x, Point y){

        int mid = (x.x + y.x) / 2;


        int num = matrix[mid][mid];

        if(num==target){
            return new Point(mid,mid);
        }else if(num < target){
            return find(matrix,target, new Point(mid+1,mid+1),y);
        }else if(num > target){
            Point temp = findRC(matrix, target, new Point(mid,0), new Point(mid,mid-1));

            if(temp!=null){
                return temp;
            }

            temp = findRC(matrix, target, new Point(0,mid), new Point(mid-1,mid));

            if(temp!=null){
                return temp;
            }

            return find(matrix,target,x,new Point(mid,mid));
        }

        return null;

    }

    private   Point findRC(int[][] matrix, int target, Point x, Point y) {


        if(x.x == y.x && x.y == y.y){//same point
            int temp = matrix[x.x][x.y];
            if(temp==target){
                return x;
            }

            return null;
        }

        if(x.x == y.x){//search for row

            int mid = (x.y + y.y)/2;
            int temp = matrix[x.x][mid];

            if(temp==target){
                return new Point(x.x,mid);
            }else if(temp>target){//search left
                return findRC(matrix,target,x, new Point(x.x,mid-1));

            }else{//search right

                return findRC(matrix,target,new Point(x.x,mid+1),y);
            }

        }else{//column
            int mid = (x.x + y.x)/2;
            int temp = matrix[x.y][mid];

            if(temp==target){
                return new Point(x.y,mid);
            }else if(temp>target){//search top
                return findRC(matrix,target,x, new Point(x.y,mid-1));
            }else{//search btm
                return findRC(matrix,target,new Point(x.y,mid+1),y);
            }
        }

    }

    Point find(int[][] matrix , int target){
        if(matrix==null || matrix.length==0){
            return null;
        }

        return find(matrix,target,new Point(0,0), new Point(matrix.length-1,matrix.length-1));
    }

    public static void main(String[] args){

        int[][] matrix = {  {  0,  1,  4,  9 },
                            {  2,  3,  6, 11 },
                            {  5,  7,  8, 13 },
                            { 10, 12, 14, 15 }
                         };


        Chp11_6_Matrix chp = new Chp11_6_Matrix();

        Point p = chp.find(matrix, 15);

        if(p!=null)
        System.out.println("found matrix["+p.x+"]["+p.y+"]=" +matrix[p.x][p.y]);
    }


    class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
