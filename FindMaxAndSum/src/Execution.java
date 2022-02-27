import java.util.Scanner;
import functions.ArrayManagement;

public class Execution {
    public static Scanner order = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the number of arrays that you want to generate:");
        int count = order.nextInt(), result = 0;

        for (int i = 0; i < count; i++){
            result += ArrayManagement.Find_Max_Number(ArrayManagement.Sorting(ArrayManagement.Array_Generator()));
        }

        System.out.println("Summarizing result: " + result);
    }
}
