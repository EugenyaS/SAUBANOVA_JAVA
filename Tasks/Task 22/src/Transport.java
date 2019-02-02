public class Transport implements Movable, Parkable {
    private String number;
    private int currentX;
    private int currentY;
    private ParkingPlace parkingPlace;

    public Transport(String number) {
        setCurrentX(0);
        setCurrentY(0);
        setParkPlace(null);
        setNumber(number);
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

    public int getCurrentY() {
        return currentY;
    }

    private void setCurrentY(int currentY) {
        if ((currentY < 0)) {
            System.err.println("Разбились (((");
            this.currentY = 0;
        } else {
            this.currentY = currentY;
        }
    }

    public ParkingPlace getParkPlaceNumber() {
        return parkingPlace;
    }

    private void setParkPlace(ParkingPlace parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    @Override

    public void moving(int x, int y) {
        setCurrentX(this.currentX + x);
        setCurrentY(this.currentY + y);
    }

    @Override
    public void doPark(Parking parking) {
        setParkPlace(parking.park(this));

    }

    @Override
    public void doUnpark(Parking parking) {
        parking.unpark(getNumber());
        setParkPlace(null);
    }
}
