public class ControlOp_For131 {

	public static void main(String[] args) {
		
		// ���� �ݺ����� �̿��ؼ� ������ 1�ܺ��� 9�ܱ����� ����ϼ���
		// �Ѱ��� ���� ��µǴ� ������ �����̵� �����̵� ��������ϴ�.
		// 1x1=1  1x2=2  1x3=3..... 1x9=9
		// 2x1=2  2x2=4  2x3=6..... 2x9=18
		// ...
		// 9x1=9  9x2=18  9x3=27..... 9x9=81

		int i, j;
		for(j=1; j<=9; j++) {
			for(i=2; i<=5; i++) {
				System.out.printf("%1dx%1d=%2d  ", i, j, j*i);
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(j=1; j<=9; j++) {
			for(i=6; i<=9; i++) {
				System.out.printf("%1dx%1d=%2d  ", i, j, j*i);
			}
			System.out.println();
		}
	}

}
