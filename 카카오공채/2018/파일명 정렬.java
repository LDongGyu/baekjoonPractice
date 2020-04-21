package programmers;
import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		String[] answer;
		answer = test.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG","foo010bar020.zip","F-15"});
		System.out.println(Arrays.toString(answer));
	}
}

class Solution {
	  public String[] solution(String[] files) {
	      String[] answer = {};
	      String[][] parsingFile = new String[files.length][4];
	      
	      
	      for(int file = 0; file < files.length; file++) {
	    	  
	    	  int number = 0;
	    	  int tail = 0;
	    	  
	    	  int index = 0;
	    	  while(files[file].charAt(index)-'0' < 0 || files[file].charAt(index)-'0' > 9) {
	    		index++;  
	    	  }
	    	  number = index;
	    	  int count = 0;
	    	  while(files[file].charAt(index)-'0' >= 0 && files[file].charAt(index)-'0' <= 9 && count<5) {
	    		  index++;
	    		  count++;
	    		  if(index == files[file].length()) {
	    			  break;
	    		  }
	    	  }
	    	  tail = index;
	    	  
	    	  parsingFile[file][0] = files[file].substring(0, number);
	    	  
	    	  String numberTemp = files[file].substring(number, tail);
	    	  
	    	  while(true) {
	    		  if(numberTemp.charAt(0) == '0') {
	    			  if(numberTemp.length() == 1) {
	    				  break;
	    			  }
	    			  else {
	    				  numberTemp = numberTemp.substring(1);
	    			  }
	    		  }
	    		  else {
	    			  break;
	    		  }
	    	  }
	    	  parsingFile[file][1] = numberTemp;
			  parsingFile[file][2] = files[file].substring(tail);
			  parsingFile[file][3] = Integer.toString(file);
	      }
	      List<String[]> fileList = Arrays.asList(parsingFile);
	      
	      Collections.sort(fileList, new Comparator<String[]>() {

				@Override
				public int compare(final String[] o1, final String[] o2) {
					// TODO Auto-generated method stub
					int first = Integer.parseInt(o1[1]);
					int second = Integer.parseInt(o2[1]);
					return first - second;
				}
				  
			  });
	      
	      Collections.sort(fileList, new Comparator<String[]>() {

				@Override
				public int compare(final String[] o1, final String[] o2) {
					// TODO Auto-generated method stub
					final String first = o1[0].toLowerCase();
					final String second = o2[0].toLowerCase();
					return first.compareTo(second);
				}
				  
			  });
	      
	      String[] answer2 = new String[files.length];
	      for(int i = 0; i < files.length; i++) {
	    	  for(int j = 0; j < files.length; j++) {
	    		  if(Integer.parseInt(fileList.get(i)[3]) == j) {
	    			  answer2[i] = 	files[j];
	    			  break;
	    		  }
	    	  }
	      }
	      return answer2;
	  }
	  
}