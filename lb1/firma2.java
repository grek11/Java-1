// Приклад 2
import java.util.Scanner;

class Sotrudnik
{ // клас у вигляді структури з полями
    String fam,im,otch, doljnost ;
    int kolDet;
    Rebenok []reb=null;
}

class Rebenok
{ // клас у вигляді структури з полями
    String imaR;
    int vozrastR;
}

public class firma2 { // головний клас
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in,"cp1251"); //вивід тексту
        System.out.println("Введите количество сотрудников: "); 
        int kol=sc.nextInt(); //ввід даних
        sc.nextLine(); // очистка буферу

        Sotrudnik []sotr=new Sotrudnik[kol]; //посилання на масив
        System.out.println("Введите информацию о каждом сотруднике: "); //вивід тексту
        for (int i = 0; i < sotr.length; i++) {
        sotr[i]=new Sotrudnik();
        System.out.print("Введите фамилию "+(i+1)+" сотрудника: "); //вивід тексту
        sotr[i].fam= sc.nextLine(); //ввід даних
        System.out.print("Введите имя сотрудника: "); //вивід тексту
        sotr[i].im=sc.nextLine(); //ввід даних
        System.out.print("Введите отчество сотрудника: "); //вивід тексту
        sotr[i].otch=sc.nextLine(); //ввід даних
        System.out.print("Введите должность сотрудника: "); //вивід тексту
        sotr[i].doljnost=sc.nextLine(); //ввід даних
        System.out.print("Введите количество детей сотрудника: "); //вивід тексту
        sotr[i].kolDet=sc.nextInt(); //ввід даних
        sc.nextLine(); // очистка буферу
        if (sotr[i].kolDet!=0) {
        sotr[i].reb=new Rebenok[sotr[i].kolDet];
        System.out.println("Дети: "); //вивід тексту
        for (int j = 0; j < sotr[i].reb.length; j++) {
        sotr[i].reb[j]=new Rebenok();
        System.out.print("Введите имя "+(j+1)+" ребенка: "); //вивід тексту
        sotr[i].reb[j].imaR = sc.nextLine(); //ввід даних
        System.out.print("Введите возраст ребенка: "); //вивід тексту
        sotr[i].reb[j].vozrastR = sc.nextInt(); //ввід даних
        sc.nextLine(); // очистка буферу
        } } }
        //вивід інформації про співробітників
        System.out.println("\nСотрудники фирмы \n Фамилия \t Имя \t Отчество \t Должность");
        for (Sotrudnik s : sotr) {  //цикл
        System.out.print(s.fam+ "\t"+s.im + "\t"+ s.otch + "\t "+ s.doljnost);
        System.out.print("\n Дети: ");
        for (Rebenok r : s.reb)  //цикл
        System.out.print("\t\t\t"+ r.imaR+ "\t\t"+ r.vozrastR);
        System.out.println("");
    }
    } 
}
