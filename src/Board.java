
//Connect4 board and the game logic

//imports necessary for this class
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//class definition
class Board extends Pane {

    private int winner_check = 0;

    //private fields of the class
    private int boardWidth = 8;
    private int boardHeight = 8;		// the height of the Connect4 board
    private int[][] board; 				// 2D array that holds  int values representing the pieces
    private Piece[][] pieces; 			// 2D array that holds the renders of the pieces
    private Window[][] windows; 		// 2D array that holds all the windows (white circles) for the board
    private Rectangle background; 		// background of the board
    private double cell_width;			// width of a cell in the board
    private double cell_height; 		// height of a cell in the board
    private int current_player; 		// hold the value of the current player (PlayerRed or Player Yellow)

    // constants to be inserted into the 2D board array to keep track of the location of cells containing
    // empty, red and yellow pieces
    private final int EMPTY = 0;
    private final int PlayerRed = 1;	// 1 is used to indicate that a cell in the board is occupied by a red piece
    private final int PlayerYellow = 2; // 2 is used to indicate that a cell in the board is occupied by a yellow piece

    int winner = 0;						// variable to determine who the current winner is: 0 - no current winner,
    // 1 - red is the current winner, 2 - yellow is the current winner

    // constructor for the class
    public Board() {
        // initialize the background of the board and add it to the board
        background = new Rectangle();
        background.setFill(Color.BLUE);
        getChildren().add(background);

        // initialize board array to the correct size
        board = new int[boardWidth][boardHeight];

        // initialize pieces array to the correct size
        pieces = new Piece[boardWidth][boardHeight];

        // initialize windows array to the correct size
        windows = new Window[boardWidth][boardHeight];

        // for loop to populate all arrays to default values and add the windows to the board
        for(int i = 0; i < boardWidth; i++){
            for(int j = 0; j < boardHeight; j++) {
                board[i][j] = EMPTY;
                windows[i][j] = new Window(i, j);
                windows[i][j].resize(cell_width, cell_height);
                windows[i][j].relocate(i * cell_width, j * cell_height);
                getChildren().add(windows[i][j]);
                pieces[i][j] = null;


            }
        }
        placePiece(1);
        // set the current player to red
        current_player = PlayerRed;
    }

    // override resize method to ensure board appears correctly
    @Override
    public void resize(double width, double height) {
        //call the superclass resize method
        super.resize(width, height);

        // resize the rectangle to take the full size of the widget
        background.setWidth(width); background.setHeight(height);

        // calculate the width and height of a cell in which a windows and a piece will sit
        cell_width = width / 8; cell_height = height / 8;

        // nested for loop to reset the sizes and positions of all pieces that were already placed
        for(int i = 0; i < boardWidth; i++) {
            for(int j = 0; j < boardHeight; j++) {
                if(board[i][j] != EMPTY) {
                    pieces[i][j].relocate(i * cell_width, j * cell_height);
                    pieces[i][j].resize(cell_width, cell_height);
                }
            }
        }

        // and update the position of the windows in the board
        for(int i = 0; i < boardWidth; i++) {
            for(int j = 0; j < boardHeight; j++) {
                windows[i][j].relocate(i * cell_width, j * cell_height);
                windows[i][j].resize(cell_width, cell_height);

            }
        }
    }

    // method for resetting the game
    public void resetGame() {
        System.out.println(pieces[1][6].t.getText());
        pieces[2][2] = pieces[1][6];
        System.out.println(pieces[1][5]);
        System.out.println(pieces[0][1].toString());
        System.out.println(pieces[2][2].t.getText());
//        for(int i = 0; i < boardWidth; i++) {
//            for(int j = 0; j < boardHeight; j++) {
//                board[i][j] = 0;
//                getChildren().remove(pieces[i][j]);
//                pieces[i][j] = null;
//            }
//        }
    }

