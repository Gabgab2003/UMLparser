public class Attribute {
    private String name = "";
    private String type = "";
    private String access = "";
    private String comment = "";
    private String defaultLiteral = "";
    Attribute(String name, String type) {
        this.name = name;
        this.type = type;
    }
    Attribute(String name, String type, String access) {
        this.name = name;
        this.type = type;
        this.access = access;
    }
    Attribute(String name, String type, String access, String defaultLiteral) {
        this.name = name;
        this.type = type;
        this.access = access;
        this.defaultLiteral = defaultLiteral;
    }

    public String getDefaultLiteral() {
        return defaultLiteral;
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

    public String getAccess() {
        return access;
    }

    public String getComment() {
        return comment;
    }
}
