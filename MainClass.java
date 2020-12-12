import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
       Scanner _key = new Scanner(System.in);
double  a;
double  b;
double  c;
double  d;
a= _key.nextFloat();
b= _key.nextFloat();
a = 1+2*3.3/b;
if (a>b) {
System.out.println(a);
} else {
System.out.println("b");
}

while (a>b) {
System.out.println("a");
}
  }
}
