// Приклад 4

import java.util.Scanner;

class Strana
{// клас у вигляді структури з полями
    String name; // назва країни
    double square; // площа країни
}

public class countries {
    // методи для всід підзадач для роботи з об'єктами класу Strana
    public static Strana [] setCountryArr(int k)
    { // ввід масиву країн
        Scanner sc=new Scanner(System.in,"cp1251");
        Strana country[]=new Strana[k];
        System.out.println("Введите информацию о странах: "); //вивід тексту
        for (int i = 0; i < country.length; i++) {
        country[i]=new Strana();
        System.out.print("Название "+(i+1)+"-й страны: ");  //вивід тексту
        country[i].name=sc.nextLine(); //ввід даних
        System.out.print("Площадь "+(i+1)+"-й страны: ");  //вивід тексту
        country[i].square=sc.nextDouble(); //ввід даних, млн кв. км
        sc.nextLine(); // очистка буферу
    }
    return country;
    }

    public static void showArray(Strana [] cntr)
    { // вивід масиву
        for (int i = 0; i < cntr.length; i++) {
        System.out.println("" + cntr[i].name + " \t" + cntr[i].square + " млн кв. км");
    } }

    // інформація по країні
    public static void showCountry(Strana cntr)
    {
    System.out.println(""+cntr.name+"\t"+cntr.square+" млн кв. км"); 
    }

    // номер країни з найбільшою площею
    public static int NomMax(Strana []st)
    {
        int nommax=0; // номер елементу для країни з найбільшою площею
        // (початкове значення)
        double max=st[nommax].square; // макс. площа // (початкове значення)
        for (int i = 0; i < st.length; i++)
        if (st[i].square>max) 
        {
            max= st[i].square;
            nommax=i;
        }
        return nommax;
    }

    // сортування країн за площею
    public static void sortSquare(Strana []cntr)
    {
        for (int i = 0; i < cntr.length-1; i++)
        for (int j = 0; j < cntr.length-1-i; j++)
        if (cntr[j].square>cntr[j+1].square)
        {
            Strana rab=cntr[j]; // rab – робоча змінна для перестановки
            cntr[j]=cntr[j+1];
            cntr[j+1]=rab;
        }   
    }

    // сортування країн за назвою
    public static void sortName(Strana [] cntr){
    for (int i = 0; i < cntr.length-1; i++)
    for (int j = 0; j < cntr.length-i-1; j++)
    if(cntr[j].name.compareTo(cntr[i+1].name)>0){
    Strana rab=cntr[j]; // rab – робоча змінна для перестановки
    cntr[j]=cntr[j+1];
    cntr[j+1]=rab;
    }
    }

    public static double avgSquare( Strana [] cntr){ // середня площа
    double s=0; // сумарна площа
    for (int i = 0; i < cntr.length; i++)
    s+=cntr[i].square;

    double sr=s/cntr.length; // середня площа
    return sr;
    }

    // країни з площею більшу за середню
    public static Strana [] Bigger(Strana cntr[]){
    double sred=avgSquare(cntr);
    int kol=0; // кількість країн
    for (int i = 0; i < cntr.length; i++) {
    if (cntr[i].square>sred)
    ++kol;
    }
    if (kol != 0){
    Strana [] bigCountry=new Strana[kol];
    int n=-1;
    for (int i = 0; i < cntr.length; i++)
    if (cntr[i].square>sred) {
    bigCountry[++n]=cntr[i];
    }
    return bigCountry;
    } else return null;
    }

    // пошук за назвою
    public static Strana findForName(Strana cntr[], String name){
    int n=-1; // -1 – країна з шуканою назвою відсутня
    for (int i = 0; i < cntr.length; i++)
    if (name.equals(cntr[i].name))
    n=i;
    if (n!= -1) {
    return cntr[n];
    }else return null;
    }

    public static void main(String[] args) 
    { // головний клас з методами
        Scanner sc=new Scanner(System.in,"cp1251");
        System.out.print("Введите количество стран: ");
        int n=sc.nextInt(); // кількість країн

        Strana country[]= setCountryArr(n); // ввід інформації про країни
        System.out.println("\nХарактеристики стран:");
        showArray(country); // вивід отриманої інформації

        // країна з найбільшою площею
        int nommax=NomMax(country);
        System.out.println("\nСтрана с максимальной площадью:");
        showCountry(country[nommax]);

        // сортування країн за площею
        sortSquare(country);
        System.out.println("\nОтсортированный список по площади:");
        showArray(country);

        // сортування країн за назвою
        sortName(country);
        System.out.println("\nОтсортированный список по названиям:");
        showArray(country);

        // cсередня площа
        System.out.println("Средняя площадь = "+avgSquare(country));
        
        // площа більша за середню
        System.out.println("\nСтраны, с площадью больше средней");
        Strana [] larger=Bigger(country);
        showArray(larger);
        
        // пошук країни
        System.out.println("\nПОИСК СТРАНЫ \n Введите название страны: ");
        sc.nextLine();
        String sname=sc.nextLine();
        Strana sfind =findForName(country, sname);
        if (sfind!=null) {
        showCountry(sfind);
    } 

    else 
    {
    System.out.println("Такой страны нет в списке!");
}}
}
