public class Method {
    private String name = "";
    private Attribute[] args;
    private String type = "";
    private String access = "";
    private String comment = "";
    Method(String name, Attribute[] args, String type) {
        this.name = name;
        this.args = args;
        this.type = type;
        this.access = "";
    }
    Method(String name, Attribute[] args, String returnType, String access) {
        this.name = name;
        this.args = args;
        this.type = returnType;
        this.access = access;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public Attribute[] getArgs() {
        return args;
    }

    public String getType() {
        return type;
    }
}
