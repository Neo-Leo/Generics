class Custom<T> {

    T t;

    Custom(T t) {
        this.t = t;
    }

    T get() {
        return t;
    }
}

public class SimpleGenerics {
    public static void main(String[] args) {
        Custom<Integer> intC = new Custom<>(Integer.MAX_VALUE);
        System.out.println(intC.get());

        Custom<Long> longC = new Custom<>(Long.MAX_VALUE);
        System.out.println(longC.get());

        Custom<Double> doubleC = new Custom<>(Double.MAX_VALUE);
        System.out.println(doubleC.get());

        Custom<String> stringC = new Custom<>("Test");
        System.out.println(stringC.get());
    }
}
