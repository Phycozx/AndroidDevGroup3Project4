package Models;

public class Tips {
    private int id;
    private String description;

    public static final String Tips_TABLE_NAME = "Tip";
    public static final String TIPS_COL_ID = "Id";
    public static final String TIPS_COL_DESCRIPTION="Description";

    public Tips(){}

    public Tips(String description) {
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
