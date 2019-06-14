public class main{

  public static void main(String[] args){

    int[][] testMazeData = {
      {2,1,0,0,0,0,0,0,0},
      {0,1,1,1,1,1,0,1,0},
      {0,0,0,1,0,0,0,1,0},
      {1,1,0,1,0,1,1,1,0},
      {0,0,0,1,0,0,0,1,0},
      {0,1,1,1,1,1,0,1,0},
      {0,1,0,0,0,1,0,1,0},
      {0,1,0,1,0,1,0,1,0},
      {0,0,0,1,0,0,0,1,3}
    };

    Maze testMaze = new Maze(testMazeData);

    System.out.println(testMaze);
  }
}
