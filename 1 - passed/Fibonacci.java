/** 
 * Class - Fibonacci series
 * @autor Myroslav Mishchuk
 * @version 1.0
*/
public class Fibonacci {
	int even;
	int odd;
	
	/** 
    * Constructor - new object creation
    */
	public Fibonacci(){
		even = 0;
		odd = 0;
	}

    /** 
     * Function - print Fibonacci series
     * @param a - first sequence number
     * @param b - second sequence number
     * @param n - amount of numbers in sequence
     */
	public void Start(int a, int b, int n){
		int c;
		if(a % 2 != 0){ even++; }
		else {odd++;}
		if(b % 2 != 0){ even++; }
		else {odd++;}
		
		System.out.print(a + ", " + b + ", ");
		for(int i = 0; i < n-2; ++i) { 
		   c = a + b; 
		   a = b; 
		   b = c; 
		   System.out.print(c + ", ");
		   if(c % 2 != 0){ even++; }
		   else {odd++;}
		} 
	}
}