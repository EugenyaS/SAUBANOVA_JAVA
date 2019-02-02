class Parking {
    public ParkingPlace places[];

    public Parking() {
        this.places = new ParkingPlace[10];
        for (int i = 0; i < places.length; i++) {
            this.places[i] = new ParkingPlace("P"+i);
        }
    }

    public String park(Transport transport) {
        for (int i = 0; i < places.length; i++) {
            if (places[i].isEmpty()) {
                return this.places[i].use(transport);
            }
        }
        System.err.println("Нет мест");
        return "";
    }

    public void unpark(String number) {
        for (int i = 0; i <  places.length; i++) {
            if (places[i].getTransportNumber().equals(number)) {
                places[i].unuse();
                return;
            }
        }
        System.err.println("Такой машины нет");
    }
}