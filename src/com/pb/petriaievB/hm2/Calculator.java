package com.pb.petriaievB.hm2;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a number: ");
        int operand1 = scan.nextInt();
        String sign = scan.next();
        int operand2 = scan.nextInt();
        int result;
        switch(sign) {
            case "+":
                result = operand1 + operand2;
                System.out.println(result);
                break;
            case "-":
                result = operand1 - operand2;
                System.out.println(result);
                break;
            case "*":
                result = operand1 * operand2;
                System.out.println(result);
                break;
            case "/":
                if (operand2 == 0)
                    System.out.println("division by zero is impossible! kekw");
                else {
                    result = operand1 / operand2;
                    System.out.println(result);
                }
                break;
            default:
                System.out.println("Choose one of this symbols: '+', '-', '/', '*'.  ");
        }
    }
}
