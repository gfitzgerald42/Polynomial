import java.util.ArrayList;
import java.lang.Math.*;

/**
 * This class implements the interface Polynomial. It creates a SparsePolynomial which is an ArrayList of Term objects
 *
 *@author Georgia Fitzgerald
 *@version 10/18/2019
 */
public class SparsePolynomial implements Polynomial{

  //Instance variables
  ArrayList<Term> sparsePolynomial; //An ArrayList of Term objects that each have a coefficent and an exponent.


  /**
   * Constructs a SparsePolynomial. The ArrayList is defined and assigned a Term object holding the parameters as instance variables
   * within the Term class.  The ArrayList terms is assigned to the instance variable of this class.
   *
   *@param coeff as an int and should not be null.
   *@param exponent as an int and should not be null.
   */
   public SparsePolynomial(int coeff, int exponent){
     sparsePolynomial = new ArrayList<Term>();
     Term term = new Term(coeff, exponent);
     sparsePolynomial.add(term);
   }

  /**
   * Constructs a SparsePolynomial by assigning the ArrayList of Term objects to the instance variable sparsePolynomial
   *
   *@param terms an ArrayList and should not be null.
   */
   private SparsePolynomial(ArrayList<Term> terms){
     sparsePolynomial = terms;
   }

  /**
   * Returns the smallest exponent with a non-zero coefficient
   *
   * @return the smallest exponent with a non-zero coefficient. If all terms
   *         have zero exponents, it returns 0.
   */
  public int getMinExponent(){
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < sparsePolynomial.size(); i++){
      if(sparsePolynomial.get(i).getExponent() < min && sparsePolynomial.get(i).getCoeff() != 0){
        min = sparsePolynomial.get(i).getExponent();
      }
    }
    return min;
  }

  /**
   * Returns the largest exponent with a non-zero coefficient of the polynomial.
   *
   * @return the largest exponent with a non-zero coefficient. If all terms
   *         have zero exponents, it returns 0.
   */
  public int getMaxExponent(){
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < this.sparsePolynomial.size(); i++){
      if(this.sparsePolynomial.get(i).getExponent() > max && this.sparsePolynomial.get(i).getCoeff() != 0){
        max = this.sparsePolynomial.get(i).getExponent();
      }
    }
    return max;
  }

  /**
   * Returns the coefficient corresponding to the given exponent. Returns 0 if
   * there is no term with that exponent in the polynomial.
   *
   * @param exp the exponent whose coefficent is returned. Expected to be an int and should not be null.
   * @return the coefficient of the term of whose exponent was an argument.
   */
  public int getCoeff(int exp){
    int coeff = 0;
    for(int i = 0; i < this.sparsePolynomial.size(); i++){
      if(this.sparsePolynomial.get(i).getExponent() == exp){
        coeff = this.sparsePolynomial.get(i).getCoeff();
      }
    }
    return coeff;
  }

  /**
   * @return true if the polynomial represents the zero constant
   */
  public boolean isZero(){
    return this.getCoeff(this.getMaxExponent()) == 0;
  }

  /**
   * Returns a polynomial by adding the parameter to this. Neither this nor
   * the parameter are modified.
   *
   * @param q the polynomial to add to this. q should not be null.
   * @return this + q
   */
  public Polynomial add(Polynomial q){
    ArrayList<Term> terms = new ArrayList<Term>();
    int max = Math.max(q.getMaxExponent(), this.getMaxExponent());
    int min = Math.min(q.getMinExponent(), this.getMinExponent());

    for(int i = max; i >= min; i--){

      if(q.getCoeff(i) != 0 && this.getCoeff(i) != 0){
        Term term = new Term((q.getCoeff(i) + this.getCoeff(i)), i);
        terms.add(term);
      }else if(q.getCoeff(i) == 0 && this.getCoeff(i) != 0){
        Term term = new Term(this.getCoeff(i), i);
        terms.add(term);
      }else if(q.getCoeff(i) != 0 && this.getCoeff(i) == 0){
        Term term = new Term(q.getCoeff(i), i);
        terms.add(term);
      }
    }
    SparsePolynomial sum = new SparsePolynomial(terms);
    assert wellFormed();
    return sum;
  }

  /**
   * Returns a polynomial by multiplying this by a constant. this
   * is not modified.
   *
   * @param factor the constant to multiply this by and it should be an int and should not be null.
   * @return this * factor
   */
  public Polynomial multiply(int factor){
    ArrayList<Term> terms = new ArrayList<Term>();
    for(int i = 0; i < this.sparsePolynomial.size(); i++){
      Term term = new Term(factor * sparsePolynomial.get(i).getCoeff(), sparsePolynomial.get(i).getExponent());
      terms.add(term);
    }
    Polynomial poly = new SparsePolynomial(terms);
    assert wellFormed();
    return poly;
  }

  /**
   * Returns a polynomial by subtracting the parameter from this. Neither this
   * nor the parameter are modified.
   *
   * @param q the polynomial to subtract from this. q should not be null.
   * @return this - q
   */
  public Polynomial subtract(Polynomial q){
    Polynomial poly = q.minus();
    assert wellFormed();
    return this.add(poly);
  }

  /**
   * Returns a polynomial by negating this. this is not modified.
   *
   * @return -this
   */
  public Polynomial minus(){
    Polynomial poly = this.multiply(-1);
    assert wellFormed();
    return poly;
  }


  /**
   * Returns a String
   *
   * @return String
   */
  public String toString(){
    String information = "";

    for(int i = 0; i < sparsePolynomial.size(); i++){

      if(i != (sparsePolynomial.size()-1)){
        information = information +  sparsePolynomial.get(i).toString() + " + " ;
      }else{
        information = information + sparsePolynomial.get(i).toString();
      }
    }

    if(this.isZero()){
      information = "0";
    }
    return information;
  }


  /**
   * Returns true if the object's class invariant holds
   *
   * @return true if the class invariant holds
   */
  public boolean wellFormed(){
    return sparsePolynomial.size() != 0;
  }

  public static void main(String[] args){
    SparsePolynomial poly = new SparsePolynomial(0,2);
    Polynomial poly2 = new SparsePolynomial(0,2);
    Polynomial sum = poly.add(poly2);
    Polynomial difference = poly.subtract(poly2);
    System.out.println(sum);

    System.out.println(difference);


  }
}
