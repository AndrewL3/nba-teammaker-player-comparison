package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Data {


    private HashMap<String, Player> players = new HashMap<>();
    private List<Center> centerList = new ArrayList<>();
    private List<Forward> forwardList = new ArrayList<>();
    private List<Guard> guardList = new ArrayList<>();


    public void initializeData() throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("resources/nba stat.csv"));
        String row = read.readLine();
        while ((row = read.readLine()) != null) {
            List<String> f = new ArrayList<>(Arrays.asList(row.split(",")));
            f.remove(3);
            f.remove(3);
            int age = Integer.parseInt(f.get(2));
            float points = Float.parseFloat(f.get(3));
            float fg = Float.parseFloat(f.get(4));
            float threes = Float.parseFloat(f.get(5));
            float ft = Float.parseFloat(f.get(6));
            float rb = Float.parseFloat(f.get(7));
            float ast = Float.parseFloat(f.get(8));
            float stl = Float.parseFloat(f.get(9));
            float blk = Float.parseFloat(f.get(10));
            double value = assignValue(f, f.get(0), f.get(1), age, points, fg, threes, ft, rb, ast, stl, blk, 0);
            sortByPosition(f, f.get(0), f.get(1), age, points, fg, threes, ft, rb, ast, stl, blk, value);
        }
    }

    private double assignValue(List<String> fields, String name, String pos, int age, float points, float fg,
                               float threes, float ft, float rb, float ast, float stl, float blk, double value) {
        if (fields.get(1).equals("G")) {
            Guard player = new Guard(name, pos, age, points, fg, threes, ft, rb, ast, stl, blk, value);
            players.put(name,player);
            value = player.calculateValue();
        }
        if (fields.get(1).equals("F")) {
            Forward player = new Forward(name, pos, age, points, fg, threes, ft, rb, ast, stl, blk, value);
            players.put(name,player);
            value = player.calculateValue();
        }
        if (fields.get(1).equals("C")) {
            Center player = new Center(name, pos, age, points, fg, threes, ft, rb, ast, stl, blk, value);
            players.put(name,player);
            value = player.calculateValue();
        }
        return value;
    }

    private void sortByPosition(List<String> fields, String name, String pos, int age, float points, float fg,
                              float threes, float ft, float rb, float ast, float stl, float blk, double value) {
        if (fields.get(1).equals("G")) {
            Guard player = new Guard(name, pos, age, points, fg, threes, ft, rb, ast, stl, blk, value);
            guardList.add(player);
        }
        if (fields.get(1).equals("F")) {
            Forward player = new Forward(name, pos, age, points, fg, threes, ft, rb, ast, stl, blk, value);
            forwardList.add(player);
        }
        if (fields.get(1).equals("C")) {
            Center player = new Center(name, pos, age, points, fg, threes, ft, rb, ast, stl, blk, value);
            centerList.add(player);
        }
    }




    public void showData() {
        for (Guard guard : guardList) {
//            System.out.println(guard.name + " " + guard.age + " " + guard.position + " " + guard.points
//                    + " " + guard.fg + " " + guard.threes + " " + guard.ft + " " + guard.rebounds + " "
//                    + guard.assists + " " + guard.steals + " " + guard.blocks);
            System.out.println(guard.getName() + " " + guard.getValue());

        }

        for (Forward forward:forwardList) {
//            System.out.println(forward.name + " " + forward.age + " " + forward.position + " " + forward.points
//                    + " " + forward.fg + " " + forward.threes + " " + forward.ft + " " + forward.rebounds
//                    + " " + forward.assists + " " + forward.steals + " " + forward.blocks);
            System.out.println(forward.getName() + " " + forward.getValue());

        }

        for (Center center:centerList) {
//            System.out.println(center.name + " " + center.age + " " + center.position + " " + center.points
//                    + " " + center.fg + " " + center.threes + " " + center.ft + " " + center.rebounds
//                    + " " + center.assists + " " + center.steals + " " + center.blocks);
            System.out.println(center.getName() + " " + center.getValue());

        }
    }



    public List<Forward> getForwardList() {
        return forwardList;
    }

    public List<Guard> getGuardList() {
        return guardList;
    }

    public List<Center> getCenterList() {
        return centerList;
    }

    public HashMap<String, Player> getPlayers() {
        return players;
    }
}
