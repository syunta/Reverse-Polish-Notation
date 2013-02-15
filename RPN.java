//�t�|�[�����h�L�@�ɂ��v�Z�v���O����//

import java.util.*;

public class RPN {
	
	public static void main(String[] args) {
		
		//����//
		System.out.println("�t�|�[�����h�L�@�̐����𔼊p���͂��ĉ�����");
		System.out.println("����؂�ɂ̓X�y�[�X���g�����Ɓ@��j1 2 + 3 4 + *");
		String input = new java.util.Scanner(System.in).nextLine();
		String[] bunkai = input.split(" ");
		
		//�v�Z//
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
			}

			else if (checkDigit(bunkai[i]) == false){
				
				x_str = checkError1(stackArea.pop());			//�G���[�`�F�b�N
				x     = Double.parseDouble(x_str);
				
				y_str = checkError1(stackArea.pop());			//�G���[�`�F�b�N
				y     = Double.parseDouble(y_str);
			
				ans = enzan(x,y,bunkai[i]);
			
				stackArea.push(String.valueOf(ans));
			
			}
		}
	
		//�o��//		
		stackArea.pop();							//�G���[�`�F�b�N
		checkError2(stackArea.pop());				//

		System.out.println(ans);
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
	
	//�G���[����//
	public static void error(){		
		System.out.println("���͂�����������܂���");
		System.exit(-1);		
	}
	
	public static String checkError1(String str){
		
		if (str == "�G���["){
			System.out.println("���͂�����������܂���");
			System.exit(-1);
		}else{}
		return str;
	}
	
	public static void checkError2(String str){
		
		if (str != "�G���["){
			System.out.println("���͂�����������܂���");
			System.exit(-1);
		}
		
	}
	
}
