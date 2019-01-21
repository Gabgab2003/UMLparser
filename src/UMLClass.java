public class UMLClass {
    private String name;
    private Attribute[] attributes;
    private Method[] methods;
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
}
