package samsung_sw;

import java.io.*;
import java.util.*;


public class Main {
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		for(int test_case = 1; test_case <= 1; test_case++)
		{
			int answer = -1;
            int dump = sc.nextInt();
            int[] boxInfo = new int[11];
            
            for(int i = 0; i < 11; i++){
            	boxInfo[i] = sc.nextInt();
            }
            int max = 0;
            int min = 0;
            for(int i = 0; i < dump; i++){
                max = 0;
                min = 0;
            	for(int j = 0; j < 11; j++){
                    if(boxInfo[max] < boxInfo[j]){
                        max = j;
                    }
                    if(boxInfo[min] > boxInfo[j]){
                        min = j;
                    }
                }
                if(boxInfo[max] == boxInfo[min]){
                	answer = 0;
                    break;
                }
                else{
                	boxInfo[max]--;
                    boxInfo[min]++;
                }
            }
            for(int j = 0; j < 11; j++){
                if(boxInfo[max] < boxInfo[j]){
                    max = j;
                }
                if(boxInfo[min] > boxInfo[j]){
                    min = j;
                }
            }
            if(answer != 0){
            	answer = boxInfo[max] - boxInfo[min];
            }
            System.out.println("#"+test_case+" "+answer);
		}
	}
}