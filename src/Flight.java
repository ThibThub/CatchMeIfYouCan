import java.time.LocalDateTime;

public class Flight {

    private String aeroportDest;
    private String airLineCode;
    private String airLineName;
    //private LocalDateTime arrivalTime;
    //private LocalDateTime departureTime;
    private String arrivalTime; //Parce que j'arrive pas à convertir le String issu du Json en LocalDateTime ...
    private String departureTime;
    private int number;

    public Flight(String airlineCode, String airLineName, String arrivalTime, String departureTime, int number, String aeroportDest){
        this.aeroportDest = aeroportDest;
        this.airLineCode = airlineCode;
        this.airLineName = airLineName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.number = number;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String toString(){
        return ("Vol numéro " +number+ " de la compagnie : " +airLineName+ " à déstination de " +aeroportDest);
    }
}
