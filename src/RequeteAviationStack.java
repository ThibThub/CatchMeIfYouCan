import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class RequeteAviationStack implements Runnable{

    String inputLine;
    String reponse;
    JsonFlightFiller flightsFilled;
    World w = new World ("./data/airport-codes_no_comma.csv");
    private Aeroport aeroportDest;

    public RequeteAviationStack(Aeroport nearestAirport){
        this.aeroportDest = nearestAirport;
    }

    @Override
    public void run() {
        URL aviationStack = null;
        reponse ="";
        try {
            aviationStack = new URL("http://api.aviationstack.com/v1/flights?access_key=18dc42cb6f73f0a24cdce162aa9f5317&arr_iata="+aeroportDest.getIATA());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection yc = null;
        try {
            yc = aviationStack.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!((inputLine = in.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            reponse = reponse.concat(inputLine);
            System.out.println(inputLine);
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Réponse : " +reponse);
        flightsFilled = new JsonFlightFiller(reponse, w);
    }
}
