import java.io.*;

public class Generator {
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
        for (int i = 1; i < umlArr.length; i++) {
            if (umlArr[i].trim().equals("")) continue;
            if (umlArr[i].contains("(")) {
                //is function
                sumOfMethods++;
            } else {
                //is attribute
                sumOfAttributes++;
            }
        }
        Method[] methods = new Method[sumOfMethods];
        Attribute[] attributes = new Attribute[sumOfAttributes];
        int methodIterate = 0;
        int attributeIterate = 0;
        for (int i = 1; i < umlArr.length; i++) {
            if (umlArr[i].trim().equals("")) continue;
            int methodStart = umlArr[i].indexOf("(");
            if (methodStart != -1) {
                //is method
                int methodEnd = umlArr[i].lastIndexOf(")");
                int offset = 1;

                String name, type, access;
                Attribute[] args;

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
                    if (name.equals(umlClass.getName())) {
                        type = "constructor";
                    }
                    methods[methodIterate] = new Method(name, args, type, access);
                    if (comments[i] != null) {
                        methods[methodIterate++].setComment(comments[i]);
                    } else {
                        methodIterate++;
                    }
                } else {
                    if (name.equals(umlClass.getName())) {
                        type = "constructor";
                    }
                    methods[methodIterate] = new Method(name, new Attribute[0], type, access);
                    if (comments[i] != null) {
                        methods[methodIterate++].setComment(comments[i]);
                    } else {
                        methodIterate++;
                    }
                }
            } else {
                //is attribute
                String name, type, access;
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
                name = umlArr[i].substring(offset, umlArr[i].indexOf(":"));
                type = umlArr[i].substring(umlArr[i].indexOf(":") + 1);

                attributes[attributeIterate] = new Attribute(name, type, access);
                if (comments[i] != null) {
                    attributes[attributeIterate++].setComment(comments[i]);
                } else {
                    attributeIterate++;
                }
            }
        }
        umlClass.setAttributes(attributes);
        umlClass.setMethods(methods);
        return umlClass;
    }
}
