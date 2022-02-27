package task;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.lang.System;

public class RmvRptdWrds {
    
    public static Scanner words = new Scanner(System.in);
    public static List <String> word_list = new ArrayList<>();
    
    public static void Constructing(){

        String check_words;
        
        System.out.println("Add words to the list for processing or stop action by \"STOP!\" command:");
        while (true){
            check_words = words.next();
            
            if (check_words.equals("STOP!")) break;
            
            word_list.add(check_words);
        }
    }
    
    public static void Sorting(){
        
        for (int i = 0; i < word_list.size(); i++){
            for (int j = i + 1; j < word_list.size();){
                if(word_list.get(i).equals(word_list.get(j))) word_list.remove(j);
                else j++;
            }
        }
    }
    
    public static void Represent(){

        System.out.println("\nResult:");
        if (RmvRptdWrds.word_list.isEmpty()) System.out.println("**empty**");
        else {
            for (String s : word_list) {
                System.out.println(s);
            }
        }
    }
}
