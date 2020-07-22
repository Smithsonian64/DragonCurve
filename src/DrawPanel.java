import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawPanel extends JPanel {

    BufferedImage drawImage;

    Window window;

    Curve currentCurve;

    public DrawPanel(int width, int height, Window window) {

        drawImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        currentCurve = new Curve(window.width / 2, window.height / 2, window.width / 2 + 25, window.height / 2);
        currentCurve = new Curve(currentCurve);
        currentCurve = new Curve(currentCurve);
        currentCurve = new Curve(currentCurve);

        this.window = window;

    }

    @Override
    public void paint(Graphics g) {
        draw();
        g.drawImage(drawImage, 0, 0, null);
    }

    public void draw() {
        Graphics2D g2d = drawImage.createGraphics();
        g2d.setColor(Color.YELLOW);

        for(int i = 0; i < currentCurve.xCoords.size() - 1; i++) {
            g2d.drawLine(currentCurve.xCoords.get(i), currentCurve.yCoords.get(i), currentCurve.xCoords.get(i + 1), currentCurve.yCoords.get(i + 1));
        }

        //currentCurve = new Curve(currentCurve);
        repaint();
        //currentCurve = new Curve(currentCurve);
        repaint();
    }

}
