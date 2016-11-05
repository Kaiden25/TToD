package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        seperator();
        writeline("Welcome to TTOD");
        seperator();
        namePlayer();
        seperator();
        writeline(new String[]{
                "Welcome to the Kingdom of Angelfall",
                "You are the mighty hero: " + Player.getOurInstance().Name,
                "Please save the village of Paladia from the evil Tower of Doom"
        });
        seperator();
        if(askQuestion("Do you wanna learn more?")){
            seperator();
            writeline(new String[]{
                    "The mighty wizard 'Goran the Lich' has spawned an 8 floor tower",
                    "at the gate to the little village Paladia. The people of Paladia",
                    "are scared, because the creatures of said tower are attacking them.",
                    "Because the Tower was so scary, they called it the 'TOWER OF DOOM'.",
                    "To help the people of Paladia you have to fight the boss of every",
                    "floor. Once the boss is beaten you can remove the seal and go on",
                    "to the next floor. We need you to remove all the seals. If you do",
                    "that, we can finally live in peace again."
            });
        }
        seperator();
        writeline(new String[] {
                "And so, the hero traveled to Paladia",
                "The adventure began..."
        });
    }

    private static void writeline(String[] textlines){
        for (String s: textlines) {
            writeline(s);
        }
    }

    private static void writeline(String text){
        System.out.println("  " + text);
    }

    private static void seperator(){
        System.out.println("[]------------------------------------------------------------------[]");
    }

    private static void namePlayer(){
        writeline("Please enter your name: ");
        boolean playerNameIsSet = false;
        while(!playerNameIsSet){
            String name = getInput();
            if(name.isEmpty()){
               writeline("Please enter your name again");
            }
            else {
                Player.getOurInstance().Name = name;
                playerNameIsSet = true;
            }
        }
    }

    private static String getInput(){
        System.out.print("  ");
        Scanner in = new Scanner(System.in);
        String returnValue = in.next();
        if(returnValue != null)
            return returnValue;
        else
            return "";
    }

    private static boolean askQuestion(String question) {
        boolean returnValue = false;
        writeline(question);
        writeline("Y|N");
        boolean inputIsCorrect = false;
        while(!inputIsCorrect){
            char answer = getInput().toCharArray()[0];
            if(answer == 'y'){
                inputIsCorrect = true;
                returnValue = true;
            }
            else if(answer == 'n'){
                inputIsCorrect = true;
                returnValue = false;
            }
            else {
                writeline("Please answer with Y or N");
            }
        }
        return returnValue;
    }
}
