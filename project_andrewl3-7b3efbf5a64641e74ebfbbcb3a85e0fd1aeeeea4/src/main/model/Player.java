package model;


public abstract class Player {

    private String name;
    private String position;
    private int age;
    private float points;
    private float fg;
    private float threes;
    private float ft;
    private float rebounds;
    private float assists;
    private float steals;
    private float blocks;
    private double value;

    int divisor = 4;

    public Player(String name, String position, int age, float points, float fg, float threes, float ft, float rebounds,
                  float assists, float steals, float blocks, double value) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.points = points;
        this.fg = fg;
        this.threes = threes;
        this.ft = ft;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.value = value;

    }

    public double scoreForPts(float points) {
        double pointsWeight = 1;
        if (points < Ranges.PTSRANGE1) {
            return (pointsWeight / divisor);
        } else if (points < Ranges.PTSRANGE2) {
            return (pointsWeight / divisor) * 2;
        } else if (points < Ranges.PTSRANGE3) {
            return (pointsWeight / divisor) * 3;
        } else {
            return (pointsWeight / divisor) * 4;
        }
    }

    public double scoreForFg(float fg) {
        int fgWeight = 1;
        if (fg < Ranges.FGRANGE1) {
            return (fgWeight / divisor);
        } else if (fg < Ranges.FGRANGE2) {
            return (fgWeight / divisor) * 2;
        } else if (fg < Ranges.FGRANGE3) {
            return (fgWeight / divisor) * 3;
        } else {
            return (fgWeight / divisor) * 4;
        }
    }

    public double scoreForThrees(float threes) {
        double threesWeight = 1;
        if (threes < Ranges.THREESRANGE1) {
            return (threesWeight / divisor);
        } else if (threes < Ranges.THREESRANGE2) {
            return (threesWeight / divisor) * 2;
        } else if (threes < Ranges.THREESRANGE3) {
            return (threesWeight / divisor) * 3;
        } else {
            return (threesWeight / divisor) * 4;
        }
    }

    public double scoreForFt(float ft) {
        double ftWeight = 1;
        if (ft < Ranges.FTRANGE1) {
            return (ftWeight / divisor);
        } else if (ft < Ranges.FTRANGE2) {
            return (ftWeight / divisor) * 2;
        } else if (ft < Ranges.FTRANGE3) {
            return (ftWeight / divisor) * 3;
        } else {
            return (ftWeight / divisor) * 4;
        }
    }

    public double scoreForRebs(float rebounds) {
        double rebsWeight = 1;
        if (rebounds < Ranges.RBSRANGE1) {
            return (rebsWeight / divisor);
        } else if (rebounds < Ranges.RBSRANGE2) {
            return (rebsWeight / divisor) * 2;
        } else if (rebounds < Ranges.RBSRANGE3) {
            return (rebsWeight / divisor) * 3;
        } else {
            return (rebsWeight / divisor) * 4;
        }
    }

    public double scoreForAsts(float assists) {
        double astWeight = 1;
        if (assists < Ranges.ASTSRANGE1) {
            return (astWeight / divisor);
        } else if (assists < Ranges.ASTSRANGE2) {
            return (astWeight / divisor) * 2;
        } else if (assists < Ranges.ASTSRANGE3) {
            return (astWeight / divisor) * 3;
        } else {
            return (astWeight / divisor) * 4;
        }
    }

    public double scoreForStls(float steals) {
        double stlWeight = 1;
        if (steals < Ranges.STLSRANGE1) {
            return (stlWeight / divisor);
        } else if (steals < Ranges.STLSRANGE2) {
            return (stlWeight / divisor) * 2;
        } else if (steals < Ranges.STLSRANGE3) {
            return (stlWeight / divisor) * 3;
        } else {
            return (stlWeight / divisor) * 4;
        }
    }

    public double scoreForBlks(float blocks) {
        double blkWeight = 1;
        if (blocks < Ranges.BLOCKSRANGE1) {
            return (blkWeight / divisor);
        } else if (blocks < Ranges.BLOCKSRANGE2) {
            return (blkWeight / divisor) * 2;
        } else if (blocks < Ranges.BLOCKSRANGE3) {
            return (blkWeight / divisor) * 3;
        } else {
            return (blkWeight / divisor) * 4;
        }
    }

    public double calculateValue() {
        return scoreForPts(points) + scoreForFt(ft) + scoreForAsts(assists) + scoreForBlks(blocks) + scoreForFg(fg)
                + scoreForRebs(rebounds) + scoreForStls(steals) + scoreForThrees(threes);
    }

    public int calculateMoney(double value) {
        if (value < Ranges.ONEDOLLARS) {
            return 1;
        }
        if (value < Ranges.TWODOLLARS) {
            return 2;
        }
        if (value < Ranges.THREEDOLLARS) {
            return 3;
        }
        if (value < Ranges.FOURDOLLARS) {
            return 4;
        } else {
            return 5;
        }
    }

    public int getMoney(double value) {
        return calculateMoney(value);
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public String getPosition() {
        return position;
    }

    public float getPoints() {
        return points;
    }

    public float getFg() {
        return fg;
    }

    public float getThrees() {
        return threes;
    }

    public float getFt() {
        return ft;
    }

    public float getRebounds() {
        return rebounds;
    }

    public float getAssists() {
        return assists;
    }

    public float getSteals() {
        return steals;
    }

    public float getBlocks() {
        return blocks;
    }

}

