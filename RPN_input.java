import java.io.*;

public class RPN_input {

	public static String Input() throws IOException{

		InputStream inputStream = System.in;
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader =	new BufferedReader(inputStreamReader);


		String input_string = bufferedReader.readLine();		    

		return input_string;

	}

}
