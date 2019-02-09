public class Parser {
    public UMLClass parse(String umlStr) {
        UMLClass umlClass = new UMLClass();
        String[] umlArr = umlStr.trim().split("(\\r\\n|\\r|\\n)");

        umlClass.setName(umlArr[0].trim());
        String[] comments = new String[umlArr.length];
        for (int i = 1; i < umlArr.length; i++) {
            if (umlArr[i].trim().equals("")) continue;
            int index = umlArr[i].indexOf("//");
            if (index != -1) {
                comments[i] = umlArr[i].substring(index);
                umlArr[i] = umlArr[i].substring(0, index);
            }
            umlArr[i] = umlArr[i].replace(" ", "");
        }
        //finished parsing and converting the string
        int sumOfMethods = 0;
        int sumOfAttributes = 0;
        int sumOfConstructors = 0;
        for (int i = 1; i < umlArr.length; i++) {
            if (umlArr[i].trim().equals("")) continue;
            if (umlArr[i].contains("(") && umlArr[i].substring(1, umlArr[i].indexOf("(")).equals(umlClass.getName())) {
                //is constructor
                sumOfConstructors++;
            } else if (umlArr[i].contains("(")) {
                //is function
                sumOfMethods++;
            } else {
                //is attribute
                sumOfAttributes++;
            }
        }
        //init method and attrib array
        Method[] methods = new Method[sumOfMethods];
        Attribute[] attributes = new Attribute[sumOfAttributes];
        Method[] constructors = new Method[sumOfConstructors];

        int methodIterate = 0;
        int attributeIterate = 0;
        int constructorIterate = 0;
        //iter second time
        for (int i = 1; i < umlArr.length; i++) {
            if (umlArr[i].trim().equals("")) continue;
            String access;
            int offset = 1;
            switch (umlArr[i].charAt(0)) {
                case '+':
                    access = "public";
                    break;
                case '-':
                    access = "private";
                    break;
                case '#':
                    access = "protected";
                default:
                    access = "";
                    offset = 0;
                    break;
            }

            int methodStart = umlArr[i].indexOf("(");
            if(methodStart != -1 && umlArr[i].substring(1, methodStart).equals(umlClass.getName())) {
                //is constructor
                int constructorEnd = umlArr[i].lastIndexOf(")");

                String name, type;
                Attribute[] args;
                name = umlArr[i].substring(offset, methodStart);

                String[] argsStr = umlArr[i].substring(methodStart + 1, constructorEnd).split(",");
                if (!(argsStr.length == 1 && argsStr[0].equals(""))) {
                    args = new Attribute[argsStr.length];
                    for (int a = 0; a < argsStr.length; a++) {
                        String[] argSplit = argsStr[a].split(":");
                        String argName = argSplit[0];
                        String argType = argSplit[1];
                        args[a] = new Attribute(argName, argType);
                    }
                    constructors[constructorIterate] = new Method(name, args, access);
                    if (comments[i] != null) {
                        constructors[constructorIterate++].setComment(comments[i]);
                    } else {
                        constructorIterate++;
                    }
                } else {
                    constructors[constructorIterate] = new Method(name, new Attribute[0], "", access);
                    if (comments[i] != null) {
                        methods[constructorIterate++].setComment(comments[i]);
                    } else {
                        constructorIterate++;
                    }
                }

            } else if (methodStart != -1) {
                //is method
                int methodEnd = umlArr[i].lastIndexOf(")");

                String name, type;
                Attribute[] args;

                name = umlArr[i].substring(offset, methodStart);
                if (umlArr[i].substring(methodEnd).contains(":")) {
                    type = umlArr[i].substring(methodEnd + 2);
                } else {
                    type = "void";
                }
                String[] argsStr = umlArr[i].substring(methodStart + 1, methodEnd).split(",");
                if (!(argsStr.length == 1 && argsStr[0].equals(""))) {
                    args = new Attribute[argsStr.length];
                    for (int a = 0; a < argsStr.length; a++) {
                        String[] argSplit = argsStr[a].split(":");
                        String argName = argSplit[0];
                        String argType = argSplit[1];
                        args[a] = new Attribute(argName, argType);
                    }
                    methods[methodIterate] = new Method(name, args, type, access);
                    if (comments[i] != null) {
                        methods[methodIterate++].setComment(comments[i]);
                    } else {
                        methodIterate++;
                    }
                } else {
                    methods[methodIterate] = new Method(name, new Attribute[0], type, access);
                    if (comments[i] != null) {
                        methods[methodIterate++].setComment(comments[i]);
                    } else {
                        methodIterate++;
                    }
                }
            } else {
                //is attribute
                String name, type, tempType, defaultLiteral = "";

                name = umlArr[i].substring(offset, umlArr[i].indexOf(":"));
                tempType = umlArr[i].substring(umlArr[i].indexOf(":") + 1);

                String[]  typeAndLiteral = tempType.split("=");
                type = typeAndLiteral[0];
                if(typeAndLiteral.length > 1) {
                    defaultLiteral=typeAndLiteral[1];
                }
                attributes[attributeIterate] = new Attribute(name, type, access, defaultLiteral);
                if (comments[i] != null) {
                    attributes[attributeIterate++].setComment(comments[i]);
                } else {
                    attributeIterate++;
                }
            }
        }
        umlClass.setAttributes(attributes);
        umlClass.setMethods(methods);
        umlClass.setConstructors(constructors);
        return umlClass;
    }
}
