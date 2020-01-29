package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;


public class Game {

    private static int budget = 15;
    private static int i = 0;
    private static int gCount = 2;
    private static int fCount = 2;
    private static int cCount = 1;
    private static Data data = new Data();
    private static ArrayList<Player> compare = new ArrayList<>();
    private static ArrayList<Player> team = new ArrayList<>();
    private static ArrayList<String> display = new ArrayList<>();

    public static boolean loadMenu() {
        while (true) {
            System.out.println("Would you like to compare players or create a team?");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.equals("compare")) {
                comparePlayers();
                return false;
            }
            if (choice.equals("create")) {
                choosePlayers();
                return false;
            }
        }
    }

    public static void comparePlayers() {
        while (compare.size() < 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the FULL name of the first player you want to compare.");
            String p1 = scanner.nextLine();
            Player player1 = data.getPlayers().get(p1);
            if (data.getPlayers().containsKey(p1)) {
                if (!compare.contains(data.getPlayers().get(p1))) {
                    compare.add(data.getPlayers().get(p1));
                    System.out.println(compare.get(0).getName());
                } else {
                    System.out.println("You can't compare the same player!");
                }
            } else {
                System.out.println("Enter a valid player please.");
            }
        }
        while (compare.size() < 2) {
            System.out.println("Enter the FULL name of the second player you want to compare.");
            Scanner scanner = new Scanner(System.in);
            String p2 = scanner.nextLine();
            Player player2 = data.getPlayers().get(p2);
            if (data.getPlayers().containsKey(p2)) {
                if (!compare.contains(data.getPlayers().get(p2))) {
                    compare.add(data.getPlayers().get(p2));
                    System.out.println(compare.get(1).getName());
                } else {
                    System.out.println("You can't compare the same player!");
                }
            } else {
                System.out.println("Enter a valid player please.");
            }
        }
        comparison();
    }

    public static boolean comparison() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What stat do you want to compare?");
            String stat = scanner.nextLine();
            comparePoints(stat);
            compareRebounds(stat);
            compareAssists(stat);
            compareThrees(stat);
            compareFg(stat);
            compareFt(stat);
            compareSteals(stat);
            compareBlocks(stat);
        }
    }

    private static void comparePoints(String stat) {
        if (stat.equals("points")) {
            System.out.println(compare.get(0).getName() + "\n" + "Points: " + compare.get(0).getPoints()
                    + "\n" + "-----------------------------" + "\n" + compare.get(1).getName() + "\n" + "Points: "
                    + compare.get(1).getPoints());
        }
    }

    private static void compareRebounds(String stat) {
        if (stat.equals("rebounds")) {
            System.out.println(compare.get(0).getName() + "\n" + "Rebounds: " + compare.get(0).getRebounds()
                    + "\n" + "-----------------------------" + "\n" + compare.get(1).getName()
                    + "\n" + "Rebounds: " + compare.get(1).getRebounds());
        }
    }

    private static void compareAssists(String stat) {
        if (stat.equals("assists")) {
            System.out.println(compare.get(0).getName() + "\n" + "Assists: " + compare.get(0).getAssists()
                    + "\n" + "-----------------------------" + "\n" + compare.get(1).getName()
                    + "\n" + "Assists: " + compare.get(1).getAssists());
        }
    }

    private static void compareThrees(String stat) {
        if (stat.equals("threes")) {
            System.out.println(compare.get(0).getName() + "\n" + "Threes: " + compare.get(0).getThrees()
                    + "\n" + "-----------------------------" + "\n" + compare.get(1).getName()
                    + "\n" + "Threes: " + compare.get(1).getThrees());
        }
    }

    private static void compareFg(String stat) {
        if (stat.equals("fg")) {
            System.out.println(compare.get(0).getName() + "\n" + "Field Goal: " + compare.get(0).getFg()
                    + "\n" + "-----------------------------" + "\n" + compare.get(1).getName()
                    + "\n" + "Field Goal: " + compare.get(1).getFg() + "%");
        }
    }

    private static void compareFt(String stat) {
        if (stat.equals("ft")) {
            System.out.println(compare.get(0).getName() + "\n" + "Free Throw: " + compare.get(0).getFt()
                    + "\n" + "-----------------------------" + "\n" + compare.get(1).getName()
                    + "\n" + "Free Throw: " + compare.get(1).getFt() + "%");
        }
    }

    private static void compareSteals(String stat) {
        if (stat.equals("steals")) {
            System.out.println(compare.get(0).getName() + "\n" + "Steals: " + compare.get(0).getSteals()
                    + "\n" + "-----------------------------" + "\n" + compare.get(1).getName()
                    + "\n" + "Steals: " + compare.get(1).getSteals());
        }
    }

    private static void compareBlocks(String stat) {
        if (stat.equals("blocks")) {
            System.out.println(compare.get(0).getName() + "\n" + "Blocks: " + compare.get(0).getBlocks()
                    + "\n" + "-----------------------------" + "\n" + compare.get(1).getName()
                    + "\n" + "Blocks: " + compare.get(1).getBlocks());
        }
    }

    public static void choosePlayers() {
        while (team.size() < Ranges.MAXSIZE) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the FULL name of a player, say remove to remove a player, say team to see "
                    + "your current team, or say money to see how much you have left to spend.");
            String name = scanner.nextLine();
            if (name.equals("remove")) {
                removePlayer();
//            }
//            if (name.equals("team")) {
//                showTeam();
//            }
//            if (name.equals("money")) {
//                showBudget();
            } else {
                Player player = data.getPlayers().get(name);
                if (data.getPlayers().containsKey(name)) {
                    checkDuplicate(name, player);
                } else {
                    System.out.println("Enter a valid player please.");
                    System.out.println("You have $" + budget + " left.");
                    System.out.println(display);
                }
            }
        }
    }

    private static void checkDuplicate(String name, Player player) {
        if (!team.contains(player)) {
            positionLimit(player);
        } else {
            System.out.println(name + " is on the team already!");
            System.out.println(display);
            System.out.println("You have $" + budget + " left.");
        }
    }

    public static void removePlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the player you wish to remove.");
        String nm = scanner.nextLine();
        if (!team.contains(data.getPlayers().get(nm))) {
            System.out.println(nm + " is not on your team!");
        } else if (data.getPlayers().get(nm).getPosition().equals("G")) {
            gCount++;
            i--;
            budget = budget + data.getPlayers().get(nm).getMoney(data.getPlayers().get(nm).calculateValue());
            display.remove(nm + " $"
                    + data.getPlayers().get(nm).getMoney(data.getPlayers().get(nm).calculateValue()));
            team.remove(data.getPlayers().get(nm));
        } else if (data.getPlayers().get(nm).getPosition().equals("F")) {
            fCount++;
            i--;
            budget = budget + data.getPlayers().get(nm).getMoney(data.getPlayers().get(nm).calculateValue());
            display.remove(nm + " $"
                    + data.getPlayers().get(nm).getMoney(data.getPlayers().get(nm).calculateValue()));
            team.remove(data.getPlayers().get(nm));
        } else if (data.getPlayers().get(nm).getPosition().equals("C")) {
            cCount++;
            i--;
            budget = budget + data.getPlayers().get(nm).getMoney(data.getPlayers().get(nm).calculateValue());
            display.remove(nm + " $"
                    + data.getPlayers().get(nm).getMoney(data.getPlayers().get(nm).calculateValue()));
            team.remove(data.getPlayers().get(nm));
        }
    }

    private static void positionLimit(Player player) {
        guardLimit(player);
        forwardLimit(player);
        centerLimit(player);
    }

    private static void centerLimit(Player player) {
        if (player.getPosition().equals("C")) {
            if (cCount == 0) {
                System.out.println("Too many centers!");
                System.out.println(display);
                System.out.println("You have $" + budget + " left.");
            } else {
                if (budget < player.getMoney((player.calculateValue()))) {
                    System.out.println("You don't have enough money!");
                } else {
                    budget = budget - player.getMoney((player.calculateValue()));
                    addPlayer(player);
                    cCount--;
                    i++;
                }
            }
        }
    }

    private static void forwardLimit(Player player) {
        if (player.getPosition().equals("F")) {
            if (fCount == 0) {
                System.out.println("Too many forwards!");
                System.out.println(display);
                System.out.println("You have $" + budget + " left.");
            } else {
                if (budget < player.getMoney((player.calculateValue()))) {
                    System.out.println("You don't have enough money!");
                } else {
                    budget = budget - player.getMoney((player.calculateValue()));
                    addPlayer(player);
                    fCount--;
                    i++;
                }
            }
        }
    }

    private static void guardLimit(Player player) {
        if (player.getPosition().equals("G")) {
            if (gCount == 0) {
                System.out.println("Too many guards!");
                System.out.println(display);
                System.out.println("You have $" + budget + " left.");
            } else {
                if (budget < player.getMoney((player.calculateValue()))) {
                    System.out.println("You don't have enough money!");
                } else {
                    budget = budget - player.getMoney((player.calculateValue()));
                    addPlayer(player);
                    gCount--;
                    i++;
                }
            }
        }
    }

    private static void addPlayer(Player player) {
        team.add(player);
        display.add(team.get(i).getName() + " $" + player.getMoney((player.calculateValue())));
        System.out.println(display);
        System.out.println("You have $" + budget + " left.");
        if (team.size() < Ranges.MAXSIZE) {
            System.out.println("Enter " + (Ranges.MAXSIZE - team.size()) + " more player(s).");
        } else {
            System.out.println("You've completed your team!");
        }
    }

    public static void showTeam() {
        System.out.println(display);
    }

    public static void showBudget() {
        System.out.println("You have $" + budget + " remaining.");
    }

    public static void main(String[] args) throws IOException {
        data.initializeData();
        data.showData();
        loadMenu();
    }
}







