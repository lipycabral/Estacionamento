package excecao;

public class CPF {
	public void ValidarCPF(String cpf) throws Exception{
		int sum1 = 0;
		int sum2 = 0;
		boolean autentico = true;
		for(int i = 0; i < 9; i++) {
			sum1 +=  ((int)cpf.charAt(i)-48) * (10-i);
		}
		for(int i = 0; i < 10; i++) {
			sum2 +=  ((int)cpf.charAt(i)-48) * (10- i + 1);
		}
		int num1 = 48;
		if(sum1*10%11 != 10) {
			num1 = (sum1*10%11)+48;
		}
		int num2 = 48;
		if(sum2*10%11 != 10) {
			num2 = (sum2*10%11)+48;
		}
		Character char1 = new Character(cpf.charAt(9));
		Character char2 = new Character((char)(num1));
		Character char3 = new Character(cpf.charAt(10));
		Character char4 = new Character((char)(num2));
		if(!char1.equals(char2) || !char3.equals(char4)) {
			autentico = false;
		}
		if(autentico == false) {
			throw new Exception("CPF INVALIDO");
		}
	}
}
