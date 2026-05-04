import java.util.Scanner;

public class pratica2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.print("Digite um número: ");
        n = input.nextInt();
        int i = 1;
        while (i <= 10) {
            System.out.println(n + " x " + i + " = " + (n * i));
            i++;
        }
    }
}
