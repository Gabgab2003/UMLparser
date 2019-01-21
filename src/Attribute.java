public class Attribute {
    private String name;
    private String type;
    private String access = "";
    Attribute(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
