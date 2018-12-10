package ca.labs.androiddev.champlain.groupapplicationjb.Models;

public class Tip {

    private int id;

    private String description;

    public static final String TIPS_TABLE_NAME ="Product";
    public static final String TIPS_COL_DESCRIPTION="Description";

    public Tip(){}

    public Tip(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
