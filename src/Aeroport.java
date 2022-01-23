import java.time.LocalDateTime;

public class Aeroport {

    //Attributs
    private String IATA;
    private String Name;
    private String Country;
    private double lattitude;
    private double longitude;

    //Constructor
    public Aeroport(String IATA, String Name, String Country, double lattitude, double longitude){
        this.IATA = IATA;
        this.Name = Name;
        this.Country = Country;
        this.lattitude = lattitude;
        this.longitude=longitude;
    }





    public String toString(){
        return("AEROPORT " +this.IATA);
    }

    //Getters and setters
    public double getLattitude() {
        return lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCountry() {
        return Country;
    }

    public String getIATA() {
        return IATA;
    }

    public String getName() {
        return Name;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setIATA(String IATA) {
        this.IATA = IATA;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setName(String name) {
        Name = name;
    }
}
