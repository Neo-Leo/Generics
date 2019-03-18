class Custom<T> {

    T t;

    Custom(T t) {
        this.t = t;
    }

    T get() {
        return t;
    }
}

public class Generics1 {
    public static void main(String[] args) {
        Custom<Integer> intC = new Custom<Integer>(Integer.MAX_VALUE);
        System.out.println(intC.get());

        Custom<Long> longC = new Custom<Long>(Long.MAX_VALUE);
        System.out.println(longC.get());

        Custom<Double> doubleC = new Custom<Double>(Double.MAX_VALUE);
        System.out.println(doubleC.get());

        Custom<String> stringC = new Custom<String>("Test");
        System.out.println(stringC.get());
    }
}
