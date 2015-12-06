import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by tarekray on 05/12/15.
 */
public class TestValidity {

    @org.junit.Test
    public void testIsValidShouldBeFalseNineIncomplete()
    {
        SudokuParser sudokuParser = new SudokuParser();
        assertThat(SudokuValidity.isValid(sudokuParser.createSudoku(TestAlgorithm.NINEINCOMEPLE))).isEqualTo(false) ;

    }

    @org.junit.Test
    public void testIsValidShouldBeFalseFourIncomplete()
    {
        SudokuParser sudokuParser = new SudokuParser();

        assertThat(SudokuValidity.isValid(sudokuParser.createSudoku(TestAlgorithm.FOURINCOMPLETE))).isEqualTo(false) ;

    }

    @org.junit.Test
    public void testIsValidShouldBeFalseNineSquare()
    {
        SudokuParser sudokuParser = new SudokuParser();
        assertThat(SudokuValidity.isValidSquares(sudokuParser.createSudoku(TestAlgorithm.NINEWRONG))).isEqualTo(false) ;


    }

    @org.junit.Test
    public void testIsValidShouldBeFalseFourSquare()
    {
        SudokuParser sudokuParser = new SudokuParser();

        assertThat(SudokuValidity.isValidSquares(sudokuParser.createSudoku(TestAlgorithm.FOURWRONG))).isEqualTo(false) ;


    }


    @org.junit.Test
    public void testIsValidShouldBeFalseNineColumn()
    {
        SudokuParser sudokuParser = new SudokuParser();

        assertThat(SudokuValidity.isValidColumns(sudokuParser.createSudoku(TestAlgorithm.NINEWRONG))).isEqualTo(false) ;

    }

    @org.junit.Test
    public void testIsValidShouldBeFalseFourColumn()
    {
        SudokuParser sudokuParser = new SudokuParser();

        assertThat(SudokuValidity.isValidColumns(sudokuParser.createSudoku(TestAlgorithm.FOURWRONG))).isEqualTo(false) ;


    }


    @org.junit.Test
    public void testIsValidShouldBeFalseNineRow()
    {
        SudokuParser sudokuParser = new SudokuParser();

        assertThat(SudokuValidity.isValidRows(sudokuParser.createSudoku(TestAlgorithm.NINEWRONG))).isEqualTo(false) ;


    }

    @org.junit.Test
    public void testIsValidShouldBeFalseFourRow()
    {
        SudokuParser sudokuParser = new SudokuParser();

        assertThat(SudokuValidity.isValidRows(sudokuParser.createSudoku(TestAlgorithm.FOURWRONG))).isEqualTo(false) ;


    }

    @org.junit.Test
    public void testIsValidShouldBeTrueNine()
    {
        SudokuParser sudokuParser = new SudokuParser();

        assertThat(SudokuValidity.isValid(sudokuParser.createSudoku(TestAlgorithm.NINECORRECT))).isEqualTo(true) ;

    }

    @org.junit.Test
    public void testIsValidShouldBeTrueFour()
    {
        SudokuParser sudokuParser = new SudokuParser();

        assertThat(SudokuValidity.isValid(sudokuParser.createSudoku(TestAlgorithm.FOURCORRECT))).isEqualTo(true) ;

    }


}
