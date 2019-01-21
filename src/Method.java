public class Method {
    private String name;
    private Attribute[] args;
    private String returnType;
    private String access = "";
    Method(String name, Attribute[] args, String returnType) {
        this.name = name;
        this.args = args;
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public Attribute[] getArgs() {
        return args;
    }

    public String getReturnType() {
        return returnType;
    }
}
