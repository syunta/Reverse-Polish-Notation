import java.io.IOException;

//逆ポーランド記法による計算プログラム//

public class RPN_main {
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("逆ポーランド記法で数式を半角入力して下さい");
		System.out.println("※区切りにはスペースを使うこと　例）1 2 + 3 4 + *");
		System.out.println("終了には「exit」を入力");
	
		Flow();
		
	}


	public static void Flow() throws IOException{
		while (true) {
		
			String input = RPN_input.Input();
			
			if (input == null) {System.exit(-1);}
		    if("exit".equals(input)) {
			    System.out.println("プログラムを終了します");
		    	System.exit(0) ;
		    }
			
			RPN_output.Output ( RPN_keisan.Keisan (input) );

		}

	}
	
}	
	

