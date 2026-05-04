public class pratica1 {
    public static void main(String[] args) {
        double x = 10.5, y = 12.8;
        double z = run(x, y);
        System.out.println(z);
    }
    static double run(double a, double b) {
        return (int) (a + b);
    }
}
