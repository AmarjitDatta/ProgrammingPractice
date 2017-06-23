package com.utils;

public class BinaryOperations {
  public static String convertDecimalToBinary(int decimal) {
    String result = "";
    int originalNumber = decimal;

    if (decimal == 0) {
      return "0";
    }

    if (decimal < 0) {
      decimal = decimal * (-1);
    }

    while (decimal >= 1) {
      if (decimal % 2 == 0) {
        if (originalNumber < 0) {
          result = "1" + result;
        } else {
          result = "0" + result;
        }
      } else {
        if (originalNumber < 0) {
          result = "0" + result;
        } else {
          result = "1" + result;
        }
      }
      decimal = decimal / 2;
    }

    if (originalNumber < 0) {
      result = "1" + result;
    } else {
      result = "0" + result;
    }

    return result;
  }

  /*
    * check the 0th index number. If it is 1, this is a negative number. Else it is a positive number.
    * loop from length - 1 to 1
    * if the number is 1, if it is positive number, add 2^n in the result. If the original number is negative, add nothing.
    * if the number is 0, if it is positive number, add nothing. Else add 2^n in the result.
    * Once the loop is over, if the 0th number is 1 (negative), make the result number negative. Else leave it as it is.
    * return result number
    *
  */
  public static int convertBinaryToDecimal(String binary) {
    int length = binary.length();
    boolean positiveNumber = (binary.charAt(0) == '0');
    int result = 0;

    if (length <= 1) {
      return -1;
    } else {
      int powerIndex = 0;
      for (int i = length - 1; i >= 1; i--) {
        if (binary.charAt(i) == '1' && positiveNumber) {
          result = result + (int) Math.pow(2, powerIndex);
        } else if (binary.charAt(i) == '0' && !positiveNumber) {
          result = result + (int) Math.pow(2, powerIndex);
        }
        powerIndex++;
      }
      if (!positiveNumber) {
        result = (-1) * result;
      }
      return result;
    }
  }
}
