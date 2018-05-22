package concurrent;

/**
 * Created by changheng on 17/11/23.
 */
public enum OxWitch {
    WEST("west11"),
    EAST("east22"),
    NORTH("north33"),
    SOUTH("south44");

    private String description;
    OxWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OxWitch oxWitch : OxWitch.values()) {
            System.out.println(oxWitch.getDescription());
            System.out.println(oxWitch);
        }
    }

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }
}
