import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args){
        World w = new World ("./data/airport-codes_no_comma.csv");
        System.out.println("Found "+w.getList().size()+" airports.");
        Aeroport paris = w.findNearestAirport(2.316,48.866);
        Aeroport cdg = w.findByCode("CDG");
        double distance = w.distance(2.316,48.866,paris.getLongitude(),paris.getLattitude());
        System.out.println(paris);
        System.out.println(distance);
        double distanceCDG = w.distance(2.316,48.866,cdg.getLongitude(),cdg.getLattitude());
        System.out.println(cdg);
        System.out.println(distanceCDG);

            try {
                BufferedReader br = new BufferedReader(new FileReader("./data/JsonOrly.txt"));
                String test = br.readLine();
                JsonFlightFiller jSonFlightFiller = new JsonFlightFiller(test,w);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }



}
