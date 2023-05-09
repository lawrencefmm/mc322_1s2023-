import java.util.Scanner;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        x += 100;
        System.out.printf("%d\n", x);
    }
}