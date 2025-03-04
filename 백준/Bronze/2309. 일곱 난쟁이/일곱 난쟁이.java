import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        int []arr = new int [9];
        Scanner sc = new Scanner(System.in);
        int sum = 0; 
        
        for (int i = 0; i<9; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        
        Arrays.sort(arr);


        //int goal = sum-100;
        
        for (int i = 0; i<8; i++){
            for (int j = i+1; j<9; j++){
                if(sum-arr[i]-arr[j] == 100){
                    for(int k = 0; k<9; k++){
                        if(i==k || j==k){
                            continue;
                        }
                        else{
                            System.out.println(arr[k]);
                        }
                    }
                    System.exit(0);
                }
            }
        }
    }
}