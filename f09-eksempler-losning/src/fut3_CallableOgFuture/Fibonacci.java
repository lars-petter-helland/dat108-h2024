package fut3_CallableOgFuture;

class Fibonacci {
	public long fib(int n) {
		return n <= 1 ? n : fib(n-1) + fib(n-2);
	}
}