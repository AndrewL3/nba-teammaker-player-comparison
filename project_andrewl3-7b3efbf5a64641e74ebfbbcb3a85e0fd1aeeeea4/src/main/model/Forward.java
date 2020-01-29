package model;

public class Forward extends Player {




    public Forward(String name, String position, int age, float points, float fg, float threes, float ft,
                   float rebounds, float assists, float steals, float blocks, double value) {
        super(name, position, age, points, fg, threes, ft, rebounds, assists, steals, blocks, value);

    }


    // TODO: substitute different weightings based on the positions

    @Override
    public double scoreForPts(float points) {
        double pointsWeight = 2.5;
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
    public double scoreForRebs(float rebounds) {
        double rebsWeight = 1.5;
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






}
