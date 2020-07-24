import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;

public class Curve {

    ArrayList<Integer> xCoords;
    ArrayList<Integer> yCoords;

    static double factor = 0.1;

    //blank curve
    public Curve() {
        xCoords = new ArrayList<>();
        yCoords = new ArrayList<>();
    }

    //Initial curve definition
    public Curve(int x, int y, int x2, int y2) {
        xCoords = new ArrayList<>();
        yCoords = new ArrayList<>();


        xCoords.add(x);
        xCoords.add(x2);
        yCoords.add(y);
        yCoords.add(y2);
    }

    //recursive case
    public Curve(Curve curve) {
        xCoords = new ArrayList<>();
        yCoords = new ArrayList<>();




        for(int i = 0; i < curve.xCoords.size(); i++) {
            this.xCoords.add(curve.xCoords.get(i));
        }
        for(int i = 0; i < curve.yCoords.size(); i++) {
            this.yCoords.add(curve.yCoords.get(i));
        }

    }

    public void iterate() {
        int newX;
        int newY;
        int refX;
        int refY;
        int originX = xCoords.get(xCoords.size() - 1);
        int originY = yCoords.get(yCoords.size() - 1);
        Curve tempCurve = new Curve();

        for(int i = xCoords.size() - 1; i >= 0; i--) {
         tempCurve.xCoords.add(xCoords.get(i));
         tempCurve.yCoords.add(yCoords.get(i));
        }



        for (int i = 1; i < tempCurve.xCoords.size(); i++) {
            refX = xCoords.get(i);
            refY = yCoords.get(i);

            newX = (int) Math.round(refX * Math.cos(factor*Math.PI) - refY * Math.sin(factor*Math.PI));

            newY = (int) Math.round(refX * Math.sin(factor*Math.PI) + refY * Math.cos(factor*Math.PI));

            this.xCoords.add((newX + originX));
            this.yCoords.add((newY + originY));
        }

    }

}
