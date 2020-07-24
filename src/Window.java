import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame {

    JPanel drawPanel;

    int width;
    int height;

    public Window(int width, int height) {

        this.width = width;
        this.height = height;

        DrawPanel drawPanel = new DrawPanel(width, height, this);

        this.add(drawPanel);

        this.setTitle("Dragon Curve");
        this.setSize(width, height);
        this.setLocation(   (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - width/2,
                            (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2 - height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyChar() == ' ') {
                    drawPanel.n++;
                    drawPanel.currentCurve.iterate();
                    System.out.println("number of points: " + drawPanel.currentCurve.xCoords.size());
                    drawPanel.draw();
                    repaint();
                    return;
                }

                if (e.getKeyChar() == 't') {
                    drawPanel.n++;
                    Curve.factor += 0.1;
                    System.out.println("number of points: " + drawPanel.currentCurve.xCoords.size());
                    drawPanel.draw();
                    repaint();
                    return;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }



}

