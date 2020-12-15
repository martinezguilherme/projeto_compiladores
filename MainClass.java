import java.util.Scanner;
public class MainClass{ 
   public static void main(String args[]){
      Scanner _key = new Scanner(System.in);
      String  palavra;
      int  a;
      int  b;
      int  c;
      int  d;
      String  teste2;
      String  teste1;
      boolean  boolTeste;

      //Parte do numeros
      System.out.println("digite o valor de a ");
      d = 2;
      a = d;
      System.out.println("digite o valor de b ");
      b = _key.nextInt();
      //Parte de texto
      System.out.println("digite uma palavra ");
      palavra = _key.nextLine();
      System.out.println("palavra escrita ");
      System.out.println(palavra);
      palavra = "abracadabra";
      System.out.println("palavra alterada ");
      System.out.println(palavra);
      //comando de decisao
      if (a>b) {
         System.out.println(a);
      } else {
         System.out.println(b);
      }

      //comando de enquanto
      while (a>b) {
         a = a-1;
         System.out.println(a);
      }

      //Operador ternario
      c = a>b?10:20;
      System.out.println(c);
      //Parte do booleanos
      teste1 = "Verdadeiro";
      teste2 = "Falso";
      boolTeste = true;
      if (boolTeste==true) {
         System.out.println(teste1);
         System.out.println(boolTeste);
      } else {
         System.out.println(teste2);
         System.out.println(boolTeste);
      }

      // Acabou 
   }
}
