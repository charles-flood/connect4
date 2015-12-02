import java.time.Duration;

import javafx.animation.TranslateTransition;

//Connect 4 piece 

//imports 
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Translate;


//class definition 
class Piece extends Group {

    //private fields of the class
    private Ellipse e; 		//ellipse for rendering this piece
    Text t;
    private int type; 		//maintain a copy of the piece type (red or yellow) we have
    private Translate pos; 	//translate to set the position of this piece


    // constructor for the class
    public Piece(int type) {
        // store the type, make a new Ellipse and Translate, add the Translate to the Ellipse, add the Ellipse to the Group
        t = new Text();
        pos = new Translate();
        this.type = type;

        getChildren().addAll(t);
        t.getTransforms().add(pos);
        t.setFont(Font.font(50));
        t.setTextAlignment(TextAlignment.CENTER);
        if(type == 1){
            t.setText("PB");
            t.setFill(Color.BLACK);
            t.setStroke(Color.WHITE);
        }else {
            t.setText("PW");
            t.setFill(Color.WHITE);
            t.setStroke(Color.BLACK);
        }



    }

    // overridden version of the resize method which resizes the piece
    @Override
    public void resize(double width, double height) {
        // call the super class method and update the centre and radius of the ellipse representing the piece
        super.resize(width, height);
        t.setX(width); t.setY(height);
//        e.setCenterX(width / 2); e.setCenterY(height / 2);
//        e.setRadiusX(width / 2); e.setRadiusY(height / 2);
    }

    //overridden version of the relocate method
    @Override
    public void relocate(double x, double y) {
        // call the superclass method and update the relevant transform
        super.relocate(x, y);
        pos.setX(x + 10); pos.setY(y);
    }


}