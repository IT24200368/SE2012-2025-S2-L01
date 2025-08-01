import java.util.Scanner;
public class Welcome{
  public static void main(String[] args){
    Scanner scanner= new Scanner(System.in);
System.out.print(" Enter your First Name:");
String name1= scanner.nextLine();

System.out.print(" Enter your last Name:");
String name2= scanner.nextLine();

System.out.print("Welcome to the second year :"+name1+" "+name2);
}
}



