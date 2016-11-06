package com.company;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Game CurrentGame;

    public static void main(String[] args) {
        CurrentGame = new Game();
        CurrentGame.startNewDefaultGame();
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
        seperator();
        goToTown();
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
        System.out.println("[]---------------------------------------------------------------------[]");
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
        String returnValue = in.nextLine();
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
            if(answer == 'y' || answer == 'Y'){
                inputIsCorrect = true;
                returnValue = true;
            }
            else if(answer == 'n' || answer == 'N'){
                inputIsCorrect = true;
                returnValue = false;
            }
            else {
                writeline("Please answer with Y or N");
            }
        }
        return returnValue;
    }

    private static int askQuestion(String question, String answer1, String answer2, String answer3, String answer4){
        int returnValue = 0;
        writeline(question);
        writeline("1) " + answer1);
        writeline("2) " + answer2);
        writeline("3) " + answer3);
        writeline("4) " + answer4);
        boolean inputIsCorrect = false;
        while(!inputIsCorrect){
            char answer = getInput().toCharArray()[0];
            if(answer == '1'){
                inputIsCorrect = true;
                returnValue = 1;
            }
            else if(answer == '2'){
                inputIsCorrect = true;
                returnValue = 2;
            }
            else if(answer == '3'){
                inputIsCorrect = true;
                returnValue = 3;
            }
            else if(answer == '4'){
                inputIsCorrect = true;
                returnValue = 4;
            }
            else {
                writeline("Please answer with 1, 2, 3 or 4");
            }
        }
        return returnValue;
    }

    private static int askQuestion(String question, String answer1, String answer2){
        int returnValue = 0;
        writeline(question);
        writeline("1) " + answer1);
        writeline("2) " + answer2);
        boolean inputIsCorrect = false;
        while(!inputIsCorrect){
            char answer = getInput().toCharArray()[0];
            if(answer == '1'){
                inputIsCorrect = true;
                returnValue = 1;
            }
            else if(answer == '2'){
                inputIsCorrect = true;
                returnValue = 2;
            }
            else {
                writeline("Please answer with 1 or 2");
            }
        }
        return returnValue;
    }

    private static void goToTown(){
        writeline(Player.getOurInstance().Name + " entered Paladia");
        seperator();
        int nextAction = askQuestion(
                "What do you wanna do?",
                "Go to Sleep",
                "Trade",
                "Manage your Inventory",
                "Enter the Tower of DOOM");
        switch(nextAction){
            case 1:
                CurrentGame.Town.goSleeping();
                writeline("Life completely recovered!");
                goToTown();
                break;
            case 2:
                //Not Implemented yet
                break;
            case 3:
                //Not Implemented yet
                break;
            case 4:
                seperator();
                enterDungeon();
                break;
        }
    }

    private static void enterDungeon(){
        Floor currentFloor = CurrentGame.Dungeon.nextFloor();
        boolean playerEscaped = false;
        writeline(Player.getOurInstance().Name + " entered the dungeon on floor number " + currentFloor.FloorNumber);
        seperator();
        while (!playerEscaped && currentFloor.SealIsActivated == true){
            if(currentFloor.FinishedBattles < 4)
                writeline("There are " + (5 - currentFloor.FinishedBattles) + " enemies left till you reach the floor boss.");
            else if (currentFloor.FinishedBattles == 4)
                writeline("There is one more enemy left till you reach the floor boss.");
            else
                writeline("The floor boss is in front of you.");
            if(askQuestion("Do you wanna keep on going forward?")){
                seperator();
                doCombat(currentFloor.nextCombat());
            }
            else {
                if(currentFloor.canLeave()){
                    seperator();
                    writeline("You were able to escape from the dungeon");
                    playerEscaped = true;
                    seperator();
                }
                else{
                    seperator();
                    writeline("You couldn't escape!");
                    seperator();
                    doCombat(currentFloor.nextCombat());
                }
            }
        }
        writeline("You went back to Paladia");
        seperator();
        goToTown();
    }

    private static void doCombat(Combat combat){
        writeline(combat.CurrentEnemy.Name + " wants to fight you!");
        boolean playerEscaped = false;
        while (!playerEscaped && combat.CurrentEnemy.Life >= 0 && Player.getOurInstance().Life >= 0){
            writeline(Player.getOurInstance().Name + " Life: " + Player.getOurInstance().Life + "/" + Player.getOurInstance().MaxLife + " | " + combat.CurrentEnemy.Name + " Life: " + combat.CurrentEnemy.Life + "/" + combat.CurrentEnemy.MaxLife);
            seperator();
            int nextMove = askQuestion(
                    "What do you wanna do?",
                    "Attack",
                    "Defend",
                    "Use a potion",
                    "Flee"
            );
            seperator();
            switch (nextMove){
                case 1:
                    displayCombatResult(combat.attack(), combat.CurrentEnemy.Name);
                    seperator();
                    break;
                case 2:
                    displayCombatResult(combat.defense(), combat.CurrentEnemy.Name);
                    seperator();
                    break;
                case 3:
                    ArrayList<Item> playerPotions = new ArrayList<Item>();
                    boolean potionWasChosen = false;
                    for (Item potion : Player.getOurInstance().Items) {
                        if(!potionWasChosen && potion.Type == Types.ItemType.Potion)
                            if(!playerPotions.contains(potion)){
                                playerPotions.add(potion);
                                if(askQuestion("Do you wanna use the following potion: " + potion.Name)){
                                    potionWasChosen = true;
                                    displayCombatResult(combat.usePotion(potion), combat.CurrentEnemy.Name);
                                }
                            }
                    }
                    if(!potionWasChosen){
                        if(playerPotions.size() == 0)
                            writeline("You don't own any potions");
                        else
                            writeline("You didn't choose a potion.");
                        displayCombatResult(combat.getAttacked(), combat.CurrentEnemy.Name);
                    }
                    seperator();
                    break;
                case 4:
                    CombatResult result = combat.flee();
                    displayCombatResult(result, combat.CurrentEnemy.Name);
                    seperator();
                    if(result.PlayerAction == Types.CombatActionResult.Escaped)
                        playerEscaped = true;

                    break;
            }
        }
        if(Player.getOurInstance().Life <= 0){
            writeline(new String[]{
                    "You died",
                    "GAME OVER",
                    "Enter anything to exit"
            });
            getInput();
            System.exit(0);
        }
    }

    private static void displayCombatResult(CombatResult result, String enemyName){
        writeline(new String[]{
                (result.EnemyHadFirstHit ? enemyName + " had first hit" : Player.getOurInstance().Name + " had first hit"),
                Player.getOurInstance().Name + ": "+ displayCombatActionResult(result.PlayerAction) + " | " + enemyName + ": " + displayCombatActionResult(result.EnemyAction)
        });
    }

    private static String displayCombatActionResult(Types.CombatActionResult result){
        if(result == null) {
            return "died in combat";
        }
        switch (result){
            case Attacked:
                return "attacked";
            case AttackMissed:
                return "missed with his attack";
            case Defended:
                return "went defence mode";
            case Escaped:
                return "escaped from the combat";
            case Evolved:
                return "evolved";
            case ItemMissed:
                return "tried to use an item, but missed";
            case ItemUsed:
                return "used an item";
            case Waited:
                return "didn't do anything";
            default:
                return "did an unknown move";
        }
    }
}
