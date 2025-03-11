import java.util.Scanner;

public class Main{
	static int[][] square;
     public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        //int M = scanner.nextInt();
        int[] dayCost = new int[14];
        
        for(int i = 0; i< 14; i++) {
        	dayCost[i] = scanner.nextInt();
        }
        
        int junHyun = BNP(money, dayCost);
        int sungmin = TIMING(money, dayCost);
        
        if(junHyun > sungmin) {
            System.out.println("BNP");
        }
        else if(junHyun < sungmin) {
            System.out.println("TIMING");
        }
        else {
            System.out.println("SAMESAME");
        }
        
     }
     static int BNP(int money, int[] dayCost) {
    	 
    	 int cnt = 0; // 주식 보유 개수
    	 int lmoney = money; // 남은 돈
    	 
    	 for(int i = 0; i < 14; i++) {
    		 int getCnt = lmoney/dayCost[i];
    		 cnt += getCnt;
    		 lmoney -= getCnt * dayCost[i];
    	 }
    	 return lmoney + cnt * dayCost[13];
    	 
     }
     
     static int TIMING(int money, int[] dayCost) {
    	 
    	 int cnt = 0;
    	 int lmoney = money;
    	 int upCount = 0;
         int downCount = 0;
         int yesterday = dayCost[0];

         for(int i = 1; i < 14; i++) {
             int today = dayCost[i];

             if(today > yesterday) {
                 upCount++;
                 downCount = 0;
             }
             else if(today < yesterday) {
                 downCount++;
                 upCount = 0;
             }
             else {
                 upCount = 0;
                 downCount = 0;
             }

             if(upCount == 3) {
                 if(cnt != 0) {
                     lmoney += today * cnt;
                 }
                 upCount = 0;
                 cnt = 0;
             }

             else if(downCount == 3) {
                 int now = lmoney / today;
                 cnt += now;
                 lmoney -= now * today;
             }
         }

         return lmoney + cnt * dayCost[13];
    	 
     }
}