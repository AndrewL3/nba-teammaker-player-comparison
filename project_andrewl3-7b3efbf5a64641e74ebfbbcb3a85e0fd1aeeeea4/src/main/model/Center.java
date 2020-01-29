package model;

public class Center extends Player {


    public Center(String name, String position, int age, float points, float fg, float threes, float ft, float rebounds,
                  float assists, float steals, float blocks, double value) {
        super(name, position, age, points, fg, threes, ft, rebounds, assists, steals, blocks, value);

    }


    // TODO: substitute in correct weightings

    @Override
    public double scoreForPts(float points) {
        double pointsWeight = 1.5;
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

    @Override
    public double scoreForFg(float fg) {
        int fgWeight = 2;
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

    @Override
    public double scoreForThrees(float threes) {
        double threesWeight = 0.5;
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

    @Override
    public double scoreForFt(float ft) {
        double ftWeight = 0.5;
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

    @Override
    public double scoreForRebs(float rebounds) {
        double rebsWeight = 2;
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

    @Override
    public double scoreForAsts(float assists) {
        double astWeight = 0.5;
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


    @Override
    public double scoreForBlks(float blocks) {
        double blkWeight = 2;
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


}




