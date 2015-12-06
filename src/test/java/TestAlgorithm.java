import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by tarekray on 04/12/15.
 */
public class TestAlgorithm {

   public static String FOURCORRECT = "correct/four.txt" ;
    public static String NINECORRECT = "correct/nine.txt" ;


    public static String FOURWRONG = "wrong/four.txt" ;
    public static String NINEWRONG = "wrong/nine.txt" ;

    public static String FOURINCOMPLETE = "incomplete/four.txt" ;
    public static String NINEINCOMEPLE = "incomplete/nine.txt" ;

    public static String FOURINCOMPLETEACCEPTANCE = "incomplete/fourAcceptance.txt" ;
    public static String NINEINCOMEPLETEACCEPTANCE = "incomplete/acceptance.txt" ;



    @org.junit.Test
    public void acceptance()
    {
        SudokuParser sudokuParser = new SudokuParser();
        Sudoku sudoku = new Sudoku(sudokuParser.createSudoku(NINEINCOMEPLETEACCEPTANCE)) ;
        sudoku.Solve();
        assertThat(SudokuValidity.isValid(sudoku.solution)).isEqualTo(true) ;

    }

    @org.junit.Test
    public void acceptance_four()
    {
        SudokuParser sudokuParser = new SudokuParser();
        Sudoku sudoku = new Sudoku(sudokuParser.createSudoku(FOURINCOMPLETEACCEPTANCE)) ;
        sudoku.Solve() ;
        assertThat(SudokuValidity.isValid(sudoku.solution)).isEqualTo(true) ;


    }

    @org.junit.Test
    public void simple_four()
    {
        SudokuParser sudokuParser = new SudokuParser();
        Sudoku sudoku = new Sudoku(sudokuParser.createSudoku(FOURINCOMPLETE)) ;
        sudoku.Solve() ;
        assertThat(SudokuValidity.isValid(sudoku.solution)).isEqualTo(true) ;
    }


    @org.junit.Test
    public void simple_nine()
    {
        SudokuParser sudokuParser = new SudokuParser();
        Sudoku sudoku = new Sudoku(sudokuParser.createSudoku(NINEINCOMEPLE)) ;
        sudoku.Solve() ;
        assertThat(SudokuValidity.isValid(sudoku.solution)).isEqualTo(true) ;
    }



}
