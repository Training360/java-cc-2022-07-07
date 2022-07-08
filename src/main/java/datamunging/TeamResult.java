package datamunging;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TeamResult implements Values {

    String team;

    int forGoals;

    int againstGoals;

    @Override
    public int getDifference() {
        return Math.abs(forGoals - againstGoals);
    }

    @Override
    public String getLabel() {
        return team;
    }
}
