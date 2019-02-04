public class Tank extends Transport implements Shootable{
    private int countOfRound;

    public int getCountOfRound() {
        return countOfRound;
    }

    private void setCountOfRound(int countOfRound) {
        this.countOfRound = countOfRound;
    }

    public Tank(String number) {
        super(number);
        setCountOfRound(10);
    }

    @Override
    public void shooting(String pifPaf) {
        if (getCountOfRound()>0) {
            System.out.println(pifPaf);
            setCountOfRound(getCountOfRound()-1);
        }
        else {
            System.err.println("Нет снарядов!");
        }
    }
}
