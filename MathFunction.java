import textio.TextIO;
import java.math.BigInteger;

public class MathFunction {

    public static void main(String[] args) {

        boolean tryAgain;
        String str;

        System.out.println("This program will compute both the factorial and the fibonacci of the particular number");

        do {
           try {
               System.out.print("Input your value: ");
               TextIO.skipBlanks();
               str = TextIO.getln().trim();
               System.out.println("The factorial of " + str + " is " + factorial(str));
               int N = Integer.parseInt(str);
               System.out.println("The fibonacci of " + str + " is " + fibonacci(N));

           }
           catch (NumberFormatException e) {
               System.out.println(e.getMessage() + " Illegal Argument.");
           }

           System.out.println();
           System.out.println("Do you wish to try again?");
           tryAgain = TextIO.getlnBoolean();
        } while (tryAgain);

        System.out.print("If you're seeing this, then there is nothing for you to do here. Sayonara.");

    }

    static BigInteger factorial(String n) throws NumberFormatException {
        BigInteger N = new BigInteger(n);
        if(n.length() == 0 || N.signum() < 0)
            throw new NumberFormatException("Not a number.");

        if(N.equals(new BigInteger("0")) || N.equals(new BigInteger("1"))) {
            return new BigInteger("1");
        }
        else {
            return N.multiply(factorial(N.subtract(new BigInteger("1")).toString()));
        }
    }

    static int fibonacci(int N) throws NumberFormatException {
        if(N < 0 || N > 40)
            throw new NumberFormatException("Please select a number between 0 to 40");
        if(N <= 1) {
            return 1;
        }
        else {
            return fibonacci(N - 1) + fibonacci(N - 2);
        }

    }




}
