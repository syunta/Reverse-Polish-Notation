import java.io.IOException;

//�t�|�[�����h�L�@�ɂ��v�Z�v���O����//

public class RPN_main {
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("�t�|�[�����h�L�@�̐����𔼊p���͂��ĉ�����");
		System.out.println("����؂�ɂ̓X�y�[�X���g�����Ɓ@��j1 2 + 3 4 + *");
		System.out.println("�I���ɂ�exit�����");
	
		Flow();
		
	}


	public static void Flow() throws IOException{
		while (true) {
		
			/*�@�@�o�� ( �v�Z ( ���� ) )�@�@*/
			RPN_output.Output ( RPN_keisan.Keisan ( RPN_input.Input() ) );

		}

	}
	
}	
	

