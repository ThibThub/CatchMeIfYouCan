import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class JsonFlightFiller{

    private ArrayList<Flight> alFlight = new ArrayList<Flight>();

    public JsonFlightFiller(String jsonString,World w) {
        try {
            String departureTime;
            String arrivalTime;
            String airLineName;
            String airLineCode;
            String aeroportDest;
            int number;
            Flight flt;
            InputStream is = new ByteArrayInputStream(jsonString.getBytes(StandardCharsets.UTF_8));
            JsonReader rdr = Json.createReader(is);
            JsonObject obj = rdr.readObject();
            JsonArray results = obj.getJsonArray("data");
            for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                try {
                    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm':''+xxxx'");
                    //LocalDateTime departureTime = LocalDateTime.parse(result.getJsonObject("departure").getString("scheduled"), formatter);
                        departureTime = result.getJsonObject("departure").getString("scheduled");
                        arrivalTime = result.getJsonObject("arrival").getString("scheduled");
                        airLineName = result.getJsonObject("airline").getString("name");
                        airLineCode = result.getJsonObject("airline").getString("iata");
                        number = Integer.parseInt(result.getJsonObject("flight").getString("number"));
                        aeroportDest = result.getJsonObject("arrival").getString("airport");
                        flt = new Flight(airLineCode, airLineName, arrivalTime, departureTime, number, aeroportDest);
                        alFlight.add(flt);
                        System.out.println(flt);
/**************************
 * A vous de jouer ! *
 **************************/
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
