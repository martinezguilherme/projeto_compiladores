import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
       Scanner _key = new Scanner(System.in);
int  a;
int  b;
b= _key.nextInt();
a= _key.nextInt();
a = 1+2*3/b;
if (a>b) {
System.out.println(a);
}
while (a>b) {
System.out.println("a");
}
  }
}
