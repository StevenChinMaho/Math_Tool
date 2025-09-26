import java.util.Scanner;
import java.lang.Math;

public class Skew_Lines_Calculator {
	
	static void print(String s) {
		System.out.print(s);
	}
	static void input(Line l1, Line l2) {
		
		Scanner in = new Scanner(System.in);
		
		print("Enter(x1, y1, z1):");
		
		l1.x=in.nextDouble(); l1.y=in.nextDouble(); l1.z=in.nextDouble();
		
		print("Enter(a1, b1, c1):");
		
		l1.a=in.nextDouble(); l1.b=in.nextDouble(); l1.c=in.nextDouble();
		
		print("Enter(x2, y2, z2):");
		
		l2.x=in.nextDouble(); l2.y=in.nextDouble(); l2.z=in.nextDouble();
		
		print("Enter(a2, b2, c2):");
		
		l2.a=in.nextDouble(); l2.b=in.nextDouble(); l2.c=in.nextDouble();
		
		in.close();
	}
	static double[] liner_equation(Line l1, Line l2) {
		
		double t[] = new double[2];
		
		double x, y, a, b, c, d, e, f; //ax+by+c=0 dx+ey+f=0
		
		a = l1.a*l1.a + l1.b*l1.b + l1.c*l1.c;
		b = -(l1.a*l2.a + l1.b*l2.b + l1.c*l2.c);
		c = l1.a*(l1.x-l2.x) + l1.b*(l1.y-l2.y) + l1.c*(l1.z-l2.z);
		
		d = l1.a*l2.a + l1.b*l2.b + l1.c*l2.c;
		e = -(l2.a*l2.a + l2.b*l2.b + l2.c*l2.c);
		f = l2.a*(l1.x-l2.x) + l2.b*(l1.y-l2.y) + l2.c*(l1.z-l2.z);
		
		x = (b*f - c*e)/(a*e - b*d);
		y = (a*f - c*d)/(b*d - a*e);
		
		t[0] = x;
		t[1] = y;
		
		return t;
	}
	
	public static void main(String[] args) {
		
		Line l1 = new Line();
		
		Line l2 = new Line();
		
		input(l1, l2);
		
		double t[] = liner_equation(l1, l2);
		
		double p1[] = { l1.x + l1.a*t[0], l1.y +l1.b*t[0], l1.z + l1.c*t[0] };
		double p2[] = { l2.x + l2.a*t[1], l2.y +l2.b*t[1], l2.z + l2.c*t[1] };
		
		print("P1( " + p1[0] + " , " + p1[1] + " , " + p1[2] + " )\n");
		print("P2( " + p2[0] + " , " + p2[1] + " , " + p2[2] + " )\n");
		print("Distance: " + Math.sqrt( Math.pow(p1[0]-p2[0], 2) + Math.pow(p1[1]-p2[1], 2) + Math.pow(p1[2]-p2[2], 2)));
	}

}
class Line {
	double x, y ,z, a, b, c;
}