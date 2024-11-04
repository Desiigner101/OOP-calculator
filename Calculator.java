import java.util.*;

public class Calculator extends Calculate implements Inputs {
    private double num1;
    private double num2;
    private char operator;

    @Override
    public void setFirstNumber(double num1){
        this.num1 = num1;
    }

    @Override
    public void setSecondNumber(double num2){
        this.num2 = num2;
    }

    @Override
    public double getFirstNumber(){
        return num1;
    }

    @Override
    public double getSecondNumber(){
        return num2;
    }

    @Override
    public void setOperation(char operator){
        this.operator = operator;
    }

    @Override
    public char getOperator(){
        return operator;
    }

    @Override
    public double getCalculation(){
        switch(operator){
            case '+':
                return getFirstNumber() + getSecondNumber();

            case '-':
                return num1 - num2;

            case '*':
                return num1 * num2;

            case '/':
            if(num2 == 0){
                System.out.println("\nError...Cannot divide by 0");
                promptForInput();
                return getCalculation();
            }else{
                return num1 / num2;
            }

            case '%':
                return num1 % num2;


            default:
            System.out.print("\nInvalid number... Enter again!");
            promptForOperator();
            return getCalculation();
        }
    }

    @Override
    public void promptForInput(){
        Scanner scan = new Scanner(System.in);

        boolean isValid = true;

        while(isValid){
            try{
            System.out.print("Enter first number: ");
            setFirstNumber(scan.nextDouble());
            isValid = false;
            }catch(Exception e){
                System.out.println("Error: " + e);
                scan.next();
            }
        }

        while(!isValid){
            try{
            System.out.print("Enter second number: ");
            setSecondNumber(scan.nextDouble());
            isValid = true;
            }catch(Exception e){
                System.out.println("Error: " + e);
                scan.next();
            }
        }
    }

    @Override
    public void promptForOperator(){
        Scanner scan = new Scanner(System.in);
        boolean isValid = true;

        while (isValid) {
            try {
                System.out.print("Enter Operator (+ - * / %): ");
                char operator = scan.next().charAt(0);

               
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%') {
                    setOperation(operator); 
                    isValid = false;  
                } else {
                    System.out.println("Invalid operator. Please enter one of +, -, *, /, %.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scan.next();  
            }
        }
    }

}
