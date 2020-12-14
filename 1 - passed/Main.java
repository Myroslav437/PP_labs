import java.util.Scanner;

/** 
 * Main class of the program
 * @autor Myroslav Mishchuk
 * @version 1.0
*/
public class Main{
	public static void main(String[] args){
		System.out.print("Input interval: ");
		
		/** Get interval from the console */
		Scanner input = new Scanner(System.in);
		int a_1 = input.nextInt();
		int a_n = input.nextInt();
		Interval interval = new Interval(a_1, a_n);
		
		/** Print odd numbers from the interval */
		System.out.print("Odd numbers: ");
		interval.print_if_div(3);

		/** Print even numbers from the interval in reverse order */
		System.out.print("\nEven numbers (rev): ");
		interval.rprint_if_div(2);
		
		/**  Print sum of odd numbers form the interval */
		System.out.print("\nOdd numbers sum: ");
		int odd_s = Sum2(interval.Get_begin() , interval.Get_end(), false);
		System.out.print(odd_s);

		/**  Print sum of even numbers form the interval */
		System.out.print("\nEven numbers sum: ");
		int even_s = Sum2(interval.Get_begin() , interval.Get_end(), true);
		System.out.print(even_s);
		
		/** Get Fibonacci series length from the console */
		System.out.print("\nInput fibonacci length: ");
		int n  = input.nextInt();

		/** Print Fibonacci series */
		System.out.print("\nFibonacci: ");
		Fibonacci fib = new Fibonacci();
		if(interval.Get_end() % 2 == 0){
			fib.Start(interval.Get_end() - 1, interval.Get_end() , n);
		}
		else{
			fib.Start(interval.Get_end(),interval.Get_end() - 1, n);
		}
		
		/** Find the ratios of even and odd numbers from the Fibonacci series */
		double sum = fib.odd + fib.even;
		double odd_ = fib.odd;
		double even_ = fib.even;
		System.out.print("\nFibonacci odd : even: ");
		System.out.print(odd_/sum + " : " + even_/sum);
		
		input.close();
	}
	
    /** 
     * Function - calculate sum of arithmetic progression with step = 2
     * @param a - beginning of the interval
     * @param b - end of the interval
     * @param c - calculate sum of:
	 *          true - even numbers
	 *          false - odd numbers
     */
	private static int Sum2(int a, int b, boolean even) {
		if(even == true  && a % 2 != 0 ||
		   even == false && a % 2 == 0) {
				++a;
		}
		if(even == true  && b % 2 != 0 ||
		   even == false && b % 2 == 0){
				--b;
		}

		int sum = (b * (b + 2) - a * (a - 2)) / 4;
		return sum;
	}
}