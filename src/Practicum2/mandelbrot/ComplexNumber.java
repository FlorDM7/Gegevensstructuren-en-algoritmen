package Practicum2.mandelbrot;

/**
 * A <code>ComplexNumber</code> object defines the real and
 * complex parts of a complex number a + bi.
 */

public class ComplexNumber {

  /** The real part */
  private double a;
  /** The imaginary part */
  private double b;


  /**
   * @effects Creates a new <code>ComplexNumber</code> object with real
   * and imaginary parts equal to <code>x</code> and <code>y</code>
   * respectively.
   */
  ComplexNumber (double x, double y) {
    a = x;
    b = y;
  }

  /**
   * @return this ComplexNumber's real part.
   */
  public double getReal() {
    return a;
  }

  /**
   * @return this ComplexNumber's imaginary part.
   */
  public double getImaginary() {
    return b;
  }

  /**
   * @return the magnitude of this ComplexNumber.
   */
  public double getMagnitude() {
    return Math.sqrt(a * a + b * b);
  }

  /**
   * @return a new ComplexNumber equal to the sum
   * of <code>this</code> and <code>z</code>.
   */
  public ComplexNumber add(ComplexNumber z) {
    return new ComplexNumber(a + z.a, b + z.b);
  }

  /**
   * @return a new ComplexNumber equal to <code>z</code>
   * subtracted from <code>this</code>.
   */
  public ComplexNumber sub(ComplexNumber z) {
    return new ComplexNumber(a - z.a, b - z.b);
  }

  /**
   * @return a new ComplexNumber equal to the product of
   * <code>this</code> and <code>z</code>.
   */
  public ComplexNumber mult(ComplexNumber z) {
    return new ComplexNumber(a * z.a - b * z.b,
            a * z.b + b * z.a);
  }

  /**
   * @return a new ComplexNumber equal to the product of <code>this</code>
   * and the real value <code>d</code>.
   */
  public ComplexNumber mult(double d) {
    return new ComplexNumber(a * d, b * d);
  }

  /**
   * @return a new ComplexNumber equal to the quotient of
   * <code>this</code> and <code>z</code>.
   */
  public ComplexNumber div(ComplexNumber z) {
    double rz = z.getMagnitude();

    return new ComplexNumber((a * z.a + b * z.b)/(rz * rz),
            (b * z.a - a * z.b)/(rz * rz));
  }

  /**
   * @return <code>true</code> if real and imaginary parts are identical.
   */
  public boolean equals(ComplexNumber c) {
    return a == c.a && b == c.b;
  }


  /**
   * @return a string of the form <code>a + bi</code> where <code>a</code>
   * and <code>b</code> are the real and imaginary parts of <code>this</code>.
   */
  public String toString() {
    if (b >= 0)
      return (String.valueOf(a) + "+" + String.valueOf(b) + "i");
    else
      return (String.valueOf(a)  + String.valueOf(b) + "i");
  }
}
