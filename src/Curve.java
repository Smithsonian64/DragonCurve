import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;

public class Curve {

    ArrayList<Integer> xCoords;
    ArrayList<Integer> yCoords;

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

        int originX;
        int originY;

        originX = xCoords.get(xCoords.size() - 1);
        originY = yCoords.get(yCoords.size() - 1);

        System.out.print(originX + ", ");
        System.out.println(originY);

        int adjustedX;
        int adjustedY;

        int size = xCoords.size();

        if(xCoords.size() > 0 && yCoords.size() > 0) {
            for (int i = 0; i < size; i++) {
                adjustedX = xCoords.get(i) - originX;
                adjustedY = yCoords.get(i) - originY;
                int newX = (int) Math.round(adjustedX * Math.cos(Math.PI / 2) - adjustedY * Math.sin(Math.PI / 2));
                int newY = (int) Math.round(adjustedY * Math.cos(Math.PI / 2) + adjustedX * Math.sin(Math.PI / 2));
                xCoords.add(newX + originX);
                yCoords.add(newY + originY);
            }
        }
    }

}
