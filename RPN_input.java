import java.io.*;

public class RPN_input {

	public static String Input() throws IOException{
		
		InputStream inputStream = System.in;
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader =	new BufferedReader(inputStreamReader);
		
		
		String input = bufferedReader.readLine();
	    
		if (input == null) {System.exit(-1);}

	    if("exit".equals(input)) {
		    System.out.println("プログラムを終了します");
	    	System.exit(0) ;
	    }
	    		    
	    
	    return input;
		
	
	}
	
}
