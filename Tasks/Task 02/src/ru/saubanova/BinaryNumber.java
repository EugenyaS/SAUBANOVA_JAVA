package ru.saubanova;
class BinaryNumber {

	public static String intToBinary (int number) {
		String binaryString="";
		while (number>0){
			binaryString =number%2+binaryString;
			number=number/2;
		}
		return  binaryString;
	}
	public static void main(String[] args) {
		int number = 13;
		System.out.print(number+"(10) - "+intToBinary(number)+"(2)");
	}
}		