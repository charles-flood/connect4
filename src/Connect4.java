/**
 * Created by David on 28/11/2015.
 */
//Connect 4 application

//imports
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//class definition
public class Connect4 extends Application {

    // private fields for this class
    private StackPane sp_mainlayout;	//layout which allows items to be positioned on top of each other
    private CustomControl cc_custom;	//control which has a board and detects mouse and keyboard events

    // overridden init method
    @Override
    public void init() {
        // initialize the layout, create a CustomControl and it to the layout
        sp_mainlayout = new StackPane();
        cc_custom = new CustomControl();
        sp_mainlayout.getChildren().add(cc_custom);
        //sp_mainlayout.setPadding(new Insets(40, 10, 10, 10));
    }
    // overridden start method
    @Override
    public void start(Stage primaryStage) {
        // set the title and scene, and show the stage
        primaryStage.setTitle("Connect 4 Charles Flood 2857004");
        primaryStage.setScene(new Scene(sp_mainlayout, 800, 800));
        primaryStage.show();

    }

    // overridden stop method
    @Override
    public void stop() {
    }

    // entry point into our program to launch our JavaFX application
    public static void main(String[] args) {
        launch(args);
    }

}

