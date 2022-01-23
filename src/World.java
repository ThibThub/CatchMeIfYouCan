import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.lang.Math;


public class World {

    //Attributs
    ArrayList<Aeroport> list = new ArrayList<Aeroport>();

    //Constructor
    public World (String fileName) {
        Aeroport Aeropush;
        try {
            BufferedReader buf = new BufferedReader(new FileReader(fileName));
            String s = buf.readLine();
            while (s != null) {
                s = s.replaceAll("\"", "");
//Enleve les guillemets qui s ́eparent les champs de donn ́ees GPS.
                String fields[] = s.split(",");
// Une bonne id ́ee : placer un point d'arr^et ici pour du debuggage.
                if (fields[1].equals("large_airport")) {
                    Aeropush = new Aeroport(fields[9], fields[2], fields[6], Double.parseDouble(fields[11]), Double.parseDouble(fields[12]));
                    list.add(Aeropush);
                }
                s = buf.readLine();
            }
        } catch (Exception e) {
            System.out.println("Maybe the file isn't there ?");
            System.out.println(list.get(list.size() - 1));
            e.printStackTrace();
        }
    }


    //Méthodes
    public double distance(double longitudeUn, double lattitudeUn, double longitudeDeux, double lattitudeDeux){
        double diffLatt = lattitudeDeux-lattitudeUn;
        return(Math.pow(diffLatt, 2)+Math.pow(((longitudeDeux-longitudeUn)*Math.cos(diffLatt/2)), 2));
    }

    public Aeroport findNearestAirport(double lattitude, double longitude){
        double mem = 999999999;
        double mem2;
        Aeroport Aeroretour = new Aeroport("TEST", "TEST", "TEST", 0.0, 0.0);
        for (Aeroport aero : list){
            mem2 = distance(longitude, lattitude, aero.getLongitude(), aero.getLattitude());
            if (mem2 < mem){
                mem = mem2;
                Aeroretour = aero;
            }
        }
        return Aeroretour;
    }

    public Aeroport findByCode(String code){
        code = code.toUpperCase();
        for (Aeroport aero : list){
            if (aero.getIATA().compareToIgnoreCase(code) == 0)
                return aero;
        }
        System.out.println("Recherche infructueuse");
        return null;
    }


    //Getters and setters
    public ArrayList<Aeroport> getList() {
        return list;
    }
}

