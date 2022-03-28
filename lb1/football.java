// Індивідуальне завдання

import java.util.Scanner;

class Team {// клас у вигляді структури з полями
    String name; // назва команди
    String city; // місто
    int rating; // місце у лізі
    int win; // кількість перемог
}

public class football {
    // методи для всід підзадач для роботи з об'єктами класу Team
    public static Team [] setTeamArr (int n){
        Scanner sc = new Scanner(System.in,"cp1251");
        Team team[] = new Team[n];
        System.out.println("Введите информацию о футбольных командах: "); //вивід тексту
        for(int i = 0; i < team.length; i++) {
            team[i]=new Team();
            System.out.print("Название "+(i+1)+"-й команды: ");  //вивід тексту
            team[i].name=sc.nextLine(); //ввід даних
            System.out.print("Город "+(i+1)+"-й команды: ");  //вивід тексту
            team[i].city=sc.nextLine(); //ввід даних
            System.out.print("Место в лиге "+(i+1)+"-й команды: ");  //вивід тексту
            team[i].rating=sc.nextInt(); //ввід даних
            System.out.print("Количество побед "+(i+1)+"-й команды: ");  //вивід тексту
            team[i].win=sc.nextInt(); //ввід даних
            sc.nextLine(); // очистка буферу
        }
        return team;
    }

    public static void showArray(Team [] tm) { // вивід масиву
        for(int i = 0; i < tm.length; i++) {
            System.out.println("" + tm[i].name + " \t" + tm[i].city + " \t" + tm[i].rating + " \t" + tm[i].win);
        }
    }

    // інформація по команді
    public static void showTeam(Team tm) {
        System.out.println("" + tm.name + " \t" + tm.city + " \t" + tm.rating + " \t" + tm.win);
    }

    // команда з найбільшою кількістю перемог
    public static int WinMax(Team []tm) {
    int winmax = 0; // номер елементу для команди з найбільшою кільк. перемог
    // (початкове значеня)
    int max = tm[winmax].win; // макс. кільк. перемог
    for(int i = 0; i < tm.length; i++)
    if(tm[i].win>max){
        max = tm[i].win;
        winmax = i;
    }
    return winmax;
    }

    // сортуваня команд за спаданням місць в лізі
    public static void sortRating(Team []tm) {
        for (int i = 0; i < tm.length-1; i++)
        for (int j = 0; j < tm.length-1-i; j++)
        if (tm[j].rating > tm[j+1].rating) {
            Team rab = tm[j]; // rab – робоча змінна для перестановки
            tm[j] = tm[j+1];
            tm[j+1] = rab;
        }
    }

    public static double avgWin(Team [] tm) { // середня кільк. перемог
        double s = 0; // загальна кільк. перемог
        for (int i = 0; i < tm.length; i++)
        s+=tm[i].win;
        double sr = s/tm.length; // середня кільк. перемог
        return sr;
    }

    // команди з кількістю перемог більше середньої
    public static Team [] Bigger(Team tm[]) {
        double sred = avgWin(tm);
        int kol = 0; // кількість команд
        for (int i = 0; i < tm.length; i++) {
            if (tm[i].win > sred)
            ++kol;
        }
        if (kol != 0) {
            Team [] bigTeam = new Team[kol];
            int nn=-1;
            for (int i = 0; i < tm.length; i++)
            if (tm[i].win > sred) {
                bigTeam[++nn] = tm[i];
            }
            return bigTeam;
        } else return null;
    }

    // пошук за назвою
    public static Team findForName(Team tm[], String name) {
        int nn=-1; // -1 – команда з шуканою назвою відсутня
        for (int i = 0; i < tm.length; i++)
        if (name.equals(tm[i].name))
        nn = i;
        if (nn!= -1) {
            return tm[nn];
        } else return null;
    }

    public static void main(String[] args) 
    { // головний клас з методами
        Scanner sc=new Scanner(System.in,"cp1251");

        System.out.print("Введите количество команд: ");
        int n=sc.nextInt(); // кількість команд

        Team team[]= setTeamArr(n); // ввід інформації про команди
        System.out.println("\nХарактеристики команд:");
        showArray(team); // вивід отриманої інформації

        // команда з найбільшою кількістю перемог
        int winmax=WinMax(team);
        System.out.println("\nКоманда с наибольшим количеством побед:");
        showTeam(team[winmax]);

        // сортування команда за спаданням місць в лізі
        sortRating(team);
        System.out.println("\nОтсортированный список по месту в лиге:");
        showArray(team);

        // середня кількість перемог
        System.out.println("Среднее количество побед = " + avgWin(team));
        
        // команди з кількістю перемог більше середньої
        System.out.println("\nКоманды, с количеством побед больше среднего");
        Team [] larger=Bigger(team);
        showArray(larger);
        
        // пошук команди
        System.out.println("\nПоиск команды \n Введите название команды: ");
        sc.nextLine();
        String sname=sc.nextLine();
        Team sfind =findForName(team, sname);
        if (sfind!=null) {
        showTeam(sfind);
    }

    else {
        System.out.println("Такой команды нет в списке!");
    }
}}
