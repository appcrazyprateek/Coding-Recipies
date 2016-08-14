package adobe.test;

public class Fib {public static void main(String [] args) {
	try {
		System.out.print("B");
		badMethod();
		System.out.print("C");
		}
		catch (RuntimeException ex) {
		System.out.print("D");
		}
		catch (Exception ex1) {
		}
		finally {
		System.out.print("E");
		}
		}
		public static void badMethod() throws RuntimeException {
		throw new RuntimeException();
		}}
