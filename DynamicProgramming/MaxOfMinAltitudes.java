//Given a matrix with r rows and c columns, find the maximum score of a path starting at [0, 0] and ending at [r-1, c-1].
// The score of a path is the minimum value in that path. For example, the score of the path 8 → 4 → 5 → 9 is 4.
//
//        Don't include the first or final entry. You can only move either down or right at any point in time.
//Input:
//        [[1, 2, 3]
//        [4, 5, 1]]
//
//        Output: 4
//        Explanation:
//        Possible paths:
//        1-> 2 -> 3 -> 1
//        1-> 2 -> 5 -> 1
//        1-> 4 -> 5 -> 1
//        So min of all the paths = [2, 2, 4]. Note that we don't include the first and final entry.
//        Return the max of that, so 4.
public class MaxOfMinAltitudes {

    public static int MaxOfMinAltitudes(int[][] grid) {
        //set first row
        //assumes grid has 3 columns
        for (int j = 2; j < grid[0].length; ++j) {
            grid[0][j] = Math.min(grid[0][j], grid[0][j-1]);
        }

        for (int i = 2; i < grid.length; ++i) {
            grid[i][0] = Math.min(grid[i][0], grid[i-1][0]);
        }

        for (int i = 1; i < grid.length; ++i) {
            for (int j = 1; j < grid[0].length; ++j) {
                int gridVal = grid[i][j];
                if (gridVal < grid[i-1][j] && gridVal < grid[i][j-1] && i != grid.length -1 && j != grid[grid.length-1].length-1) {
                    continue;
                } else {
                    grid[i][j] = Math.max(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,2,3},{4,5,1}
        };
        System.out.println(MaxOfMinAltitudes(grid));

        int[][] grid2 = new int[][] {
                {3,6,1,4,2},{7,3,2,4,1},{1,2,3,4,5}
        };
        System.out.println(MaxOfMinAltitudes(grid2));

    }

}