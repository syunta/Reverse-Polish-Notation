import java.io.IOException;
import java.util.LinkedList;


public class RPN_keisan {

	public static double Keisan(String input)throws IOException{
		
	    String[] bunkai = input.split(" ");

		LinkedList<String> stackArea = new LinkedList<String>();
		stackArea.push("エラー");								//エラーチェック用
	
		String x_str;
		String y_str;
		double x = 0;
		double y = 0;
		double ans = 0;
	
	
		for (int i = 0 ; i < bunkai.length ; i++){

			if (checkDigit(bunkai[i]) == true){
			stackArea.push(bunkai[i]);
			ans = Double.parseDouble(bunkai[i]);
			}

			else if (checkDigit(bunkai[i]) == false){
			
			x_str = checkError_1(stackArea.pop());			//エラーチェック
			x     = Double.parseDouble(x_str);
			
			y_str = checkError_1(stackArea.pop());			//エラーチェック
			y     = Double.parseDouble(y_str);
		
			ans = enzan(x,y,bunkai[i]);
		
			stackArea.push(String.valueOf(ans));
		
			}
		}
				
		stackArea.pop();
		checkError_2(stackArea.pop());				//エラーチェック
		
		return ans;
		
		
	}
	
	//数値チェック//
	public static boolean checkDigit(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }	

	//四則演算//
	public static double enzan(double x , double y , String str)throws IOException{
		double ans = 0;
		
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
			
			default:
				error();
		}
				
		return ans;
		
	}
	
	
	//エラー処理//
	public static void error() throws IOException{		
		System.out.println("入力が正しくありません");
		RPN_main.Flow();
	}
	
	public static String checkError_1(String str)throws IOException{
		
		if (str == "エラー"){
			System.out.println("入力が正しくありません");
			RPN_main.Flow();
			
		}else{}
		
		return str;
	}
	
	public static void checkError_2(String str)throws IOException{
		
		if (str != "エラー"){
			System.out.println("入力が正しくありません");
			RPN_main.Flow();
		}
		
	}
	
}
