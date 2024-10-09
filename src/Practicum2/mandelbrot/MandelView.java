package Practicum2.mandelbrot;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MandelView extends Frame {

    public static void main(String[] args) {
        new MandelView();
    }

    MandelView() {


        super("Mandelbrot");
        addWindowListener(new WindowAdapter()
        {public void windowClosing(WindowEvent e) {System.exit(0);}});
        super.setResizable(false);
        super.setSize(1000, 1000);
        super.setBackground(Color.black);
        add("Center", new CvMandelView());
        show();

    }

    class CvMandelView extends Canvas {

        int maxX, maxY;

        void initgr() {
            Dimension d = getSize();
            maxX = d.width - 1; maxY = d.height - 1;
        }

        public void paint(Graphics g) {

            initgr();
            Mandelbrot m = new Mandelbrot(maxX, maxY, -0.5, 0.0, 0.002, 500);
            int[] pixels = m.getPixels();

            for (int i = 0; i < maxX; i++) {
                for (int j = 0; j < maxY; j++) {

                    g.setColor(getColor(pixels[j * maxX + i]));
                    g.drawLine(i, j, i, j);
                }
            }

            System.exit(0);
        }

        public Color getColor(int k) {

            int maxIterations = 32;


            if (k > maxIterations) {
                return Color.black;
            }
            else {
                int color;
                Color colorRange;

                if (k < maxIterations / 4)
                    colorRange = Color.red;
                else if (k < maxIterations / 2)
                    colorRange = Color.green;
                else if (k < (3*maxIterations)/4)
                    colorRange = Color.blue;
                else
                    colorRange = Color.yellow;

                color = (255 * k) / maxIterations;

                if (colorRange == Color.red) {
                    color *= 3;
                    color = setIntBounds(color, 0, 255);
                    return new Color(color, 0, 0);
                }
                else if (colorRange == Color.green) {
                    color = (color - 64) * 4;
                    color = setIntBounds(color, 0, 255);
                    return new Color(0, color, 0);
                }
                else if (colorRange == Color.blue) {
                    color = (color - 128) * 4;
                    color = setIntBounds(color, 0, 255);
                    return new Color(0, 0, color);
                }
                else {
                    color = (color - 192) * 4;
                    color = setIntBounds(color, 0, 255);
                    return new Color(color, color, 0);
                }
            }
        }

        private int setIntBounds( int iValue, int iMin, int iMax) {

            if (iValue < iMin)
                return iMin;
            else if (iValue > iMax)
                return iMax;
            else
                return iValue;
        }
    }
}
