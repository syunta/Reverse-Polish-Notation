public class RPN_analysis {

	//数値チェック//
	public static boolean checkDigit(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}	

}
