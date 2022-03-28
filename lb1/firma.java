// Приклад 1

import java.util.Scanner;

class Employee 
{ // клас у вигляді структури з полями
    String surname, name, patronymic, position;
    int salary;
}

public class firma 
{ // головний клас
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in,"cp1251")) 
        {
            System.out.println("Введите количество сотрудников: "); //вивід тексту
            int n=sc.nextInt(); //ввід даних
            sc.nextLine(); //очистка буферу
            Employee[] empl=new Employee[n]; //посилання на масив

            System.out.println("Введите информацию о каждом сотруднике: "); //вивід тексту
            for (int i = 0; i < empl.length; i++) //цикл
            {

            empl[i]=new Employee(); //посилання на і-ий елемент

            System.out.print("Введите фамилию "+(i+1)+" сотрудника: "); //вивід тексту
            empl[i].surname= sc.nextLine(); //ввід даних

            System.out.print("Введите имя сотрудника: "); //вивід тексту
            empl[i].name=sc.nextLine(); //ввід даних

            System.out.print("Введите отчество сотрудника: "); //вивід тексту
            empl[i].patronymic=sc.nextLine(); //ввід даних

            System.out.print("Введите должность сотрудника: "); //вивід тексту
            empl[i].position=sc.nextLine(); //ввід даних

            System.out.print("Введите оклад сотрудника: "); //вивід тексту
            empl[i].salary=sc.nextInt(); //ввід даних
            
            sc.nextLine(); //очистка буферу
            // кінець for

            //вивід інформації про співробітників
            System.out.println( "\n Сотрудники фирмы: \n Фамилия \t Имя \t Отчество \t Должность \t Оклад"); //вивід тексту
            for (Employee s:empl) //цикл
            {
                System.out.print(s.surname+ "\t"+s.name + "\t"+s.patronymic+ "\t "+s.position + "\t\t"+s.salary+ "\n");
            }
            }
        }
    }
}