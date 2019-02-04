public class Plane extends Transport implements Flyable {
    private int currentY;
    public int getCurrentY() {
        return currentY;
    }

    protected void setCurrentY(int currentY) {
        if ((currentY < 0)) {
            System.err.println("Разбились (((");
            this.currentY = 0;
        } else {
            this.currentY = currentY;
        }
    }

    public Plane(String number) {
        super(number);
        setCurrentY(0);
    }

    @Override
    public void flying(int x, int y) {
        moving(x);
        setCurrentY(getCurrentY() + y);
    }

}
