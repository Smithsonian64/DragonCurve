import javax.swing.*;
import java.awt.*;

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
    }

}

