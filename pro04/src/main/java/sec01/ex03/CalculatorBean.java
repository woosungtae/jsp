package sec01.ex03;


public class CalculatorBean {
	private int num1;
	private String mark;
	private int num2;
	private int answer;
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getAnswer() {
		switch(mark) {
		case "+" : answer = num1 + num2; break;
		case "-" : answer = num1 - num2; break;
		case "*" : answer = num1 * num2; break;
		case "/" : answer = num1 / num2; break;
		}
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	public CalculatorBean() {
		System.out.println("CalculatorBean 생성자호출");
	}
}

	
	
