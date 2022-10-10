package com.jetbrains;

import java.util.Scanner;  // Import the Scanner class
import java.util.Stack; // Import stacks

class Information {
    String name;
    int age;
    boolean adult;
}

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the chat box. \n");
        askbasics();
        int age = 0;
        // while loop to give the user many attempts
        while (age==0) {
            String basics2 = askbasics2();
            // this will check if the given age in askbasics() is a number
            try {
                // this turns the String age from askbasics2() into an integer
                age = Integer.parseInt(basics2);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please try again and this time ENTER A NUMBER FOR YOUR AGE!");
            }
        }

        // majority is the boolean value denoting whether the user is an adult or not (true is adult)
        boolean majority = agecalc(age);
        //this holds the users name an Array
        final String []namers = rays();

        Information persona = setting(namers, majority, age);
        System.out.println("Your name is "+naming(persona)+" and your age is "+aging(persona));


    // array arguments
        Scanner keyboard2 = new Scanner(System.in);

        System.out.println("How many family members do you have?");
        int members = keyboard2.nextInt();
        System.out.println("What are their names and ages?\n");

        String[] familynams = new String[members];
        int[] familyages = new int[members];

        for (int i=0;i<members;i++){
            familynams[i]= takefamilyname();
            familyages[i]= takefamilyage();
        }
        int av = (int) family(members,familyages,familynams);
        System.out.println("The average age in your family is around "+av);

        recurse();
        nest();

        System.out.println("Gotta go now. Goodbye!");
        System.exit(0);
    }



//        Level  6 acheived
//        Yunus Khan
//        5/11/2021
//        Chatbox

    /* Summary of the Question
 Write a chat bot procedural program that can have realistic conversations with people about a specific topic
 (eg films, football, musicals, pop music, …) */

// The literate program development

/* Welcome

 What it does
Welcomes the user to the chat box and asks them their name and more details about the user

 Implementation (how it works)
uses the System.out function to output a welcome message then uses the Scanner function to input data about the user. */

    public static String welcome() {
        String name;
        System.out.println("What is your name?");
        Scanner keyboard = new Scanner(System.in);
        name = keyboard.nextLine();
        System.out.println("Hello " + name);
        return name;
    }


