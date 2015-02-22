package adobe.test;

public class CMDTest {
	
	private static CMDTest instance;
	
	static String l=null;

	public CMDTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static CMDTest getInstance()
	{
		System.out.println("Before----->"+l);
		if(instance==null)
			instance = new CMDTest();
		
		l="Hello";
		System.out.println("after----->"+l);
		return instance;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Before");
		Thread.sleep(20000);
		CMDTest.getInstance();
		System.out.println("After");
	}
}
