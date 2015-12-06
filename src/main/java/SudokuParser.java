import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tarekray on 04/12/15.
 */
public class SudokuParser {
    public  int[][] createSudoku(String textFile) {


        String filePath = getClass().getResource(textFile).getPath();
        File file = new File(filePath);

       int sudokuSize =  getSudokuSize(file);
        int[][] grid = new int[sudokuSize][sudokuSize] ;

        fillGrid(file, grid);

        return grid;
    }

    private static void fillGrid(File file, int[][] grid) {
        try {
            AtomicInteger counter = new AtomicInteger(0);

            Files.lines(file.toPath()).forEach(line -> {
                String[] split = line.split(" ");
                for (int i = 0 ; i < split.length ; i++) {
                    grid[counter.intValue()][i] = Integer.parseInt(split[i]) ;
                }

                counter.incrementAndGet() ;
            });

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static int getSudokuSize(File file) {
        AtomicInteger counter = new AtomicInteger(0);
        try {

            Files.lines(file.toPath()).forEach(line -> {
                String[] split = line.split(" ");
                counter.set(split.length) ;

            });

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  counter.intValue() ;
    }
}
