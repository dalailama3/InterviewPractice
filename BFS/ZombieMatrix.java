import java.util.*;
public class ZombieMatrix {
    public static int minHours(int rows, int cols, List<List<Integer>> grid) {

        // go through grid and add positions of zombies to a queue
        // hour 0 is initial state of queue
        //when each queue item has been processed, then increment hour count
        // update the grid as you are processing queue pops
        // you are done when the queue is empty
        final int[][] VECTORS = {
            {-1,0},{1,0},{0,-1},{0,1}
        };

        ArrayDeque<int[]> infections = new ArrayDeque<>();
        //initialize queue
        for (int i =0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid.get(i).get(j) == 1) {
                    int[] pos = new int[]{i,j};
                    infections.add(pos);
                }
            }
        }
//        Iterator<int[]> it = infections.iterator();
//        while (it.hasNext()) {
//            System.out.println(Arrays.toString(it.next()));
//        }
        int hours = 0;
        while (!infections.isEmpty()) {
            boolean infectedMore = false;
            //System.out.println(grid);
            int numZombies = infections.size();
            //System.out.println(numZombies + " to process....");
            while (numZombies > 0) {
                int[] zombiePos = infections.removeFirst();
                numZombies--;
                // add all positions that zombie infected to the queue
                for (int[] vector : VECTORS) {
                    // update position on grid if it is 0
                    int x = vector[0] + zombiePos[0];
                    int y = vector[1] + zombiePos[1];
                    //int[] newPos = [vector[0] + zombiePos[0],vector[1] + zombiePos[1]];
                    if (x >= 0 && x < rows && y >= 0 && y < cols) {
                        if (grid.get(x).get(y) == 0) {
                            //make grid cell a zombie
                            grid.get(x).set(y,1);
                            // add position to queue
                            infections.add(new int[]{x,y});
                            infectedMore = true;
                            // running into case in which grid is all zombies at this point but queue is not empty

                        }
                    }
                }
            }
            if (infectedMore) hours++;
        }
        return hours;


    }


    public static void main(String[] args) {
//        [[0, 1, 1, 0, 1],
//         [0, 1, 0, 1, 0],
//         [0, 0, 0, 0, 1],
//         [0, 1, 0, 0, 0]]
        List<List<Integer>> grid = new ArrayList<List<Integer>>();
        grid.add(Arrays.asList(0,1,1,0,1));
        grid.add(Arrays.asList(0,1,0,1,0));
        grid.add(Arrays.asList(0,0,0,0,1));
        grid.add(Arrays.asList(0,1,0,0,0));
        //System.out.println(grid);
        System.out.println(minHours(4,5,grid) == 2);
        grid.clear();

        grid.add(Arrays.asList(0,0,0,0,0,0));
        grid.add(Arrays.asList(0,0,0,0,0,0));
        grid.add(Arrays.asList(0,0,0,0,0,0));
        System.out.println(minHours(3,6,grid) == 0);

        grid.clear();
        grid.add(Arrays.asList(0,0,1,0,0,0));
        System.out.println(minHours(1,6,grid) == 3);

    }
}