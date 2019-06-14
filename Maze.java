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
    for(int x = 1; x < this.mazeHeight + 1; x++){
      for(int y = 1; y < this.mazeWidth + 1; y++){
        mazeData[x][y] = 0;
      }
    }

    //On the edges, put walls to make sure that we never leave the maze
    buildWalls();

    //Put start and end points
    mazeData[mazeStartY + 1][mazeStartX + 1] = 2;
    mazeData[mazeEndY + 1][mazeEndX + 1] = 3;
  }

  public Maze(int[][] mazeToUse){
    this.mazeHeight = mazeToUse.length;
    this.mazeWidth = mazeToUse[0].length;

    mazeData = new int[mazeHeight + 2][mazeWidth + 2];

    //On the edges, put walls to make sure that we never leave the maze
    buildWalls();

    for(int x = 0; x < mazeHeight; x++){
      for(int y = 0; y < mazeWidth; y++){
        if(mazeToUse[x][y] == 2){
          mazeStartX = x;
          mazeStartY = y;
        } else if(mazeToUse[x][y] == 3){
          mazeEndX = x;
          mazeEndY = y;
        }

        this.mazeData[x + 1][y + 1] = mazeToUse[x][y];
      }
    }
  }

  private void buildWalls(){
    //On the edges, put walls to make sure that we never leave the maze
    for(int x = 0; x < this.mazeHeight + 2; x++){
      mazeData[x][0] = 1;
      mazeData[x][this.mazeWidth + 1] = 1;
    }

    for(int x = 0; x < this.mazeWidth + 2; x++){
      mazeData[0][x] = 1;
      mazeData[this.mazeWidth + 1][x] = 1;
    }
  }

  private ArrayList<Integer[]> solveMaze(int currentPlaceX, int currentPlaceY, AraryList<Integer[]> currentPath){
    for(int toCheckX = -1; toCheckX < 2; toCheckX+=2){
      if(mazeData[currentPlaceX + toCheckX][currentPlaceY] == 3){
        int[] temp = {currentPlaceX + toCheckX}{currentPlaceY};
        return currentPath.add(temp);
      }
      else if(mazeData[currentPlaceX + toCheckX][currentPlaceY] == 1){
        return new ArrayList<Integer>();
      }
      else {
        int[] temp = {currentPlaceX + toCheckX}{currentPlaceY};
        return currentPath.addAll(solveMaze(currentPlaceX + toCheckX, currentPlaceY, currentPath))
      }
    }
  }

  public String toString(){
    String retString = "";
    retString += "Legend:\nSpaces are passable\n█ =  impassable tiles\n@ = Starting point\n% = Ending point\n";
    for(int x = 0; x < this.mazeHeight + 2; x++){
      for(int y = 0; y < this.mazeWidth + 2; y++){
        switch(this.mazeData[x][y]){
          case 0:
            retString += " ";
            break;
          case 1:
            retString +="█";
            break;
          case 2:
            retString +="@";
            break;
          case 3:
            retString +="%";
            break;
          default:
            retString +="";
            break;
        }
      }
      retString += "\n";
    }

    return retString;
  }

}
