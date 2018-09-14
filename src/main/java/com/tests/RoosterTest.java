package com.tests;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by BigdataArchitect on 2018-09-07.
 */
public class RoosterTest {

    public static void main(String[] args) {

            class DemoFuncional {
                final List<String> friends =
                        Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
                final List<String> editors =
                        Arrays.asList("Brian", "Jackie", "John", "Mike");
                final List<String> comrades =
                        Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");



                final long countFriendsWithStartN = friends.
                        stream()
                        .filter(name -> name.startsWith("N")).
                        count();
                void getCount(){
                    System.out.println("count : "+countFriendsWithStartN);

                }


                
                void getFriends(){
                    System.out.println("lambda expression 1");
                    friends.forEach((String name)-> System.out.println(name));

                    System.out.println("lambda expression 2");
                    friends.forEach(name -> System.out.println(name.toUpperCase()));

                    System.out.println("lambda expression 3");
                    friends.forEach(System.out::println);

                }
        }

        DemoFuncional demoFuncional = new DemoFuncional();
        //demoFuncional.getFriends();
        //demoFuncional.getCount();

        System.out.println("***********");


        List <Person> personList = Person.createRoster();

        printPersonsOlderThan(personList,20);

        System.out.println();
        System.out.println();

        printPersons(personList,new CheckPersonEligibleForSelectiveService());

        System.out.println();
        System.out.println();
        System.out.println("class anonymous");
        printPersons(personList,
                new CheckPerson() {
                    @Override
                    public boolean test(Person p) {
                        return p.getGender()== Person.Sex.MALE
                                && p.getAge()>=18 && p.getAge()<=25;
                    }
                });


        System.out.println("Lamdada classic");
        printPersons(personList,(Person p)-> p.getGender()== Person.Sex.MALE
                && p.getAge()>=18
                 && p.getAge()<=25);

        System.out.println("Lamdada with predicate");

        printPersonsWithPredicate(personList,p->p.getGender()== Person.Sex.MALE
        && p.getAge()>=18
        && p.getAge()<=25);

        System.out.println("Lamdada with predicate and consumer");

        processPersons(personList,
                p->p.getGender()== Person.Sex.MALE
                && p.getAge()>=18
                && p.getAge()<=25,
                p->p.printPerson1());
    }

    interface CheckPerson {
        boolean test(Person p);
    }


  /*  interface Predicate<T>{
        boolean test(T t);
    }*/




    static class CheckPersonEligibleForSelectiveService implements CheckPerson {
        @Override
        public boolean test(Person p) {
            return p.getGender()== Person.Sex.MALE && p.getAge()>=18 && p.getAge()<=45;
        }
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for(Person person : roster){
            if(person.getAge()>age)
                person.printPerson();
        }
    }


    //The following method prints members that match search criteria that you specify:

    public static void printPersons(
            List<Person> rooster, CheckPerson tester) {
        for (Person p : rooster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithPredicate(
            List<Person> rooster, Predicate<Person> tester){
        for (Person p : rooster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void processPersons(
            List<Person> rooster, Predicate<Person> tester, Consumer<Person> block){
                for(Person p : rooster){
                    if(tester.test(p)){
                        block.accept(p);
                    }
                }
    }


}
