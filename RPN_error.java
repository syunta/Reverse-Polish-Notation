import java.io.IOException;


public class RPN_error {
	
	//エラー処理//
	public static void error() throws IOException{		
		System.out.println("入力が正しくありません");
		RPN_main.flowchart();
	}
	
	public static String checkError_1(String str)throws IOException{
		
		if (str == "エラー"){
			System.out.println("入力が正しくありません");
			RPN_main.flowchart();
			
		}else{}
		
		return str;
	}
	
	public static void checkError_2(String str)throws IOException{
		
		if (str != "エラー"){
			System.out.println("入力が正しくありません");
			RPN_main.flowchart();
		}
		
	}

}
