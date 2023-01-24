package homework;

public class Overloaded {
	int a,b,c,d,e;
    Overloaded (int a1, int b1, int c1, int d1) {
        a=a1;
        b=b1;
        c=c1;
        d=d1;
        e=a+b+c+d;
        System.out.println(e);
    }
    Overloaded (int a2, int b2, int c2) {
        this (a2, b2, c2, 0);
    }
    Overloaded (int a3, int a4) {
        this (a3, a4, 0, 0);
    }
    Overloaded (int a4) {
        this (a4, 0, 0, 0);
    }
    Overloaded () {
        this (0,0,0,0);
    }
}

class OverloadedTest {
    public static void main(String[] args) {

        Overloaded ov1 = new Overloaded(4,6,2,5);
        Overloaded ov2 =new Overloaded(4,3,7);
        Overloaded ov3 = new Overloaded(6,2);
        Overloaded ov4 = new Overloaded(9);
        Overloaded ov5 = new Overloaded();

    }
}
