import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.print("Введите математическое уравнение (или 'exit' для выхода): ");
            String equation = scanner.nextLine();


            if (equation.equalsIgnoreCase("exit")) {
                exit = true;
                continue;
            }

            try {
                int result = solveMathEquation(equation);
                System.out.println("Результат: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }

    public static int solveMathEquation(String equation) {
        String[] parts = equation.split("\\+|-|\\*|/");

        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid equation format!");
        }

        int operand1 = Integer.parseInt(parts[0].trim());
        int operand2 = Integer.parseInt(parts[1].trim());

        if (operand1 < 1 || operand1 > 10 || operand2 < 1 || operand2 > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10!");
        }


        if (equation.contains("+")) {
            return operand1 + operand2;
        } else if (equation.contains("-")) {
            return operand1 - operand2;
        } else if (equation.contains("*")) {
            return operand1 * operand2;
        } else if (equation.contains("/")) {
            return operand1 / operand2;


        } else {
            throw new IllegalArgumentException("Invalid operator in the equation!");

        }
    }

}
