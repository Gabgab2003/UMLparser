import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Parser parser = new Parser();
        String input = "", output = "";
        if(args.length < 1) {
            System.out.println("At least one Argument (InputFile)");
            return;
        } else if(args.length < 2) {
            input = args[0];
        } else {
            input = args[0];
            output = args[1];
        }
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;
        StringBuilder in = new StringBuilder();
        //read
        while((line=br.readLine())!=null)
            in.append(line).append(System.lineSeparator());
        UMLClass umlC = parser.parse(in.toString());
        String out = umlC.toJavaCode();
        output = umlC.getName() + ".java";

        //write

        PrintWriter printWriter = new PrintWriter(new File(output));
        printWriter.write(out);
        printWriter.close();
    }
}
