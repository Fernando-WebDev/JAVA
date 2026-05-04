public class pratica3 {
    static int m1(int x, int y) {
        return x + y;
    }
    static double m1(double x, double y) {
        return x * y;
    }
    public static void main(String[] args) {
        int a = m1(20,3);
        double b = m1(3.56, 1.01);
        System.out.println("int: " + a);
        System.out.println("double: " + b);
    }
}
