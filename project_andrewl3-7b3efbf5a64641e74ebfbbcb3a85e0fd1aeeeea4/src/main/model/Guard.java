package model;

public class Guard extends Player {



    public Guard(String name, String position, int age, float points, float fg, float threes, float ft, float rebounds,
                 float assists, float steals, float blocks, double value) {
        super(name, position, age, points, fg, threes, ft, rebounds, assists, steals, blocks, value);


    }


    @Override
    public double scoreForPts(float points) {
        double pointsWeight = 2;
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
    public double scoreForThrees(float threes) {
        double threesWeight = 1.5;
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
    public double scoreForRebs(float rebounds) {
        double rebsWeight = 0.5;
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
        double astWeight = 2;
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
    public double scoreForStls(float steals) {
        double stlWeight = 1.5;
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

    @Override
    public double scoreForBlks(float blocks) {
        double blkWeight = 0.5;
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


