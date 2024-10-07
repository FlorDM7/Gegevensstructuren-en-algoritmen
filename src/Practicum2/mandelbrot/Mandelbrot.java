package Practicum2.mandelbrot;

/**
 * A <code> Mandelbrot</code> object defines a Mandelbrot set fractal
 * on the complex plane.
 */

public class Mandelbrot {

    /** Width and Height of the viewport */
    private int width, height;
    /** Data array */
    private int pixel[];

    /** Real starting point in the complex plane */
    double xstart;
    /** Imaginary starting point in the complex plane */
    double ystart;
    /** Gap distance between sample points */
    double gap;
    /** Maximum number of times to iterate for each sample point */
    int max_iterations;

    /** The complex numbers z and c */
    ComplexNumber z, c;


    /**
     * Creates a new <code>Mandelbrot</code> object.
     *
     * @param width  The Width of the output array.
     * @param height The Height of the output array.
     * @param x_center The real coordinate center of the output array.
     * @param y_center The imaginary coordinate center of the output array.
     * @param gap The distance between sample points on the complex plane.
     * @param max_iterations The maximum number of times to iterate for each sample point.
     * @see #getPixels()
     */
    public Mandelbrot(int width, int height,
                      double x_center, double y_center, double gap,
                      int max_iterations) {

        this.width = width; this.height = height;

        this.gap = gap;

        xstart = x_center - ((width/2)*gap);
        ystart = y_center - ((height/2)*gap);

        this.max_iterations = max_iterations;

        pixel = new int[width * height];

    }


    /**
     * @effects Computes pixel values with the following algorithm: for each pixel c,
     * start with z = 0. Repeat z <- z^2 + c up to <code>max_iterations</code>
     * times, exiting if the magnitude of z is more than 2. The number of
     * iterations completed for each complex sample point is the value
     * returned in the array.
     *
     * @return An array of iteration values for the complex sample points.
     */

    public int[] getPixels() {

        long start = System.currentTimeMillis();

        // create objects outside the loops
        c = new ComplexNumber(0.0,0.0);
        z = new ComplexNumber(0.0,0.0);

        // for every pixel in the array
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                // edit the already exiting objects
                c.setReal(xstart + i * gap);
                c.setImaginary(ystart + j * gap);
                z.setReal(0.0);
                z.setImaginary(0.0);

                int k = 0;

                // compute a value
                while (z.getMagnitude() < 2.0 && k < max_iterations) {
                    // z <- z^2 + c
                    z.mult(z); // no new object is created
                    z.add(c);
                    k++;
                }
                pixel[j * width + i] = k;
            }
        }

        System.out.println("Tijd = "+(System.currentTimeMillis()-start));

        return pixel;
    }

    /*
    Original function
    public int[] getPixels() {

        long start = System.currentTimeMillis();

        // for every pixel in the array
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                c = new ComplexNumber(xstart + i * gap, ystart + j * gap);
                z = new ComplexNumber(0.0, 0.0);
                int k = 0;

                // compute a value
                while (z.getMagnitude() < 2.0 && k < max_iterations) {
                    // z <- z^2 + c
                    z = z.mult(z);
                    z = z.add(c);
                    k++;
                }
                pixel[j * width + i] = k;
            }
        }

        System.out.println("Tijd = "+(System.currentTimeMillis()-start));


        return pixel;
    }
     */
}
