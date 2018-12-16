class CountBill {
	public static void main(String[] args) {
		int sum = 21053;
		System.out.println("5000 - "+ sum/5000);
		sum = sum-sum/5000*5000;
		System.out.println("2000 - "+ sum/2000);
		sum = sum-sum/2000*2000;
		System.out.println("1000 - "+ sum/1000);
		sum = sum-sum/1000*1000;
		System.out.println("500 - "+ sum/500);
		sum = sum-sum/500*500;
		System.out.println("200 - "+ sum/200);
		sum = sum-sum/200*200;
		System.out.println("100 - "+ sum/100);
		sum = sum-sum/100*100;
		System.out.println("50 - "+ sum/50);
		sum = sum-sum/50*50;
		System.out.println("10 - "+ sum/10);
		sum = sum-sum/10*10;
		System.out.println("5 - "+ sum/5);
		sum = sum-sum/5*5;
		System.out.println("2 - "+ sum/2);
		sum = sum-sum/2*2;
		System.out.println("1 - "+ sum);
		
	}
}