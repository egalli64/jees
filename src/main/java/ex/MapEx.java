package ex;

import java.util.Map;
import java.util.Set;

public class MapEx {
    private Map<?, ?> teams;

    public MapEx() {
        this.teams = null;
    }

    public void addTeam(String name) {
    }

    public Set<String> getTeam(String name) {
        return null;
    }

    public void addPartecipant(String team, String name) {

    }

    public static void main(String[] args) {
        MapEx me = new MapEx();
        me.addTeam("blue");

        Set<String> blueTeam = me.getTeam("blue");

        me.addPartecipant("blue", "Giovanni");
    }
}
