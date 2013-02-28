import java.io.IOException;

public class RPN_error {

	//エラー処理//
	public static String checkError_1(String str)throws IOException{

		if (str == "エラー"){
			System.out.println("入力が正しくありません");
			RPN_main.flowchart();
		}

		return str;
	}

	public static void checkError_2(String str) throws IOException{

		switch(str){
		case "+":
			break;

		case "-":
			break;

		case "*":
			break;

		case "/":
			break;

		case "%":
			break;

		case "^":
			break;

		default:
			System.out.println("入力が正しくありません");
			RPN_main.flowchart();

		}	
	}

	public static void checkError_3(String str)throws IOException{

		if (str != "エラー"){
			System.out.println("入力が正しくありません");
			RPN_main.flowchart();
		}

	}

}
