/********************************************************************************/
/*                                                                              */
/*              MathLibrary.java                                                */
/*                                                                              */
/*      Contains various (buggy) library routines for mathematics               */
/*                                                                              */
/********************************************************************************/


package rosestudy;



class MathLibrary
{


/********************************************************************************/
/*                                                                              */
/*      Private Storage                                                         */
/*                                                                              */
/********************************************************************************/

private static char[] output_buffer = {};       // output buffer
protected static int current_size = 0;          // current buffer size
private static String null_text = null;         // null text



/********************************************************************************/
/*                                                                              */
/*       GCD code                                                               */
/*                                                                              */
/********************************************************************************/

/**
 * <p>
 * Gets the greatest common divisor of the absolute value of two numbers,
 * using the "binary gcd" method which avoids division and modulo
 * operations. See Knuth 4.5.2 algorithm B. This algorithm is due to Josef
 * Stein (1961).
 * </p>
 * 
 * @param u a non-zero number
 * @param v a non-zero number
 * @return the greatest common divisor, never zero
 * @since 1.1
 */

public static int gcd(int u, int v)
{
   if (u * v == 0) {
      return (Math.abs(u) + Math.abs(v));
    }
   
   if (u > 0) {
      u = -u;
    } 
   if (v > 0) {
      v = -v;
    } 
   int k = 0;
   while ((u & 1) == 0 && (v & 1) == 0 && k < 31) { 
      u /= 2;
      v /= 2;
      k++; 
    }
   if (k == 31) {
      throw new ArithmeticException("overflow: gcd is 2^31");
    }
   int t = ((u & 1) == 1) ? v : -(u / 2);
   do {
      while ((t & 1) == 0) { 
         t /= 2; 
       }
      if (t > 0) {
         u = -t;
       } else {
          v = t;
        }
      t = (v - u) / 2;
    } while (t != 0);
   return -u * (1 << k); 
}


/********************************************************************************/
/*                                                                              */
/*       Max compuatation                                                       */
/*                                                                              */
/********************************************************************************/

/** Compute the maximum of two values
 * @param a first value
 * @param b second value
 * @return b if a is lesser or equal to b, a otherwise
 */

public static float max(final float a, final float b) 
{
   return (a <= b) ? b : (Float.isNaN(a + b) ? Float.NaN : b);
}


/********************************************************************************/
/*                                                                              */
/*       Fancy formatted output                                                 */
/*                                                                              */
/********************************************************************************/

static void clearBuffer() {
   output_buffer = new char[] {};
   current_size = 0;
}

/**
 * Checks the capacity and ensures that it is at least the size specified.
 *
 * @param capacity  the capacity to ensure
 * @return this, to enable chaining
 */

private static void ensureCapacity(int capacity) {
   
   if (capacity > output_buffer.length) {
      char[] old = output_buffer;
      output_buffer = new char[capacity];
      System.arraycopy(old, 0, output_buffer, 0, current_size);
    }
}


public static String appendString(String s)
{
   if (s == null) appendNull();
   else {
      int strlen = s.length();
      if (strlen > 0) {
         int len = current_size;
         ensureCapacity(len+strlen);
         s.getChars(0,strlen,output_buffer,len);
         current_size += strlen;
       }
    }
   return new String(output_buffer, 0, current_size);
}


public static String appendNull()
{
   if (null_text != null) return appendString(null_text);
   return new String(output_buffer, 0, current_size);
}



/**
 * Appends an object to the builder padding on the right to a fixed length.
 * The <code>toString</code> of the object is used.
 * If the object is larger than the length, the right hand side is lost.
 * If the object is null, null text value is used.
 * 
 * @param obj  the object to append, null uses null text
 * @param width  the fixed field width, zero or negative has no effect
 * @param padChar  the pad character to use
 * @return resultant string
*/

public static String appendFixedWidthPadRight(Object obj, int width, char padChar) {
   if (width > 0) {
      ensureCapacity(current_size + width);
      String str = (obj == null ? null_text : obj.toString());
      int strLen = str.length();
      if (strLen >= width) {
         str.getChars(0, strLen, output_buffer, current_size);
       } 
      else {
         int padLen = width - strLen;
         str.getChars(0, strLen, output_buffer, current_size);
         for (int i = 0; i < padLen; i++) {
            output_buffer[current_size + strLen + i] = padChar;
          }
       }
      current_size += width;
    }
   return new String(output_buffer, 0, current_size);
}


/********************************************************************************/
/*                                                                              */
/* Count how many 1-bits in a number */
/*                                                                              */
/********************************************************************************/

public static int bitcount(int n) {
   int count = 0;
   while (n != 0) {
      n = (n ^ (n - 1));
      count++;
      assert count <= 64;
   }
   return count;
}

/********************************************************************************/
/*                                                                              */
/* Count how many 1-bits in a number */
/*                                                                              */
/********************************************************************************/

public static boolean isValidParenthesization(String parens) {
   int depth = 0;
   for (int i = 0; i < parens.length(); i++) {
      Character paren = parens.charAt(i);
      if (paren.equals('(')) {
         depth++;
      } else {
         depth--;
         if (depth < 0) {
            return false;
         }
      }
   }
   return true;
}

}       // end of class MathLibrary




/* end of MathLibrary.java */

