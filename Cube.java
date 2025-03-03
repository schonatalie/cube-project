public class Cube {

    static String[][] Cube =  {
                            {null, null, null, "w", "w", "w"}, //up face white
                            {null, null, null, "w", "w", "w"}, 
                            {null, null, null, "w", "w", "w"},
                                {"o", "o", "o", "b", "b", "b", "r", "r", "r"}, //left face orange
                                {"o", "o", "o", "b", "b", "b", "r", "r", "r"}, //front face blue
                                {"o", "o", "o", "b", "b", "b", "r", "r", "r"}, //right face red
                            {null, null, null, "g", "g", "g"}, //back face green
                            {null, null, null, "g", "g", "g"},
                            {null, null, null, "g", "g", "g"},
                            {null, null, null, "y", "y", "y"}, //down face yellow
                            {null, null, null, "y", "y", "y"},
                            {null, null, null, "y", "y", "y"},
                            };


                //try both this layout & other to find best way to do faces and rotate
                //extra credit to scamble the cube
        
        public static void printCube() {

        for (int i = 0; i < Cube.length; i++) {
            for (int j = 0; j < Cube[i].length; j++) {
                String cell = Cube[i][j];                    
                System.out.print((cell == null ? " " : cell) + " ");
            }
            System.out.println();
        } //this for loop just prints the array out so i can see it :)

    } 

    public static void rotateclockwise(int row_i, int col_i) {
        //rotates blocks at the corners
        String temp = Cube[row_i][col_i];
        Cube[row_i][col_i] = Cube[row_i + 2][col_i];
        Cube[row_i + 2][col_i] = Cube[row_i + 2][col_i];
        Cube[row_i + 2][col_i + 2] = Cube[row_i + 2][col_i + 2];
        Cube[row_i][col_i + 2] = temp;

        //rotates blockes on edges
        temp = Cube[row_i][col_i + 1];
        Cube[row_i][col_i + 1] = Cube[row_i + 1][col_i];
        Cube[row_i + 1][col_i] = Cube[row_i + 2][col_i + 1];
        Cube[row_i + 2][col_i + 1] = Cube[row_i + 1][col_i + 2];
        Cube[row_i + 1][col_i + 2] = temp;
    }

    public static void roatecounter(int row_i, int col_i) {
        rotateclockwise(row_i, col_i);
        rotateclockwise(row_i, col_i);
        rotateclockwise(row_i, col_i);        
    }


    public static void moveU(){
        rotateclockwise(0,3);
    }

    public static void moveUprime(){
        roatecounter(0,3);
    }




    //switch for the different moves
    public static void playMove(String move) {
        switch (move) {
            case "U":   moveU();       break;
            case "U'":  moveUprime();  break;
            // case "L":   moveL();       break;
            // case "L'":  moveLPrime();  break;
            // case "F":   moveF();       break;
            // case "F'":  moveFPrime();  break;
            // case "R":   moveR();       break;
            // case "R'":  moveRPrime();  break;
            // case "B":   moveB();       break;
            // case "B'":  moveBPrime();  break;
            // case "D":   moveD();       break;
            // case "D'":  moveDPrime();  break;
            default:
                System.out.println("Invalid move: " + move);
        }
    }

    public static void main(String[] args) {
        
    // default state
    System.out.println("Cube's Current State: ");
    printCube();

    // U move -- Up face rotates clockwise
    System.out.println("\nU move:");
    playMove("U");
    printCube();

    // U' move -- Up face rotates counter-clockwise
    System.out.println("\nU' move:");
    playMove("U'");
    printCube();
    }

}
