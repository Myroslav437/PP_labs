/** 
 * Class - interval of integers
 * @autor Myroslav Mishchuk
 * @version 1.0
*/

public class Interval {
	private int a, b;
	
	/** 
     * Constructor - new object creation
     */
	public Interval(int a, int b) {
		this.a = a;
		this.b = b;
	}

	/** 
    * Function - getter of the first number in the interval
    */
	public int getBegin() {
		return a;
	}
	
	/** 
    * Function - getter of the last number in the interval
    */
	public int getEnd() {
		return b;
	}

	/** 
    * Fucction - print inters from the interval, which
	 * * are integer divisible of given number
    * @param div - divider
    */
	public void print_if_div(int div) {
		for(int i = a; i <= b; ++i) {
			if(i % div == 0) {
				System.out.print(i);
				System.out.print(" ");
			}
		}
	}

	/**
	 * Fucction - print inters from the interval, which
	 * * are integer divisible of given number, in reverse order
	 * @param div - divider
	 */
	public void rprint_if_div(int div) {
		for(int i = b; i >= a; --i) {
			if(i % div == 0) {
				System.out.print(i);
				System.out.print(" ");
			}
		}
	}
}