package leetCode;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		int tailPointer = 0;
		Integer[] intArray = new Integer[3];
		System.out.println("ARRAY LENGTH: "+intArray.length);
		int rearIndex = (((tailPointer-1) % (intArray.length))+intArray.length) %(intArray.length);        System.out.println("TAIL: "+tailPointer);
        System.out.println("REAR INDEX "+rearIndex);
	}

}
