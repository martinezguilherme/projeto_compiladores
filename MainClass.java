import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
       Scanner _key = new Scanner(System.in);
String  palavra;
int  a;
int  b;
// Comentarios 123 
b= _key.nextInt();
a= _key.nextInt();
palavra= _key.nextLine();
a = 1+2*3/b;
// Aqui tem um comando de decisao 
if (a>b) {
System.out.println(a);
} else {
System.out.println(b);
}

palavra = "abracadabra";
System.out.println(palavra);
while (a>b) {
System.out.println("a");
}
// Acabou 
  }
}
