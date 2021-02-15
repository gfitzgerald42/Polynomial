
/**
 * Test class for SparsePolynomial
 *
 *@author Georgia Fitzgerald
 *@version 10/18/2019
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SparsePolynomialTest{
  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception{

  }

  @Test
  public void testMultiply(){
    Polynomial poly1 = new SparsePolynomial(2,1);
    Polynomial poly2 = poly1.multiply(3);
    assertEquals(poly2.getCoeff(1), 6);
  }

  @Test
  public void testAddWithCombining(){
    Polynomial poly = new SparsePolynomial(2,1);
    Polynomial poly1 = new SparsePolynomial(2,1);
    Polynomial poly2 = poly1.add(poly);
    assertEquals(poly2.getCoeff(1), 4);
  }

  @Test
  public void testAddWithZeroExponent(){
    Polynomial poly = new SparsePolynomial(2,0);
    Polynomial poly1 = new SparsePolynomial(2,0);
    Polynomial poly2 = poly1.add(poly);
    assertEquals(poly2.getCoeff(0), 4);
  }

  @Test
  public void testAddWithZeroCoefficient(){
    Polynomial poly = new SparsePolynomial(0,3);
    Polynomial poly1 = new SparsePolynomial(2,1);
    Polynomial poly2 = poly1.add(poly);
    assertEquals(poly2.getCoeff(1), 2);
  }

  @Test
  public void testSubtract(){
    Polynomial poly = new SparsePolynomial(1,3);
    Polynomial poly1 = new SparsePolynomial(2,1);
    Polynomial poly2 = poly1.subtract(poly);
    assertEquals(poly2.getCoeff(3), -1);
  }

  @Test
  public void testIsZero(){
    Polynomial poly = new SparsePolynomial(0,1);
    Polynomial poly1 = new SparsePolynomial(0,1);
    Polynomial poly2 = poly1.add(poly);
    assertEquals(poly2.isZero(), true);
  }

  @Test
  public void testMinus(){
    Polynomial poly1 = new SparsePolynomial(1,1);
    Polynomial poly2 = poly1.minus();
    assertEquals(poly2.getCoeff(1), -1);
  }

  @Test
  public void testOrder(){
    Polynomial poly = new SparsePolynomial(3,4);
    Polynomial poly1 = new SparsePolynomial(2,5);
    Polynomial poly2 = poly1.add(poly);
    assertEquals(poly2.toString(), "2x^5  + 3x^4 ");
  }

}
