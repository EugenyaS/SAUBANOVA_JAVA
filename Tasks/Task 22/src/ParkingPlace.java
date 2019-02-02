public class ParkingPlace {
    private Transport transport;
    private String transportNumber;
    private String parkingPlaceNumber;
    private boolean empty;

    public Transport getTransport() {
        return transport;
    }

    public String getTransportNumber() {
        return transportNumber;
    }

    public boolean isEmpty() {
        return empty;
    }

    public ParkingPlace(String parkingPlaceNumber) {
        this.transport = null;
        this.transportNumber = "";
        setParkingPlaceNumber(parkingPlaceNumber);
        this.empty = true;
    }

    private void setTransport(Transport transport) {
        this.transport = transport;
    }

    private void setTransportNumber(String transportNumber) {
        this.transportNumber = transportNumber;
    }

    private void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public String getParkingPlaceNumber() {
        return parkingPlaceNumber;
    }

    private void setParkingPlaceNumber(String parkingPlaceNumber) {
        this.parkingPlaceNumber = parkingPlaceNumber;
    }

    public String use(Transport transport) {
        setTransport(transport);
        setTransportNumber(transport.getNumber());
        setEmpty(false);
        return getParkingPlaceNumber();
    }

    public void unuse() {
        setTransport(null);
        setTransportNumber("");
        setEmpty(true);
    }
}
