package week4.JSON;

class Flight {
   
    int id;
    String time;
    String city;
    String flight;
    String gate;

    Flight(int id, String time, String city, String flight, String gate) {
        this.id = id;
        this.time = time;
        this.city = city;
        this.flight = flight;
        this.gate = gate;
    }

    @Override
    public String toString() {
       return String.format("%2d | %5s | %-16s | %-7s | %-3s", this.id, this.time, this.city, this.flight, this.gate);
   }
}