public class Maze{
  private int mazeHeight;
  private int mazeWidth;
  private int mazeStartX;
  private int mazeStartY;
  private int mazeEndX;
  private int mazeEndY;

  /* Legend:
  0: Passable tile
  1: Impassable tile
  2: Starting tile
  3: Ending tile
  */
  private int[][] mazeData;

  public Maze(int mazeHeight, int mazeWidth, int mazeStartX, int mazeStartY, int mazeEndX, int mazeEndY){
    this.mazeHeight = mazeHeight;
    this.mazeWidth = mazeWidth;
    this.mazeStartX = mazeStartX;
    this.mazeStartY = mazeStartY;
    this.mazeEndX = mazeEndX;
    this.mazeEndY = mazeEndY;

    mazeData = new int[this.mazeHeight + 2][this.mazeWidth + 2];

    //Fill with empty space
    for(int x = 1; x < this.mazeHeight + 1; y++){
      for(int y = 1; y < this.mazeWidth + 1; y++){
        mazeData[x][y] = 0;
      }
    }

    //On the edges, put walls to make sure that we never leave the maze
    for(int x = 0; x < this.mazeHeight + 2; x++){
      mazeData[x][0] = 1;
      mazeData[x][this.mazeWidth + 1] = 1;
    }

    for(int x = 0; x < this.mazeWidth + 2; x++){
      mazeData[0][x] = 1;
      mazeData[this.mazeWidth + 1] = 1;
    }

    //Put start and end points
    mazeData[mazeStartY + 1][mazeStartX + 1] = 2;
    mazeData[mazeEndY + 1][mazeEndX + 1] = 3;
  }

  public String toString(){
    String retString;
    retString += "Legend:\n @ = Passable tiles\n Spaces are impassable tiles\n# = Starting point\n% = Ending point";
    for(int x = 0; x < this.mazeHeight + 2; x++){
      for(int y = 0; y < this.mazeWidth + 2; y++){
        switch(this.mazeData[x][y]){
          case 0:
            retString += "@";
          case 1:
            retString +=" ";
          case 2:
            retString +="#";
          case 3:
            retString +="%";
          default:
            retString +=" ";
        }
      }
      retString += "\n";
    }
  }

}
