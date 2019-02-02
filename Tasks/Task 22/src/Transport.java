public class Transport implements Movable, Parkable {
    private String number;
    private int currentX;
    private int currentY;
    private String parkPlaceNumber;

    public Transport(String number) {
        setCurrentX(0);
        setCurrentY(0);
        setParkPlaceNumber("");
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

    public String getParkPlaceNumber() {
        return parkPlaceNumber;
    }

    private void setParkPlaceNumber(String parkPlaceNumber) {
        this.parkPlaceNumber = parkPlaceNumber;
    }

    @Override

    public void moving(int x, int y) {
        setCurrentX(this.currentX + x);
        setCurrentY(this.currentY + y);
    }

    @Override
    public void doPark() {

    }

    @Override
    public void doUnpark() {

    }
}
