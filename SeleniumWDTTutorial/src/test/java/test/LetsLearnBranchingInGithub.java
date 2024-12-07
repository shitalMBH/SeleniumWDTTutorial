package test;

public class LetsLearnBranchingInGithub {
	int b;

	public static int test() {
		int a = 2;
		
		//System.out.println(a);
		return a;
		
	}

	public static void main(String[] args) {
		test();
		LetsLearnBranchingInGithub t = new LetsLearnBranchingInGithub();
		t.b = 6;
		System.out.println("b = " + t.b);
		int c= test() + t.b;
		System.out.println(c);
	}

}
