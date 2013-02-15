import java.io.IOException;
import java.util.LinkedList;


public class RPN_keisan {

	public static double Keisan(String input)throws IOException{
		
	    String[] bunkai = input.split(" ");

		LinkedList<String> stackArea = new LinkedList<String>();
		stackArea.push("�G���[");								//�G���[�`�F�b�N�p
	
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
			
			x_str = checkError_1(stackArea.pop());			//�G���[�`�F�b�N
			x     = Double.parseDouble(x_str);
			
			y_str = checkError_1(stackArea.pop());			//�G���[�`�F�b�N
			y     = Double.parseDouble(y_str);
		
			ans = enzan(x,y,bunkai[i]);
		
			stackArea.push(String.valueOf(ans));
		
			}
		}
				
		stackArea.pop();
		checkError_2(stackArea.pop());				//�G���[�`�F�b�N
		
		return ans;
		
		
	}
	
	//���l�`�F�b�N//
	public static boolean checkDigit(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }	

	//�l�����Z//
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
	
	
	//�G���[����//
	public static void error() throws IOException{		
		System.out.println("���͂�����������܂���");
		RPN_main.Flow();
	}
	
	public static String checkError_1(String str)throws IOException{
		
		if (str == "�G���["){
			System.out.println("���͂�����������܂���");
			RPN_main.Flow();
			
		}else{}
		
		return str;
	}
	
	public static void checkError_2(String str)throws IOException{
		
		if (str != "�G���["){
			System.out.println("���͂�����������܂���");
			RPN_main.Flow();
		}
		
	}
	
}
