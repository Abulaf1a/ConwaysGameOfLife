import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConwayLifeTest {

    //I used https://playgameoflife.com/ to create test expected outputs.

    @Test
    @DisplayName("Test single generation with simple glider")
    void test_getGeneration_singleGeneration(){
        //Arrange
        //simple glider:
        int[][] inputCells = {

                {0,1,0},
                {0,0,1},
                {1,1,1}
        };

        int[][] expectedOutput = {
                {1,0,1},
                {0,1,1},
                {0,1,0}
        };

        //Act
        int[][] actualOutput = ConwayLife.getGeneration(inputCells, 1);

        //Assert
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("Same as previous test but with added border of cells, making the input 5x5 instead of 3x3" +
            "The algorithm adds in a border to enable calculation of neighbours on edges")
    void test_getGeneration_extraInputBorder(){
        //Arrange
        //simple glider:
        int[][] inputCells = {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,0},
                {0,1,1,1,0},
                {0,0,0,0,0}
        };

        int[][] expectedOutput = {
                {1,0,1},
                {0,1,1},
                {0,1,0}
        };

        //Act
        int[][] actualOutput = ConwayLife.getGeneration(inputCells, 1);

        //Assert
        assertArrayEquals(expectedOutput, actualOutput);

    }

    @Test
    @DisplayName("Test two generation with simple glider")
    void test_getGenerations_twoGenerations(){
        //Arrange
        int[][] inputCells = {
                {0,1,0},
                {0,0,1},
                {1,1,1}
        };

        int[][] expectedOutput = {
                {0,0,1},
                {1,0,1},
                {0,1,1}
        };

        //Act
        int[][] actualOutput = ConwayLife.getGeneration(inputCells, 2);

        //Assert
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("Test two generation with simple glider")
    void test_getGeneration_threeGenerations(){
        //Arrange
        int[][] inputCells = {
                {0,1,0},
                {0,0,1},
                {1,1,1}
        };

        int[][] expectedOutput = {
                {1,0,0},
                {0,1,1},
                {1,1,0}
        };

        //Act
        int[][] actualOutput = ConwayLife.getGeneration(inputCells, 3);

        //Assert
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("Test three generations with more complex lattice")
    void test_getGeneration_largerShape(){
        //Arrange
        int[][] inputCells = {
                {0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0},
                {0,0,1,0,1,0,1,0,0},
                {0,1,0,1,0,1,0,1,0},
                {0,0,1,0,1,0,1,0,0},
                {0,0,0,1,0,1,0,0,0},
                {0,0,0,0,1,0,0,0,0},
        };

        int[][] expectedOutput = {
                {0,0,1,1,1,0,0},
                {0,0,1,1,1,0,0},
                {1,1,0,1,0,1,1},
                {1,1,1,0,1,1,1},
                {1,1,0,1,0,1,1},
                {0,0,1,1,1,0,0},
                {0,0,1,1,1,0,0},
        };

        //Act
        int[][] actualOutput = ConwayLife.getGeneration(inputCells, 3);

        //Assert
        assertArrayEquals(expectedOutput, actualOutput);
    }
}