/* Or Herbin 206092835
   Omri Milo 206093833
 */

package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    private static int[] WORKER_1_HOURS = new int[]{0, 0, 2, 0, 0, 5, 0, 0, 6, 0, 0, 0, 0, 9, 0, 0, 0, 6, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0};
    private static int[] WORKER_2_HOURS = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 5, 0, 0, 0, 0, 0, 7, 0, 0, 0, 2, 0, 0, 3, 0, 0, 0};
    private static int[] WORKER_3_HOURS = new int[]{2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0};


    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();

        Customer normalCustomer = new Customer("Roi", 123456798, "roi@gmail.com", "0548877963", 16);
        Customer studentCustomer = new Student("Maya", 236547896, "maya@gmail.com", "0547784569", 24, "MTA", LocalDate.parse("2021-06-01"));
        Customer soldierCustomer = new Soldier("Ben", 206098456, "ben@gmail.com", "0567894558", 19, LocalDate.parse("2021-06-02"));
        Customer veteranCustomer = new Veteran("Eitan", 204057896, "eitan@gmail.com", "0562478995", 68);
        customers.add(normalCustomer);
        customers.add(studentCustomer);
        customers.add(soldierCustomer);
        customers.add(veteranCustomer);
        Cinema newCinema = new Cinema("Yes Planet", employees, customers, 3, 3);

        HorrorMovie horrorMovie = new HorrorMovie("Baruti",90);
        Movie comedyMovie = new ComedyMovie("Samba",90);
        Movie thrillerMovie = new ThrillerMovie("Yasmin",90);

        newCinema.addMovie(horrorMovie);
        newCinema.addMovie(comedyMovie);
        newCinema.addMovie(thrillerMovie);



        Employee employee1 = new Employee("Dan", 203097477, "dan@gmail.com", "0526644789", 17, WORKER_1_HOURS, 30);
        Employee employee2 = new Employee("Gali", 205042365, "gali@gmail.com", "0545566987", 18, WORKER_2_HOURS, 32);
        Employee employee3 = new Employee("Tom", 205047898, "tom@gmail.com", "0563325789", 19, WORKER_3_HOURS, 34);

        newCinema.addEmployee(employee1);
        newCinema.addEmployee(employee2);
        newCinema.addEmployee(employee3);

        System.out.println(newCinema);

        newCinema.ticketSell(horrorMovie);
        newCinema.ticketSell(comedyMovie);
        newCinema.ticketSell(thrillerMovie);

        newCinema.popcornSell();
        newCinema.popcornSell();
        newCinema.popcornSell();

        newCinema.updateMovie(comedyMovie.getMovieName(), new ComedyMovie("samba2",91));


    }


}
