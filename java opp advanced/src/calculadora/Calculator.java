package calculadora;

public class Calculator implements CalculatorInterface {
	
	public double operandOne;
	public double operandTwo;
	public char operation;
	private double result;
	
	public Calculator(double operandOne, char operation,double operandTwo) {
		this.operandOne = operandOne;
		this.operandTwo = operandTwo;
		this.operation = operation;
	}
	
	public double getOperandOne() {
		return operandOne;
	}
	
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	
	public double getResult() {
		return this.result;
	}
	
	public void performOperation() throws Exception {	
		
		switch(this.operation) {
			case SUM:
				this.result = this.sum();
				break;
			case SUBTRACCION:
				this.result = this.subtraction();
				break;
			default:
				throw new Exception("operacion no manejada");
		}
	}

	@Override
	public double sum() {
		return this.operandOne + this.operandTwo;
	}

	@Override
	public double subtraction() {
		return this.operandOne - this.operandTwo;
	}
	
}
