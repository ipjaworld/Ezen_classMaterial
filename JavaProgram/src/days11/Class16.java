package days11;

// 복소수  5 + 3i   
// i -> 루트-1  : -1 의 제곱근 (허수)

class Complex{
	private int real;
	private int image;
	Complex(){}
	Complex(int real, int image){
		this.real = real;
		this.image = image;
	}
	void prn( /* Complex this */){
		System.out.println("(" + this.real + "+" + this.image + "i)");
	}
	public void init(int real, int image) {
		this.real = real;
		this.image = image;		
	}
	public Complex add(Complex c) {  // this<-c1   매개변수 c<-c2
		// c1과 c2더해서 새로운 객체에 저장하고 리턴
		Complex temp = new Complex();
		temp.real = this.real + c.real;
		temp.image = this.image + c.image;
		return temp;
	}
	public Complex subtract(Complex c) {
		Complex temp = new Complex();
		temp.real = this.real - c.real;
		temp.image = this.image - c.image;
		return temp;
	}
	
	
}
// 생략없이 표시할수 있는 this 는 모두 표시해주세요
public class Class16 {

	public static void main(String[] args) {
		Complex c1 = new Complex();
		c1.init( 5, 6);
		Complex c2 = new Complex(2, 3);
		
		Complex c3 = c1.add(c2);  // 실수부는 실수부끼리  허수부는 허수부끼라 합산
		c1.prn();
		c2.prn();
		c3.prn();
		System.out.println();

		c3 = c1.subtract(c2);   // 실수부는 실수부끼리  허수부는 허수부끼라 뺄셈
		c1.prn();  
		c2.prn();
		c3.prn();

	}

}