    // method that tries to place a piece in the board
    public void placePiece(final double x) {
        int row = 0;
        int rowHeight = boardHeight;
        // calculate what column the piece should be placed in
        int indexx = (int) (x / cell_width);
        // for loop to find the next available row in that column
        for(int i = 0; i < boardHeight; i++ ){
            if(board[i][1] == EMPTY){
                row = 1;
                pieces[i][row] = new Piece(1);
                pieces[i][row].relocate(indexx * cell_width, row * cell_height);
                pieces[i][row].resize(cell_width, cell_height);
                board[i][row] = PlayerRed;
                getChildren().add(pieces[i][row]);
            }
        }

        for(int i = 0; i < boardHeight; i++ ){
            if(board[i][6] == EMPTY){
                row = 6;
                pieces[i][row] = new Piece(2);
                pieces[i][row].relocate(indexx * cell_width, row * cell_height);
                pieces[i][row].resize(cell_width, cell_height);
                board[i][row] = PlayerYellow;
                getChildren().add(pieces[i][row]);
            }
        }
        // if the available row is less than the height of the board proceed
//        if(rowHeight < boardHeight && current_player == PlayerRed){
//			/* if the current player is red
//			   put the int value corresponding to the red piece in the relevant position in the board array
//			   put a red piece in the relevant position in the pieces array and resize and relocate the piece
//			   add the piece to the board
//			   change the current player to yellow
//			 */
//            pieces[indexx][row] = new Piece(1);
//            pieces[indexx][row].relocate(indexx * cell_width, row * cell_height);
//            pieces[indexx][row].resize(cell_width, cell_height);
//            board[indexx][row] = PlayerRed;
//            getChildren().add(pieces[indexx][row]);
//            current_player = PlayerYellow;
//            winner_check = PlayerRed;
//        }
//        else if(rowHeight < boardHeight && current_player == PlayerYellow) {
//			/* else if current player is yellow
//			   put the int value corresponding to the yellow piece in the relevant position in the board array
//			   put a yellow piece in the relevant position in the pieces array and resize and relocate the piece
//			   add the piece to the board
//			   change the current player to red
//			 */
//            pieces[indexx][row] = new Piece(2);
//            pieces[indexx][row].relocate(indexx * cell_width, row * cell_height);
//            pieces[indexx][row].resize(cell_width, cell_height);
//            board[indexx][row] = PlayerYellow;
//            getChildren().add(pieces[indexx][row]);
//            current_player = PlayerRed;
//            winner_check = PlayerYellow;
//        }
//        // call the winner method to see if there is a winner
//        winner(indexx, row);
    }

    /* method to determine who the current winner is and display a message (additional variable and/or
       updates to the layout may be required) - this method should only be attempted on completion of
       the other steps
     */
    public int winner(int col , int row){
        int win_counter = 1;
        //all checks are specifically for 4, although its possible to win on greater the game will not stop you from placing pieces
        //i left it at 4 to show check works perfectly
        //check for vertical winner
        if(((win_counter + pieceCount(col, row, 0, 1) + pieceCount(col, row, 0, -1)) == 4)
                //check for horizontal winner
                || ((win_counter + pieceCount(col, row, 1, 0) + pieceCount(col, row, -1, 0)) == 4)
                //check for diagonal winner \
                || ((win_counter + pieceCount(col, row, 1, 1) + pieceCount(col, row, -1, -1)) == 4)
                //check for diagonal winner /
                || ((win_counter + pieceCount(col, row, -1, 1) + pieceCount(col, row, 1, -1)) == 4)) {
            //will display winner in console
            if(winner_check == 1) {
                System.out.println("=============================Red is the winner!====================================");
            }else {
                System.out.println("=============================Yellow is the winner!====================================");
            }
            winner = winner_check;
        }
        return winner;
    }

    //recursive function to determine if there is a winner
    public int pieceCount(int col, int row, int colInc, int rowInc) {
        //out of bounds check
        if(col + colInc >= boardWidth || col + colInc < 0 || row + rowInc >= boardHeight  || row + rowInc < 0) {
            return 0;
            //recursive: if there is an identical piece next to current piece
        }else if(board[col][row] == board[col + colInc][row + rowInc]) {
            return 1 + pieceCount(col + colInc, row + rowInc, colInc, rowInc);
            //return 0 if there is no identical piece
        }else{
            return 0;
        }
    }

}