/*-- Askbasics --
        What it does
        Asks the user basic questions about animals and their opinion of the program.

        Implementation (how it works)
        Outputs questions and uses if statements to determine a response*/

    public static void askbasics() {
        String name = welcome();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Do you like animals? " + name);
        String resp1 = keyboard.nextLine();
        if (resp1.equals("yes")) {
            System.out.println("So do I! I like cats but my dad is allergic \n Do you like dogs?");
        } else {
            System.out.println("Ah I see. I don't quite like animals.\nThey smell and make everything dirty. Do you agree?");
        }
        String resp2 = keyboard.nextLine();
        if (resp2.equals("yes")) {
            System.out.println("Same");
        }
        if (resp2.equals("no")) {
            System.out.println("Ah I see");
        } else {
            System.out.println("Sometimes I wonder does it work?");
        }
        String resp3 = keyboard.nextLine();
        if (resp3.contains("what") || resp3.contains("huh")) {
            System.out.println("The program. I wonder if the program works well \n Do you think it works well?");
        } else {
            System.out.println("The human doesn't work\nAm I talking to a human?");
        }
        String resp4 = keyboard.nextLine();
        if (resp4.equals("yes")) {
            System.out.println("Well I guess I'm okay then...");
        } else {
            System.out.println("WELL THEN THAT'S WORRYINGS ISN'T IT! " + name.toUpperCase());
        }
    }

    /*-- Askbasics2 --
            What it does
            Asks the user basic questions about their hobbies and interests as well as their age

            Implementation (how it works)
            Outputs questions and takes note of all the responses for later functions*/

    public static String askbasics2() {
        System.out.println("Do you play sports ?");
        Scanner keyboard = new Scanner(System.in);
        String resp5 = keyboard.nextLine();
        if (resp5.equals("yes")) {
            System.out.println("Nice. I play Volleyball.\nWhat sports do you play?");
            String resp6 = keyboard.nextLine(); //sport
            System.out.println("Ah nice. I like " + resp6 + " as well.");
        } else {
            System.out.print("Ah okay.");
        }
        System.out.println("How old are you?");
        // will make age into an integer after
        String age = keyboard.nextLine();
        return age;
    }

    /* agecalc

#### What it does
 Determines if the user is above 18
#### Implementation (how it works)
 takes in the parameter age as an integer value and uses if statements to determine whether
 the user is an adult or a child */
    public static boolean agecalc(int age) {
        boolean verif;
        // to verify whether they are above the required age
        if (age > 17) {
            verif = true;
            System.out.println("It would seem that you are an adult");
        } else {
            verif = false;
            System.out.println("It would seem that you are a child");
        }
        return verif;
    }


    // level 4 Records
    //Record
    /* #### What it does
    creates a record of the users name age and sports played if any and then holds that record
    Implementation (how it works)
    create a new class of records and then input the values using functions

    its at the top
    this part is where i put the method that creates the actual class and its items */
    public static String takefamilyname(){
        System.out.println("Enter your family members name: ");
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.nextLine();
        return name;
    }
    public static int takefamilyage(){
        System.out.println("Enter their age: ");
        Scanner keyboard = new Scanner(System.in);
        int age = keyboard.nextInt();
        return age;
    }

    // level 5 Arrays
    //Rays
    /* #### What it does
    Takes in the name and age of the user from other methods and then turns them into an array.
    also takes in their sport if they play one
    Implementation (how it works)
    Instantiates the array and then adds to it */
    public static String[] rays() {
        String[] names = new String[2];
        System.out.println("Sorry I have a bad memory. \nWhat is your name again? ");
        names[0] = welcome();
        System.out.println("And again I am terribly sorry. \n My head hurts and I've forgotten some information about you!");
        names[1]=askbasics2(); //this is the age
        return names;
    }

    //getters
    private static int aging(Information X)
    {
        return X.age;
    }
    private static String naming(Information X)
    {
        return X.name;
    }
    private static Boolean majorising(Information X)
    {
        return X.adult;
    }

    //setters
    public static Information setting(String[] namers, boolean majority, int age){
        Information persona = new Information();
        persona.name= namers[0];
        persona.adult= majority;
        persona.age= age;
        return persona;
    }

    // array arguments
    public static double family(int len, int []familyAges, String []familyNames){
        double average=0;
        int sum =0;
        for (int x=0; x<len; x++){
            sum+=familyAges[x];
        }
        average = ((sum)/len);
        return average;
    }


    //level 6 loops within loop
    //recurse
    /* #### What it does
    asks questions to the user and keeps looping them around until the come out like a verbal maze
    Implementation (how it works)
    recursive loops with statements */

    public static void recurse(){
        boolean again = true;
        while (again) {
            again = false;
            Stack words = new Stack(); // here is my abstract data type (a stack)
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Welcome to the game of names\n" +
                    "In this game you must type many words and enter the same words again in reverse order\n" +
                    "For example if I entered 'Lilly' then 'farm' then 'egg' then I must enter 'egg' then 'farm' then 'Lilly'\n" +
                    "How many round do you want to play? ");
            int rounds = keyboard.nextInt();
            for (int i = 0; i < rounds; i++) {
                System.out.println("Enter another word: ");
                Scanner keyboard2 = new Scanner(System.in);
                String input = keyboard2.nextLine();
                words.push(input);
            }
            System.out.println("Entries over!");
            for (int j = rounds; j != 0; j--) {
                System.out.println("Enter word " + j + "\n Remember it needs to be in reverse order.");
                Scanner keyboard3 = new Scanner(System.in);
                String input2 = keyboard3.nextLine();
                String top = String.valueOf(words.peek());
                if (top.equals(input2)) {
                    System.out.println("Well done\n NEXT!");
                    words.pop();
                } else {
                    System.out.println("You have entered incorrectly!");
                    break;
                }
                System.out.println("You win!");
            }
            System.out.println("Do you want to play again?");
            Scanner keyboard4 = new Scanner(System.in);
            String sentry = keyboard4.nextLine();
            if (sentry.equals("yes")) {
                again = true;
            }
        }
    }

    //this is my nested loop
    public static void nest(){
        System.out.println("Hey! Would you like to make a pattern of numbers\nJust enter how many rows you want");
        Scanner keyboard = new Scanner(System.in);
        int rows = keyboard.nextInt();
        //nested for loop
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }
}
