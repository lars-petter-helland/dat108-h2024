package fut0_PlainUtenTraader;

class Fibonacci {
	
	public long fib(int n) {
		return n <= 1 ? n : fib(n-1) + fib(n-2);
	}
}