
    public class ConwayLife {

        public static void main(String[] args) {


        }

        public static int[][] getGeneration(int[][] cells, int generations) {
            int[][] cellsExpanded = new int[cells.length+4][cells[0].length+4];//cellsExpanded = cellsExpanded create a new array with a border of 1 all around, to enable edge neighbourhood checking without indexing out of range
            for(int i = 0; i < cells.length; i++){
                for(int j = 0; j < cells[i].length; j++){
                    cellsExpanded[i+2][j+2] = cells[i][j];
                }
            }
            int[][] nextGen = new int[cellsExpanded.length][cellsExpanded[0].length]; //create a second empty array to be written to to create next generation.
            if(generations == 0) return cells;
            int count;
            for(int i = 1; i < cellsExpanded.length-1; i++){
                for(int j = 1; j < cellsExpanded[i].length-1; j++){
                    count = 0; //reset count
                    if(cellsExpanded[i][j] == 1) count--; //remove 1 from count if the cell itself is alive
                    for(int k = i-1; k < i+2 ; k++){ //count living cells around the cell
                        for(int l =  j-1; l < j +2; l++){
                            if(cellsExpanded[k][l] == 1){
                                count++;
                            }
                        }
                    }
                    nextGen[i][j] = cellsExpanded[i][j]; //set nextGen to cellsExpanded
                    if(count > 3 || count < 2) nextGen[i][j] = 0; //actual logic for making the game of life
                    else if(count == 3)  nextGen[i][j] = 1;
                }
            }

            int top = Integer.MAX_VALUE; //trim empty rows and columns from edge
            int left = Integer.MAX_VALUE;
            int bottom = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;
            for(int i = 0; i < nextGen.length; i++){
                for(int j = 0; j < nextGen[i].length; j++){
                    if(nextGen[i][j] == 1){
                        if(left > i) left = i;
                        if(i > right) right = i;
                        if(top > j) top = j;
                        if(j > bottom) bottom = j;
                    }
                }
            }

            if(top == 21474) return new int[0][0];
            int[][] output = new int[right - left + 1][bottom - top + 1];
            for(int i = left; i < right +1; i++){
                if (bottom + 1 - top >= 0)
                    System.arraycopy(nextGen[i], top, output[i - left], 0, bottom + 1 - top);
            }
            generations--;
            if(generations > 0) output = getGeneration(output, generations);
            return output;
        }
    }

