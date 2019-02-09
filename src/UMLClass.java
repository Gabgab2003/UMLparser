public class UMLClass {
    private String name;
    private Attribute[] attributes = new Attribute[0];
    private Method[] methods = new Method[0];
    private Method[] constructors = new Method[0];
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

    public void setConstructors(Method[] constructors) {
        this.constructors = constructors;
    }

    public String toJavaCode() {
        StringBuilder a = new StringBuilder();
        String softtabstop = "    ";
        a.append("class ").append(name).append(" {").append(System.lineSeparator());
        for(Attribute attrib: attributes) {
            if(attrib!=null) {
                a.append(softtabstop);
                a.append(attrib.getAccess()).append(" ").append(attrib.getType()).append(" ").append(attrib.getName());
                if(!(attrib.getDefaultLiteral().equals(""))) {
                    a.append("=").append(attrib.getDefaultLiteral());
                }
                a.append(";").append(attrib.getComment()).append(System.lineSeparator());
            }
        }
        a.append(System.lineSeparator());

        for(Method constructor: constructors) {
            if(constructor!=null) {
                a.append(softtabstop);
                if(!(constructor.getAccess().equals(""))) {
                    a.append(constructor.getAccess()).append(" ");
                }
                a.append(constructor.getName()).append("(");
                for(int i=0;i<constructor.getArgs().length;i++) {
                    a.append(constructor.getArgs()[0].getType()).append(" ").append(constructor.getArgs()[0].getName());
                    if(i < constructor.getArgs().length-1) {
                        a.append(", ");
                    }
                }
                a.append(") {").append(constructor.getComment()).append(System.lineSeparator()).append(softtabstop).append("}").append(System.lineSeparator());
            }
        }
        a.append(System.lineSeparator());
        for(Method method: methods) {
            if(method!=null) {
                a.append(softtabstop).append(method.getAccess()).append(" ").append(method.getType()).append(" ").append(method.getName()).append("(");
                for(int i=0;i<method.getArgs().length;i++) {
                    a.append(method.getArgs()[i].getType()).append(" ").append(method.getArgs()[i].getName());
                    if(i < method.getArgs().length-1) {
                        a.append(", ");
                    }
                }
                a.append(") {").append(method.getComment()).append(System.lineSeparator()).append(softtabstop).append("}").append(System.lineSeparator());
            }
        }
        a.append("}");
        return a.toString();
    }
}
