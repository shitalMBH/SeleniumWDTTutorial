package test;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int num = 153;
		int sum = 0;
		int digitCount = String.valueOf(num).length();
		for (int temp = 0; temp != 0; temp /= 10) {
			int digit = num % 10;
			sum +=(int) Math.pow(digit, digitCount);
		}
		if (sum == num) {
			System.out.println(num + " is an Armstrong number");
		} else {
			System.out.println(num + " is an not Armstrong number");

		}

	}

}
