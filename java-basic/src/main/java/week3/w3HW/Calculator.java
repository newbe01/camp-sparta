package week3.w3HW;

public class Calculator {

    AbstractOperation operator;

    public Calculator(AbstractOperation op) {
        this.operator = op;
    }

    public void setOperator(AbstractOperation operator) {
        this.operator = operator;
    }

    double calculating(int t1, int t2) {
        return operator.operate(t1, t2);
    }

}
