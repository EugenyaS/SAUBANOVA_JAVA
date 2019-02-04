public class Transport implements Movable, Parkable {
    private String number;
    private int currentX;
    private ParkingPlace parkingPlace;

    public Transport(String number) {
        setCurrentX(0);
        setParkPlace(null);
        setNumber(number);
    }

    @Override
    public void moving(int x) {
        setCurrentX(getCurrentX() + x);
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public int getCurrentX() {
        return currentX;
    }

    private void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public ParkingPlace getParkPlace() {
        return parkingPlace;
    }

    public String getParkPlaceNumber() {
        if (parkingPlace != null) {
            return parkingPlace.getParkingPlaceNumber();
        } else {
            return "незапаркован";
        }
    };

    private void setParkPlace(ParkingPlace parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    public void printTransport() {
        System.out.println(getNumber() + ": " + getParkPlaceNumber());
    }

    @Override
    public void doPark(Parking parking) {
        if (getParkPlace() == null) {
            setParkPlace(parking.park(this));
        }else {
            System.out.println(getNumber()+": "+"Уже припаркован!");
        }
    }

    @Override
    public void doUnpark(Parking parking) {
        if (getParkPlace() != null) {
            parking.unpark(getNumber());
            setParkPlace(null);
        } else {
            System.out.println(getNumber()+": "+"не припаркована");
        }
    }
}
