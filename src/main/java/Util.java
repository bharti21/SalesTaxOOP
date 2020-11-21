import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class ThreadDemo extends Thread{

	String input;
	Map<Integer,String> output;

	public ThreadDemo(String input, Map<Integer, String> output) {
		this.input = input;
		this.output = output;
		start();
	}

	public void run() {

		
		try {
			for (int i = 0; i < input.length(); i++) {
				if(input.lastIndexOf(input.charAt(i))==input.indexOf(input.charAt(i))){
					output.put(new Integer(i), input.charAt(i)+"");
					break;
				}
				Thread.sleep(100);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

public class Util {
	public static void main(String[] args) {
		String str = "abcdjbcjhdjaweiwoiwtpwlls";
		Map<Integer,String> consolidatedOutput =  new HashMap<Integer,String>();
		for(int i=0,j=0;i<4 && j<str.length();i++,j+=4){
			ThreadDemo thread = new ThreadDemo(str.substring(j, j+4), new HashMap<Integer,String>());
			consolidatedOutput.putAll(thread.output);
		}
		
		int index = Collections.min(consolidatedOutput.keySet());
		System.out.println("1st non-repeating character is:  "+consolidatedOutput.get(index));
	}
}
