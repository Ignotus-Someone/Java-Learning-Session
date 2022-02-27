package functions;

import java.lang.Math;


public class ArrayManagement {

    public static int[] Array_Generator(){

        int[] arr = new int[(int) (Math.random() * 8 + 2)];
        System.out.print("Array is generated:\n { ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.round((int) (Math.random()*10));
            System.out.print(arr[i]+" ");
        }
        System.out.print("} \n");

        return arr;
    }

    public static int[] Sorting(int[] arr){

        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] < arr[j]){
                    int buffer = arr[i];
                    arr[i] = arr[j];
                    arr[j] = buffer;
                }
            }
        }
        return arr;
    }

    public static int Find_Max_Number(int[] arr){
        int sum = 0;

        for (int n = 0; n < arr.length; n++){
            sum += arr[n] * Math.pow(10, arr.length - 1 - n);
        }
        System.out.println("Number: " + sum + "\n");
        return sum;
    }
}
