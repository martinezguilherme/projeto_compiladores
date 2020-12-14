import java.util.Scanner;
public class MainClass{ 
   public static void main(String args[]){
      Scanner _key = new Scanner(System.in);
      String  palavra;
      int  a;
      int  b;
      String  teste2;
      String  teste1;
      boolean  boolTeste;
      boolean  boolInput;

      // Comentarios 123 
      //Parte do numeros
      System.out.println("digite o valor de a ");
      a = _key.nextInt();
      System.out.println("digite o valor de b ");
      b = _key.nextInt();
      condicao?expr1:expr2;
      a = 1+2*3/b;
      // Aqui tem um comando de decisao 
      if (a>b) {
         System.out.println("escrevendo a ");
         System.out.println(a);
      } else {
         System.out.println("escrevendo b ");
         System.out.println(b);
      }

      while (a>b) {
         System.out.println("escrevendo a ");
         System.out.println(a);
         a = a-1;
      }

      //Parte de texto
      System.out.println("digite uma palavra ");
      palavra = _key.nextLine();
      palavra = _key.nextLine();
      System.out.println("palavra escrita ");
      System.out.println(palavra);
      palavra = "abracadabra";
      System.out.println("palavra alterada ");
      System.out.println(palavra);
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

      System.out.println("digite um valor booleano True ou False");
      boolInput = _key.nextBoolean();
      System.out.println("escrevendo booleando ");
      System.out.println(boolInput);
      // Acabou 
   }
}
