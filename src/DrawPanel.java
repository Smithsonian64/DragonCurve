import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawPanel extends JPanel {

    BufferedImage drawImage;

    Window window;

    Curve currentCurve;

    int n;

    public DrawPanel(int width, int height, Window window) {

        n = 1;
        drawImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        currentCurve = new Curve(0, 0, 25, 0);

        /*for(int i = 0; i < n; i++) {
            currentCurve = new Curve(currentCurve);
        }*/





        this.window = window;
        draw();
        repaint();




    }



    @Override
    public void paint(Graphics g) {
        g.drawImage(drawImage, 0, 0, null);
    }

    public void draw() {
        drawImage = new BufferedImage(drawImage.getWidth(), drawImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = drawImage.createGraphics();
        g2d.setColor(Color.YELLOW);


        for(int i = 0; i < currentCurve.xCoords.size() - 1; i++) {
            g2d.drawLine(currentCurve.xCoords.get(i) + window.width/2, currentCurve.yCoords.get(i) + window.height/2, currentCurve.xCoords.get(i + 1) + window.width/2, currentCurve.yCoords.get(i + 1) + window.height/2);
            System.out.println("X: " + currentCurve.xCoords.get(i) + ", Y: " + currentCurve.yCoords.get(i));
        }

            System.out.println("X: " + currentCurve.xCoords.get(currentCurve.xCoords.size() - 1) + ", Y: " + currentCurve.yCoords.get(currentCurve.yCoords.size() - 1));
        System.out.println();

    }



}
