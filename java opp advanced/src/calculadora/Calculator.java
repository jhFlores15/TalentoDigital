package calculadora;

import java.util.ArrayList;

public class Calculator{
	public final String SUM = "+";
	public final String SUBTRACCION = "-";
	public final String MULTIPLY = "*";
	public final String DIVIDE = "/";
	public final String EQUAL = "=";	
	
	ArrayList<Double> operands = new ArrayList<Double>();
	ArrayList<String> operations = new ArrayList<String>();
	
	private double result;
		
	public double getResult() {
		return this.result;
	}
	
	public void performOperation(double operand) throws Exception {
		operands.add(operand);
	}
	
	public void performOperation(String operation) throws Exception {
		if(operation != "=") {
			operations.add(operation);
		}
		else {
			this.equal();
		}
		
	}
	
	public void equal() throws Exception {
		for (int i = 0; i < operands.size(); i++ ){
			
		}
		
		
		for (int i = 0, x = 0; i < operands.size(); i++,x++ ){
			System.out.println(this.result);
			if(i == 0) {
				this.calculate(operands.get(i), operands.get(i+1), operations.get(x) );
				i++;
			}else {
				this.calculate(this.result, operands.get(i), operations.get(x) );
			}
		}
	}

	public void calculate(double operandOne, double OperandTwo, String operation) throws Exception {	
		
		switch(operation) {
			case SUM:
				this.result = this.sum(operandOne,OperandTwo);
				break;
			case SUBTRACCION:
				this.result = this.subtraction(operandOne,OperandTwo);
				break;
			case MULTIPLY:
				this.result = this.multiply(operandOne,OperandTwo);
				break;
			case DIVIDE:
				this.result = this.divide(operandOne,OperandTwo);
				break;
			case EQUAL:
				this.equal();
				break;
			default:
				throw new Exception("operacion no manejada");
		}
	}
	
	
	public double sum(double operandOne, double operandTwo) {
		return operandOne + operandTwo;
	}

	public double subtraction(double operandOne, double operandTwo) {
		return operandOne - operandTwo;
	}
	
	public double multiply(double operandOne, double operandTwo) {
		return operandOne * operandTwo;
	}
	
	public double divide(double operandOne, double operandTwo) {
		return operandOne / operandTwo;
	}
	
	
	
	
}
