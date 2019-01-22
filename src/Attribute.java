public class Attribute {
    private String name = "";
    private String type = "";
    private String access = "";
    private String comment = "";
    Attribute(String name, String type) {
        this.name = name;
        this.type = type;
    }
    Attribute(String name, String type, String access) {
        this.name = name;
        this.type = type;
        this.access = access;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
