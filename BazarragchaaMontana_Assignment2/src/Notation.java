/**
 * 
 * Notation.java
 * CMSC 204
 * @author Montana Bazarragchaa
 *
 */

public class Notation {

    public Notation() {
        // Default constructor
    }

    /**
     * Converts infix to postfix notation.
     * @param infix The infix expression.
     * @return Postfix expression.
     * @throws InvalidNotationFormatException.
     */
    public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
        
    	MyQueue<Character> queue = new MyQueue<>();
        MyStack<Character> stack = new MyStack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            Character ch = infix.charAt(i);

            if (Character.isDigit(ch)) {
                queue.enqueue(ch);
            
            } else if (ch == '(') {
                
            	stack.push(ch);
            
            } else if (ch == ')') {
                
            	while (!stack.isEmpty() && stack.top() != '(') {
                    queue.enqueue(stack.pop());
                }
                
            	if (stack.isEmpty() || stack.top() != '(') {
                    throw new InvalidNotationFormatException();
                }
                stack.pop();
            
            } else if (isOperator(ch)) {
               
            	while (!stack.isEmpty() && checkPrecedence(stack.top()) >= checkPrecedence(ch)) {
                    queue.enqueue(stack.pop());
                }
                stack.push(ch);
            } else if (ch != ' ') {
                throw new InvalidNotationFormatException();
            }
        }

        while (!stack.isEmpty()) {
            if (stack.top() == '(') {
                throw new InvalidNotationFormatException();
            }
            queue.enqueue(stack.pop());
        }

        while (!queue.isEmpty()) {
            postfix.append(queue.dequeue());
        }

        return postfix.toString();
    }

    /**
     * Converts postfix to infix notation.
     * @param postfix The postfix expression.
     * @return Infix expression.
     * @throws InvalidNotationFormatException.
     */
    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
        MyStack<String> stack = new MyStack<>();

        for (int i = 0; i < postfix.length(); i++) {
            Character currentChar = postfix.charAt(i);

            if (currentChar == ' ') {
                continue;
            } else if (!isOperator(currentChar)) {
                stack.push(currentChar.toString());
            } else {
                if (stack.size() < 2) {
                    throw new InvalidNotationFormatException();
                }
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                stack.push("(" + operand1 + currentChar + operand2 + ")");
            }
        }

        if (stack.size() != 1) {
            throw new InvalidNotationFormatException();
        }

        return stack.pop();
    }

    /**
     * Evaluates a postfix expression.
     * @param postfixExpr The postfix expression.
     * @return The evaluated result.
     * @throws InvalidNotationFormatException.
     */
    public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
        MyStack<Double> stack = new MyStack<>();

        for (int i = 0; i < postfixExpr.length(); i++) {
            Character currentChar = postfixExpr.charAt(i);

            if (currentChar == ' ') {
                continue;
            } else if (Character.isDigit(currentChar)) {
                stack.push((double) Character.getNumericValue(currentChar));
            } else if (isOperator(currentChar)) {
                if (stack.size() < 2) {
                    throw new InvalidNotationFormatException();
                }
                Double operand2 = stack.pop();
                Double operand1 = stack.pop();
                stack.push(doCalculations(currentChar, operand1, operand2));
            }
        }

        if (stack.size() != 1) {
            throw new InvalidNotationFormatException();
        }

        return stack.pop();
    }

    /**
     * Checks if a character is an operator.
     * @param ch The character to check.
     * @return True if operator, false otherwise.
     */
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    /**
     * Determines the precedence of an operator.
     * @param operator The operator character.
     * @return Operator precedence value.
     */
	private static int checkPrecedence(char operator) {
		if (operator == '+' || operator == '-')
			return 1;
		else if (operator == '*' || operator == '/')
			return 2;
		else 
			return -1;
	}
	

    /**
     * Performs arithmetic calculations.
     * @param operator The operation to perform.
     * @param num1 First operand.
     * @param num2 Second operand.
     * @return Computed result.
     */
    private static double doCalculations(Character operator, Double num1, Double num2) {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': 
                if (num2 == 0) throw new ArithmeticException("Division by zero.");
                return num1 / num2;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}