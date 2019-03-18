interface GenericCalculator<T extends Number> {
    public T add (T a, T b);
    public T subtract (T a, T b);
    public T multiply (T a, T b);
    public T divide (T a, T b);
}

class IntegerCalculator implements GenericCalculator<Integer> {

    public Integer add(Integer a, Integer b) {
        return a+b;
    }

    public Integer subtract(Integer a, Integer b) {
        return a-b;
    }

    public Integer multiply(Integer a, Integer b) {
        return a*b;
    }

    public Integer divide(Integer a, Integer b) {
        return a/b;
    }
}

class DoubleCalculator implements GenericCalculator<Double> {

    public Double add(Double a, Double b) {
        return a+b;
    }

    public Double subtract(Double a, Double b) {
        return a-b;
    }

    public Double multiply(Double a, Double b) {
        return a*b;
    }

    public Double divide(Double a, Double b) {
        return a/b;
    }
}

public class Calculator {
    public static void main(String[] args) {
        GenericCalculator<Integer> intCalc = new IntegerCalculator();
        System.out.println(intCalc.add(4,2));
        System.out.println(intCalc.subtract(4,2));
        System.out.println(intCalc.multiply(4,2));
        System.out.println(intCalc.divide(4,2));
        // This won't compile
        //System.out.println(intCalc.add(2.2, 2));
        //System.out.println(intCalc.add("A", 2));
        GenericCalculator<Double> doubleCalc = new DoubleCalculator();
        System.out.println(doubleCalc.add(4.4,2.2));
        System.out.println(doubleCalc.subtract(4.4,2.2));
        System.out.println(doubleCalc.multiply(4.4,2.2));
        System.out.println(doubleCalc.divide(4.4,2.2));
        // This won't compile
        //System.out.println(doubleCalc.add(2.2, 2));
        //System.out.println(intCalc.add("A", 2));
    }
}
