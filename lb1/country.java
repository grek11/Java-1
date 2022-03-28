// Приклад 3

import java.util.Scanner;

class Strana
{// клас у вигляді структури з полями
    String name; // назва країни
    double square; // площа країни
}

public class country { // головний клас
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in,"cp1251");

        // ввід інформації про країни
        System.out.println("Введите количество стран: "); //вивід тексту
        int n=sc.nextInt(); // кількість країн
        Strana country[]=new Strana[n];
        System.out.println("Введите информацию о странах: "); //вивід тексту
        for (int i = 0; i < country.length; i++) {
        sc.nextLine(); // очистка буфера
        country[i]=new Strana();
        System.out.print("Название "+(i+1)+"-й страны: "); //вивід тексту
        country[i].name=sc.nextLine(); //ввід даних
        System.out.print("Площадь "+(i+1)+"-й страны: "); //вивід тексту
        country[i].square=sc.nextDouble(); //ввід даних
        }

        // вивід отриманої інформації
        System.out.println("\nХарактеристики стран:");
        for (int i = 0; i < country.length; i++) 
        {
            System.out.println(""+country[i].name+"\t"+country[i].square +" млн кв. км");
        }
        // країна з найбільшою площею
        int nommax=0; // номер елементу для країни з найбільшою площею
        // (початкове значення)
        double max=country[nommax].square; // найбільша площа
        // (початкове значення)
        // або інший запис циклу

        for (int i = 0; i < country.length; i++)
        if (country[i].square>max) {
        max= country[i].square;
        nommax=i;
        }
        System.out.println("\nСтрана с максимальной площадью:");
        System.out.println(""+country[nommax].name+"\t"+country[nommax].square+"млн кв. км");
        
        // сортування країн за площею
        for (int i = 0; i < country.length-1; i++)
        for (int j = 0; j < country.length-1-i; j++)
        if (country[j].square>country[j+1].square){
        Strana rab=country[j]; // rab – робоча змінна для перестановки
        country[j]=country[j+1];
        country[j+1]=rab;
        }
        System.out.println("\nОтсортированный список по площади:");//
        for (int i = 0; i < country.length; i++) {
        System.out.println(""+country[i].name+"\t"+country[i].square+"млн кв. км");
        }

        // сортування країн за назвою
        for (int i = 0; i < country.length-1; i++)
        for (int j = 0; j < country.length-i-1; j++)
        if(country [j].name.compareTo(country[i+1].name)>0){
        Strana rab=country[j]; //rab – робоча змінна для перестановки
        country[j]=country[j+1];
        country[j+1]=rab;
        }
        System.out.println("\nОтсортированный список по названиям:");
        for (int i = 0; i < country.length; i++) {
        System.out.println(""+country[i].name +"\t"+country[i].square
        +" млн кв. км");
        }

        // площа більша середньої
        double s=0; // сумарна площа
        for (int i = 0; i < country.length; i++)
        s+=country[i].square;
        double sr=s/country.length; ; // середня площа
        System.out.println("Средняя площадь ="+sr);
        System.out.println("\nСтраны, с площадью больше средней");
        for (int i = 0; i < country.length; i++) {
        if (country[i].square>sr)

        System.out.println(country[i].name +"\t"+country[i].square +" млн кв. км");
        }

        // пошук за назвою
        sc.nextLine(); // очистка буферу
        System.out.println("Введите название искомой страны: ");
        String name=sc.nextLine();
        int nom=-1; // -1 – країна з шуканою назвою відсутня
        for (int i = 0; i < country.length; i++)
        if (name.equalsIgnoreCase(country[i].name))
        nom=i;
        if (nom!= -1) {
        System.out.println("Такая страна есть в списке. Это "
        +country[nom].name+" "+country[nom].square+" млн кв. км");
        }else System.out.println("Такой страны нет в списке");
}
}
