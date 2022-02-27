import java.util.Scanner;
import task.RmvRptdWrds;

public class Execution {

    public static void main(String[] args) {
        Scanner initiation = new Scanner(System.in);
        System.out.println("Write \"ADD\" to insert words to List, write \"FORMAT\" to clear List and write \"EXIT\" to end process:");

        LOOP:
        while(true){
            String main = initiation.next();

            switch (main) {
                case "ADD":
                    RmvRptdWrds.Constructing();
                    RmvRptdWrds.Sorting();
                    RmvRptdWrds.Represent();
                    break;
                case "FORMAT":
                    RmvRptdWrds.word_list.clear();
                    RmvRptdWrds.Represent();
                    break;
                case "EXIT":
                    break LOOP;
                default:
                    System.out.println("Unknown Command!!!\n Available commands: \"ADD\" ; \"FORMAT\" ; \"EXIT\"");
                    break;
            }
        }
    }
}
