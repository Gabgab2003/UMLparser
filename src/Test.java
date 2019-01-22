public class Test {
    public static void main(String[] args) {
        Generator gen = new Generator();
        UMLClass umlc = gen.parse("Thermometer\n" +
                "- untergrenze : int = -50 // kleinste Temperatur die angezeigt werden kann\n" +
                "- obergrenze : int = 80 // größte Temperatur die angezeigt werden kann\n" +
                "- bisherigesMinimum : int // kleinste bislang angezeigte Temperatur\n" +
                "- bisherigesMaximum : int // größte bislang angezeigte Temperatur\n" +
                "- temperatur : int // aktuelle Temperatur\n" +
                "+ Thermometer()\n" +
                "+ aendereTemperatur(neueTemperatur : int) : boolean // simuliert eine Temperaturänderung\n" +
                "+ getTemperatur(neueTemperatur : int, zweiteTemperatur : boolean) : int // aktuell angezeigte Temperatur\n" +
                "+ getBisherigesMinimum( ) : int\n" +
                "+ getBisherigesMaximum( ) : int\n" +
                "+ resetMinMax( )\n" +
                "+ printInfo( )");

        umlc.print();
    }
}
