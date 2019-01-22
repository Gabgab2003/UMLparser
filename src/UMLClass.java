public class UMLClass {
    private String name;
    private Attribute[] attributes = new Attribute[0];
    private Method[] methods = new Method[0];
    UMLClass(String name, Attribute[] attributes, Method[] methods) {
        this.name = name;
        this.attributes = attributes;
        this.methods = methods;
    }
    UMLClass() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute[] attributes) {
        this.attributes = attributes;
    }

    public Method[] getMethods() {
        return methods;
    }

    public void setMethods(Method[] methods) {
        this.methods = methods;
    }

    public void print() {
        StringBuilder a = new StringBuilder();
        a.append("Name: ").append(name).append(System.lineSeparator()).append(System.lineSeparator());
        for(Attribute attrib: attributes) {
            if(attrib!=null) {
                a.append(attrib.getType()).append(" ").append(attrib.getName()).append(System.lineSeparator());
            }
        }
        a.append(System.lineSeparator());
        for(Method method: methods) {
            if(method!=null) {
                a.append(method.getType()).append(" ").append(method.getName()).append(System.lineSeparator());
                for(Attribute arg: method.getArgs()) {
                    a.append("\t").append(arg.getType()).append(" ").append(arg.getName()).append(System.lineSeparator());
                }
            }
        }
        System.out.println(a);
    }
}
