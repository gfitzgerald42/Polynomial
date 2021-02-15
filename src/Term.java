
/**
 * This class creates a Term objects that hold a coefficient and exponent.
 *
 *@author Georgia Fitzgerald
 *@version 10/18/2019
 */
public class Term{
  //Instance variables
  int coefficient; //expected to be any integer value and should appear if it is not equal to 0
  int exponent; //Expected to be an integer value and should appear next as the exponent to the variable x unless it is equal
                //to 1. And the x should not exist if the exponent is equal to 0.

  /**
   * Constructs a SparsePolynomial assigning int values to the instance variables
   *
   *@param coefficient an int
   *@param exponent an int
   */
  public Term(int coefficent, int exponent){
    this.coefficient = coefficient;
    this.exponent = exponent;
  }

  /**
   * Returns the coefficient assigned to the coefficient instance variable of this
   *
   *@return coefficent as an int
   */
  public int getCoeff(){
    return this.coefficient;
  }

  /**
   * Returns the exponent assigned to the exponent instance variable of this
   *
   *@return exponent as an int
   */
  public int getExponent(){
    return this.exponent;
  }


  /**
   * Returns an string
   *
   *@return a String
   */
  public String toString(){
    if(coefficient == 0){
      return " ";
    }else if(exponent == 0){
      return Integer.toString(this.coefficient);
    }else if(exponent == 1){
      return Integer.toString(this.coefficient) + "x";
    }else{
      return Integer.toString(this.coefficient) + "x^" + exponent + " ";
    }
  }

}
