package samsung_sw;

import java.io.*;
import java.util.*;


public class Main {
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int answer = 0;
            int bulidingCnt = sc.nextInt();
            int[] bulidingInfo = new int[bulidingCnt];
            
            for(int i = 0; i < bulidingCnt; i++){
            	bulidingInfo[i] = sc.nextInt();
            }
            
            for(int i = 2; i < bulidingCnt-2; i++){
                if(bulidingInfo[i] > bulidingInfo[i-2] && bulidingInfo[i] > bulidingInfo[i+2]){
                    if(bulidingInfo[i] > bulidingInfo[i-1] && bulidingInfo[i] > bulidingInfo[i+1]){
                        int max = 0;
                        if(bulidingInfo[i-2] > max){
                        	max = bulidingInfo[i-2];
                        }
                        if(bulidingInfo[i-1] > max){
                        	max = bulidingInfo[i-1];
                        }
                        if(bulidingInfo[i+1] > max){
                            max = bulidingInfo[i+1];
                        }
                        if(bulidingInfo[i+2] > max){
                        	max = bulidingInfo[i+2];
                        }
                            
                    	answer += bulidingInfo[i] - max;
                    }
                }
            }
            System.out.println("#"+test_case+" "+answer);

		}
	}
}