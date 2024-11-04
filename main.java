import java.text.DecimalFormat;
import java.util.*;

public class main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        Calculator calculate = new Calculator();
        boolean isValid = true;

       
        while (isValid) {
            try {
                System.out.print("Enter Operator (+ - * / %): ");
                char operator = scan.next().charAt(0);

                if (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%') {
                    calculate.setOperation(operator);  
                    isValid = false; 
                } else {
                    System.out.println("Invalid operator. Please enter one of +, -, *, /, %.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scan.next();  
            }
        }

        while(!isValid){
            try{
            System.out.print("Enter first number: ");
            calculate.setFirstNumber(scan.nextDouble());
            isValid = true;
            }catch(Exception e){
                System.out.println("Error: " + e);
                scan.next();
            }
        }

        while(isValid){
            try{
            System.out.print("Enter second number: ");
            calculate.setSecondNumber(scan.nextDouble());
            isValid = false;
            }catch(Exception e){
                System.out.println("Error: " + e);
                scan.next();
            }
        }

        double result = calculate.getCalculation();
        System.out.print("\nThe result is: " + df.format(result));
        
        
    }
}
