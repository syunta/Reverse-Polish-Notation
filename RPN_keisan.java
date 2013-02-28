import java.io.IOException;

public class RPN_keisan {

	//四則演算//
	public static double enzan(double x , double y , String str)throws IOException{
		double ans = 1;
		
		switch(str){
			case "+":
				ans = x + y;
				break;

			case "-":
				ans = x - y;
				break;

			case "*":
				ans = x * y;
				break;
			
			case "/":
				ans = x / y;
				break;
				
			case "%":
				ans = x % y;
				break;
			
			case "^":
				for (int i = 0 ; i < y ; i++){
					ans = ans * x;
				}
				break;
				
			default:
				RPN_error.error();
		}
				
		return ans;
		
	}

		
}
