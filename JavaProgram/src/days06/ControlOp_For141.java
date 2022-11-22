public class ControlOp_For141 {

	public static void main(String[] args) {
		
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++) {
				System.out.printf("#");
			}
			System.out.println();
		}
		System.out.println("\n--------------------------------------\n");

		for(int i=1; i<=10; i++) {
			for(int j=1; j<=i ; j++) {
				System.out.printf("#");
			}
			System.out.println();
		}
		/*
		int k = 0;
		for(int i=1; i<=10; i++) {
			k++;
			for(int j=1; j<=k ; j++) {
				System.out.printf("#");
			}
			System.out.println();
		}
		 */
		System.out.println("\n--------------------------------------\n");
		
		
		for(int i=10; i>=1; i--) {
			for(int j=1; j<=i ; j++) {
				System.out.printf("#");
			}
			System.out.println();
		}
		/*
		int k = 11;
		for(int i=1; i<=10; i++) {
			k--;
			for(int j=1; j<=k ; j++) {
				System.out.printf("#");
			}
			System.out.println();
		}
		//--------------------------------
		int k = 11;
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=k-i ; j++) {
				System.out.printf("#");
			}
			System.out.println();
		}
		 */
		System.out.println("\n--------------------------------------\n");
		
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++) {
				if(j >= i)System.out.printf("#");
				else System.out.printf(" ");
			}
			System.out.println();
		}
		System.out.println("\n--------------------------------------\n");

                             for(int i=10; i>=1; i--) {
			for(int j=1; j<=10; j++) {
				if(j >= i)System.out.printf("#");
				else System.out.printf(" ");
			}
			System.out.println();
		}
		System.out.println("\n--------------------------------------\n");

		for(int i=1; i<=10; i++) {
			for(int j=1; j<=  9+i  ; j++) {
				if( j >= 11-i  )System.out.printf("#");
				else System.out.printf(" ");
			}
			System.out.println();
		}
		System.out.println("\n--------------------------------------\n");
	}
}












