import java.io.IOException;
import java.util.LinkedList;

//逆ポーランド記法による計算プログラム//

public class RPN_main {

	public static void main(String[] args) throws IOException{

		System.out.println("逆ポーランド記法で数式を半角入力して下さい");
		System.out.println("※区切りにはスペースを使うこと　例）1 2 + 3 4 + *");
		System.out.println("終了には「exit」を入力");

		flowchart();

	}


	public static void flowchart() throws IOException{

		while (true) {

			String input = RPN_input.Input();

			if (input == null) {System.exit(-1);}
			if("exit".equals(input)) {
				System.out.println("プログラムを終了します");
				System.exit(0) ;
			}

			String[] bunkai = input.split(" ");

			LinkedList<String> stackArea = new LinkedList<String>();
			stackArea.push("エラー");		//エラーチェック用のダミーデータをプッシュ

			String x_str;
			String y_str;
			double x = 0;
			double y = 0;
			double ans = 0;


			for (int i = 0 ; i < bunkai.length ; i++){

				if (RPN_analysis.checkDigit(bunkai[i]) == true){
					stackArea.push(bunkai[i]);
					ans = Double.parseDouble(bunkai[i]);
				}

				else if (RPN_analysis.checkDigit(bunkai[i]) == false){

					x_str = RPN_error.checkError_1(stackArea.pop());			//エラーチェック１
					x     = Double.parseDouble(x_str);

					y_str = RPN_error.checkError_1(stackArea.pop());			//エラーチェック１
					y     = Double.parseDouble(y_str);

					RPN_error.checkError_2(bunkai[i]);						//エラーチェック２

					ans = RPN_keisan.enzan(x,y,bunkai[i]);

					stackArea.push(String.valueOf(ans));

				}
			}

			stackArea.pop();
			RPN_error.checkError_3(stackArea.pop());				//エラーチェック３

			RPN_output.Output ( ans );

		}

	}	

}	


