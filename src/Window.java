//Connect 4 window that appears in each cell in the board

//imports required for this class
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;

//class definition
class Window extends Group {

    // private fields of the class
    private Ellipse e; 			// ellipse for rendering this window
    private Rectangle r;
    private Translate pos; 		//translate to set the position of this window

    // constructor for the class
    public Window(int x, int y) {
        // make a new Ellipse and Translate, add the Translate to the Ellipse, add the Ellipse to the Group
        pos = new Translate();
        r = new Rectangle();
        if(((x + y) % 2) == 0) {
            r.setFill(Color.WHITE);
        }else {
            r.setFill(Color.BLACK);
        }
        getChildren().addAll(r);
        r.getTransforms().add(pos);

    }

    // overridden version of the resize method
    @Override
    public void resize(double width, double height) {
        // call the super class method and update the centre and radius of the ellipse representing the window
        super.resize(width, height);

        r.setWidth(width); r.setHeight(height);
//        e.setRadiusX(width / 2); e.setRadiusY(height / 2);
    }

    // overridden version of the relocate method
    @Override
    public void relocate(double x, double y) {
        // call the superclass method and update the relevant transform
        super.relocate(x, y);
        pos.setX(x); pos.setY(y);
    }


}
