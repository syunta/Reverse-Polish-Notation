//逆ポーランド記法による計算プログラム//

import java.util.*;

public class RPN {
	
	public static void main(String[] args) {
		
		//入力//
		System.out.println("逆ポーランド記法の数式を半角入力して下さい");
		System.out.println("※区切りにはスペースを使うこと　例）1 2 + 3 4 + *");
		String input = new java.util.Scanner(System.in).nextLine();
		String[] bunkai = input.split(" ");
		
		//計算//
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
			}

			else if (checkDigit(bunkai[i]) == false){
				
				x_str = checkError1(stackArea.pop());			//エラーチェック
				x     = Double.parseDouble(x_str);
				
				y_str = checkError1(stackArea.pop());			//エラーチェック
				y     = Double.parseDouble(y_str);
			
				ans = enzan(x,y,bunkai[i]);
			
				stackArea.push(String.valueOf(ans));
			
			}
		}
	
		//出力//		
		stackArea.pop();							//エラーチェック
		checkError2(stackArea.pop());				//

		System.out.println(ans);
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
	public static double enzan(double x , double y , String str){
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
	public static void error(){		
		System.out.println("入力が正しくありません");
		System.exit(-1);		
	}
	
	public static String checkError1(String str){
		
		if (str == "エラー"){
			System.out.println("入力が正しくありません");
			System.exit(-1);
		}else{}
		return str;
	}
	
	public static void checkError2(String str){
		
		if (str != "エラー"){
			System.out.println("入力が正しくありません");
			System.exit(-1);
		}
		
	}
	
}
