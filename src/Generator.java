import java.io.*;

public class Generator {
    public UMLClass parse(String umlStr) {
        UMLClass umlClass = new UMLClass();
        String[] umlArr = umlStr.trim().split("(\\r\\n|\\r|\\n)");
        umlClass.setName(umlArr[0].trim());
        for(int i=1;i<umlArr.length;i++) {
            if(umlArr[i].trim().equals("")) continue;
            /* TODO: extract comments */
            int index = umlArr[i].indexOf("//");
            if(index!=-1) {
                umlArr[i] = umlArr[i].substring(0, index);
            }
            umlArr[i] = umlArr[i].replace(" ", "");
            System.out.println(umlArr[i]);
        }
        //finished parsing and converting the string
        for(int i=1;i<umlArr.length;i++) {
            if(umlArr[i].trim().equals("")) continue;
            switch(umlArr[i].charAt(0)) {
                case '+':
                    break;
                case '-':
                    break;
                case '#':
                    break;
                default:
                    continue;
            }
        }
        return umlClass;
    }
}
