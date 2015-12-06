import java.util.HashSet;
import java.util.Set;

/**
 * Created by tarekray on 06/12/15.
 */
public class SudokuValidity {


    public static  HashSet<Integer> getGoldenNumbers(int j)
    {
        HashSet<Integer> goldenNumbers = new HashSet<Integer>() ;
       for(int index = 1 ; index <= j ; index++ )
       {
           goldenNumbers.add(index) ;
       }
      return  goldenNumbers ;
    }

    public static  boolean isValid(int[][] grid)
    {
        return isComplete(grid) && isValidRows(grid) && isValidColumns(grid) && isValidSquares(grid) ;
    }

    public static boolean isComplete(int[][] grid)
    {
        if(nextEmptyCase(grid)==-1)
        {
            return true ;
        }
        return  false ;
    }
    public static  int nextEmptyCase(int[][] grid)
    {
        for(int j = 0 ; j < grid.length ; j++){
            for(int i = 0 ; i < grid.length ;i++){
                if(grid[j][i]==0) {
                    return j*10 + i ;
                }
            }
        }
        return  -1 ;
    }


    public static boolean isValidSquares(int[][] grid) {
        int size = grid.length ;
        int squareLength = (int) Math.sqrt(size) ;

        for(int j = 0 ; j < grid.length ; j=j+squareLength)
        {
            for(int i = 0 ; i < grid.length ; i = i +squareLength)
            {
                Set<Integer> tempNumbers = new HashSet<Integer>() ;

                for(int jSquare = j ; jSquare < j + squareLength ; jSquare++){
                    for(int iSquare = i ; iSquare < i+squareLength ; iSquare++){
                        if(grid[jSquare][iSquare]!=0) {
                            tempNumbers.add(grid[jSquare][iSquare]);
                        }
                    }
                }
                if(!tempNumbers.equals(getGoldenNumbers(grid.length)))
                {
                    return  false ;
                }
            }

        }

        return  true ;
    }

    public static  boolean isValidColumns(int[][] grid) {

        for(int j = 0 ; j < grid.length ; j++)
        {
            Set<Integer> tempNumbers = new HashSet<Integer>() ;
            for(int i = 0 ; i < grid.length ; i++){
                tempNumbers.add(grid[i][j]) ;
            }
            if(!tempNumbers.equals(getGoldenNumbers(grid.length))){
                return  false ;
            }
        }
        return  true ;
    }

    public static boolean isValidRows(int[][] grid) {
        for(int j = 0 ; j < grid.length ; j++)
        {
            Set<Integer> tempNumbers = new HashSet<Integer>() ;
            for(int i = 0 ; i < grid.length ; i++){
                tempNumbers.add(grid[j][i]) ;
            }
            if(!tempNumbers.equals(getGoldenNumbers(grid.length))){
                return  false ;
            }
        }
        return  true ;
    }

}
