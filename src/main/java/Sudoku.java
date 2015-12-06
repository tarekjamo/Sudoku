import java.util.HashSet;
import java.util.Set;

/**
 * Created by tarekray on 04/12/15.
 */
public class Sudoku {

    public int[][] grid ;
    public static  Set<Integer> goldenNumbers ;

    public static int[][] solution ;


    public Sudoku(int[][] grid)
    {
        this.grid = grid ;

        goldenNumbers = new HashSet<Integer>() ;
        for(int i = 1 ; i <= grid.length ; i++)
        {
            goldenNumbers.add(i) ;
        }

    }

    public boolean Solve()
    {
        if(SudokuValidity.isValid(grid))
        {
            print();
            solution = grid ;
            return true ;
        }

        if(SudokuValidity.isComplete(grid))
        {
            return  false ;
        }

        Indexes firstEmptyCase = SudokuValidity.nextEmptyCase(grid);
        int iEmptyCase = firstEmptyCase.i ;
        int jEmptyCase = firstEmptyCase.j ;

        Set<Integer> allPossibilities = getAllPossibilities(jEmptyCase, iEmptyCase);
        if(allPossibilities.size()==0)
        {
            return  false ;
        }
        boolean solved = false ;
        for (Integer possibilty : allPossibilities)
        {

            int[][] tempGrid = copy(grid);
            tempGrid[jEmptyCase][iEmptyCase] = possibilty;


            Sudoku sudokuTemp = new Sudoku(tempGrid);

            solved =   sudokuTemp.Solve();
            if(solved)
            {
                return  true ;
            }

        }
        return  false ;

    }

public int[][] copy(int[][] original)
{
    int[][] cloned = new int[original.length][original.length] ;

    for(int j = 0 ; j < original.length ; j++)
    {
        for (int i = 0; i < original.length; i++)
        {
            cloned[j][i] = original[j][i];
        }
    }
    return  cloned ;
}

    public HashSet<Integer> getAllPossibilities(int j, int i)
    {
        HashSet<Integer> allPossiblities = new HashSet<>(goldenNumbers) ;

        substract(allPossiblities, getAllHorizontalOccurency(j)) ;
        substract(allPossiblities , getAllVerticalOccurency(i)) ;
        substract(allPossiblities, getAllSquareOccurency(j, i)) ;

        return  allPossiblities ;

    }

    private void substract(HashSet<Integer> lhs, HashSet<Integer> rhs)
    {
        for(Integer i : rhs)
        {
            if(lhs.contains(i)){
                lhs.remove(i) ;
            }
        }
    }

    private HashSet<Integer> getAllHorizontalOccurency(int j)
    {
        HashSet<Integer> tempNumbers = new HashSet<Integer>() ;
        for(int i = 0 ; i < grid.length ; i++)
        {
            if(grid[j][i]!=0)
            {
                tempNumbers.add(grid[j][i]);

            }
        }
        return tempNumbers ;
    }

    private HashSet<Integer> getAllSquareOccurency(int j, int i)
    {
            int squareSize = (int)Math.sqrt(grid.length) ;
            int iSquare = i % squareSize ;
            int jSquare = j % squareSize ;

            int iSquareTop = i - iSquare ;
            int jSquareTOP = j - jSquare ;

        HashSet<Integer> tempNumbers = new HashSet<Integer>() ;


        for(int m = jSquareTOP ; m < jSquareTOP + squareSize ; m++)
            {
                for(int n = iSquareTop ; n <iSquareTop + squareSize ; n++)
                {
                    if(grid[m][n]!=0) {
                        tempNumbers.add(grid[m][n]);
                    }
                }
            }
        return  tempNumbers ;
    }

    private HashSet<Integer> getAllVerticalOccurency(int i)
    {
            HashSet<Integer> tempNumbers = new HashSet<Integer>() ;
            for(int j = 0 ; j < grid.length ; j++)
            {
                if(grid[j][i]!=0)
                {
                    tempNumbers.add(grid[j][i]);
                }
            }
            return tempNumbers ;
    }


    public void print()
    {

        for(int j = 0 ; j < grid.length ; j++)
        {
            for(int i = 0 ; i < grid.length ; i++)
            {
                System.out.print(grid[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
