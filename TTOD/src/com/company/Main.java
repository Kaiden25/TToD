package com.company;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;
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
        boolean gettingInput = true;
        String returnValue = "";
        while(gettingInput){
            System.out.print("  ");
            Scanner in = new Scanner(System.in);
            returnValue = in.nextLine();
            if(!doCheat(returnValue))
                gettingInput = false;
        }
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
            String input = getInput();
            if(input.length() != 0){
                char answer = input.toCharArray()[0];
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
            else
                writeline("Please don't just press enter");
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
            String input = getInput();
            if(input.length() != 0){
                char answer = input.toCharArray()[0];
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
            else
                writeline("Please give an input before pressing enter");
        }
        return returnValue;
    }

    private static int getNumber(int maxCount){
        boolean inputIsCorrect = false;
        int result = 0;
        while(!inputIsCorrect) {
            try{
                result = Integer.parseInt(getInput());
                if(result != 0 && result <= maxCount)
                    inputIsCorrect = true;
                else
                    writeline("Enter a number between 1 and " + maxCount + "!");
            }
            catch (Exception ex){
                writeline("Please enter a number!");
            }
        }
        return result;
    }

    private static void goToTown(){
        writeline(Player.getOurInstance().Name + " entered Paladia");
        seperator();
        int nextAction = askQuestion(
                "What do you wanna do?",
                "Go to Sleep",
                "Trade",
                "Change equipment",
                "Enter the Tower of DOOM");
        switch(nextAction){
            case 1:
                seperator();
                CurrentGame.Town.goSleeping();
                writeline("Life completely recovered!");
                seperator();
                goToTown();
                break;
            case 2:
                seperator();
                doTrading();
                break;
            case 3:
                ArrayList<Item> weapons = new ArrayList<Item>();
                ArrayList<Item> armor = new ArrayList<Item>();
                if(Player.getOurInstance().Items.size() > 0) {
                    for (Item item: Player.getOurInstance().Items) {
                        switch (item.Type){
                            case Weapon:
                                weapons.add(item);
                                break;
                            case Armor:
                                armor.add(item);
                                break;
                            default:
                                break;
                        }
                    }
                    seperator();
                    if(armor.size() > 0) {
                        Item newArmor = (armor.size() > 1 ? armor.get(new Random().nextInt(armor.size() - 1)) : armor.get(0));
                        Player.getOurInstance().setArmor(newArmor);
                        writeline("Your new armor is: " + newArmor.Name);
                    }
                    else
                        writeline("You don't have any armor in your inventory!");
                    if(weapons.size() > 0) {
                        Item newWeapon = (weapons.size() > 1 ? weapons.get(new Random().nextInt(weapons.size()) - 1) : weapons.get(0));
                        Player.getOurInstance().setWeapon(newWeapon);
                        writeline("Your new armor is: " + newWeapon.Name);
                    }
                    else
                        writeline("You don't have any weapons in your inventory!");
                }
                else
                    writeline("You don't have any items!");
                seperator();
                goToTown();
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
        if(Player.getOurInstance().FloorCount == 8){
            writeline(new String[]{
                    "Thank you for saving Paladia, you are a true hero!",
                    "We shall remember your name forever, and ever!",
                    Player.getOurInstance().Name + " the mighty hero!!!"
            });
            seperator();
            getInput();
            rollCredits();
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

    private static void rollCredits(){
        writeline(new String[]{
                "Thank you for playing our game!",
                "We hope you had FUN :)"
        });
        seperator();
        writeline("Best wishes from the developers:");
        seperator();
        writeline(new String[]{
                "Michael van der Heide, Lead developer, Documentation & Idea",
                "Enrico Chatelin, Development, Documentation, Idea & Testing",
                "Paolo Stieger, Testing & Documentation"
        });
        seperator();
        writeline("Also a huge thank you to our beta testers:");
        seperator();
        writeline(new String[]{
                "Vincenz Ladner"
        });
        seperator();
        writeline("This Project was developed for educational purposes at the Technical vocational school Zurich (TBZ).");
        writeline("http://www.tbz.ch/");
        seperator();
        writeline("Press enter to exit...");
        getInput();
        System.exit(0);
    }

    private static void doTrading(){
        if(askQuestion("Do you wanna trade with a random trader?")){
            seperator();
            boolean tradeIsActive = true;
            Trader currentTrader = CurrentGame.Town.Traders.get(new Random().nextInt(CurrentGame.Town.Traders.size() -1));
            writeline("Hello, my name is " + currentTrader.Name + ", nice to meet you.");
            seperator();
            while(tradeIsActive){
                writeline(Player.getOurInstance().Name + "'s GEIL: " + Player.getOurInstance().GEIL + " | " + currentTrader.Name + "'s GEIL:" + currentTrader.GEIL);
                seperator();
                int nextMove = askQuestion(
                        "What do you wanna do?",
                        "Buy something",
                        "Sell something",
                        "Talk to trader",
                        "Go back to town"
                );
                seperator();
                switch (nextMove){
                    case 1:
                        writeline("I have the following items:");
                        seperator();
                        int i = 1;
                        for (Item item:currentTrader.Items) {
                            writeline(i + ") " + item.Name + " : " + currentTrader.getItemBuyPrice(item) + " GEIL");
                            i++;
                        }
                        seperator();
                        if(askQuestion("Do you wanna buy an item?")){
                            seperator();
                            writeline("Which number?");
                            Item itemToBuy = currentTrader.Items.get(getNumber(currentTrader.Items.size()) - 1);
                            seperator();
                            switch(currentTrader.buyItem(itemToBuy)){
                                case Successful:
                                    writeline("You bought: " + itemToBuy.Name);
                                    break;
                                case NotEnoughSpace:
                                    writeline("It seems like you don't have enough space in your inventory");
                                    break;
                                case NotEnoughMoney:
                                    writeline("You don't have enough money");
                                    break;
                                default:
                                    writeline("It seems like you don't have enough space in your inventory");
                                    break;
                            }
                        }
                        seperator();
                        break;
                    case 2:
                        if(Player.getOurInstance().Items.size() != 0){
                            writeline("You have the following items:");
                            seperator();
                            int ii = 1;
                            for (Item item:Player.getOurInstance().Items) {
                                writeline(ii + ") " + item.Name + " : " + currentTrader.getItemSellPrice(item) + " GEIL");
                                ii++;
                            }
                            seperator();
                            if(askQuestion("Do you wanna sell an item?")){
                                seperator();
                                writeline("Which number?");
                                Item itemToBuy = Player.getOurInstance().Items.get(getNumber(Player.getOurInstance().Items.size()) - 1);
                                currentTrader.sellItem(itemToBuy);
                                seperator();
                                writeline("You sold: " + itemToBuy.Name + " for " + currentTrader.getItemSellPrice(itemToBuy) + " GEIL");
                            }
                        }
                        else
                            writeline("You don't have any items to sell.");
                        seperator();
                        break;
                    case 3:
                        int talkInt = new Random().nextInt(13);
                        switch (talkInt){
                            case 1:
                                writeline("I used to be a hero like you, but then i took a tower to the knee.");
                                break;
                            case 2:
                                writeline("GEIL is the currency in this kingdom");
                                break;
                            case 3:
                                writeline(new String[]{
                                        "Goran the 'Lich' was one of the builders of this city.",
                                        "But one day he touched a dark stone and got evil.",
                                        "We don't exactly know what happened afterwards..."
                                });
                                break;
                            case 4:
                                writeline("One does not simply walk into the tower");
                                break;
                            case 5:
                                writeline("'Crash the goblin king' hates it, when people kill his wife 'Lucine'");
                                break;
                            case 6:
                                writeline("'The undead dragon of DOOM' wasn't allowed to take part in a particular FPS.");
                                break;
                            case 7:
                                writeline(new String[]{
                                        "Don't even try, you'll never be as cool as",
                                        "'Greethim the gatekeeper unidragon'!"
                                });
                                break;
                            case 8:
                                writeline(new String[]{
                                        "When 'Arthur the forgotten King' was drunk, he always",
                                        "told us some stupid fairytails about a legendary sword",
                                        "which he found in a stone, or something.",
                                        "He was really desperate for attention."
                                });
                                break;
                            case 9:
                                writeline(new String[]{
                                        "'The mighty unicorn Goldfish' is actually just a",
                                        " goldfish with an ice cream cone on his head"
                                });
                                break;
                            case 10:
                                writeline(new String[]{
                                        "Legends say, that 'Ingrid the shadow priestess' always",
                                        "fell from the kids horse when she tried to ride it."
                                });
                                break;
                            case 11:
                                writeline("Don't you dare to kill a chicken in our city!");
                                break;
                            case 12:
                                writeline( "Well, that whole thing with this tower definitely escalated quickly");
                                break;
                            default:
                                writeline("Hey i'm a villager, talk to me and i'll give you some advice.");
                                break;
                        }
                        seperator();
                        break;
                    case 4:
                    default:
                        writeline("Okay, than have a nice day");
                        tradeIsActive = false;
                        break;
                }
            }
        }
        seperator();
        writeline("You went back");
        goToTown();
    }

    private static boolean doCheat(String cheatcode){
        boolean wasCheat = false;
        if(cheatcode != null){
            if(cheatcode.equals("cn")) {
                namePlayer();
                writeline("Cheat activated");
                wasCheat = true;
            }
            if(cheatcode.equals("heal")) {
                Player.getOurInstance().Life = Player.getOurInstance().MaxLife;
                writeline("Cheat activated");
                wasCheat = true;
            }
            if(cheatcode.equals("tgm")) {
                CurrentGame.initializeGodModePlayer();
                writeline("Cheat activated");
                wasCheat = true;
            }
            if(cheatcode.equals("motherload")) {
                Player.getOurInstance().GEIL += 10000;
                writeline("Cheat activated");
                wasCheat = true;
            }
            if(cheatcode.equals("exit")) {
                wasCheat = true;
                System.exit(0);
            }
            if(cheatcode.equals("credits")) {
                wasCheat = true;
                rollCredits();
            }
            if(cheatcode.equals("skip1")) {
                Player.getOurInstance().FloorCount++;
                writeline("Cheat activated");
                wasCheat = true;
            }
            if(cheatcode.equals("skipend")) {
                Player.getOurInstance().FloorCount = 7;
                writeline("Cheat activated");
                wasCheat = true;
            }
        }
        return wasCheat;
    }
}
