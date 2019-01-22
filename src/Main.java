import java.io.*;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        String in = " Thermometer\n" +
                "- untergrenze :  int = -50 // kleinste Temperatur die angezeigt werden kann\n" +
                "- obergrenze : int = 80 // größte Temperatur die angezeigt werden kann\n" +
                "- bisherigesMinimum : int // kleinste bislang angezeigte Temperatur\n" +
                "- bisherigesMaximum : int // größte bislang angezeigte Temperatur\n" +
                "- temperatur : int // aktuelle Temperatur\n" +
                "+ Thermometer()\n" +
                "+ aendereTemperatur(neueTemperatur : int) : boolean // simuliert eine Temperaturänderung\n" +
                "+ getTemperatur( ) : int // aktuell angezeigte Temperatur\n" +
                "+ getBisherigesMinimum( ) : int\n" +
                "+ getBisherigesMaximum( ) : int\n" +
                "+ resetMinMax( )\n" +
                "+ printInfo( )";
        System.out.println(parser.parse(in).toJavaCode());
    }
}
