public class Main {
    public static void main(String[] args) {
        Parking myParking = new Parking();
        Transport myTransports[] = new Transport[15];
        for (int i = 0; i < myTransports.length; i++) {
            if (i % 3 == 0) {
                myTransports[i] = new Tank("Tank" + i);
            } else if (i % 2 == 0) {
                myTransports[i] = new Plane("Plane" + i);
            } else {
                myTransports[i] = new Car("Car" + i);
            }
            ;
        }
        for (int i = 0; i < myTransports.length; i++) {
            myTransports[i].printTransport();
        }
        System.out.println();
        System.out.println("Паркуемся вразброс");
        System.out.println();
        myTransports[4].doPark(myParking);
        myTransports[7].doPark(myParking);
        myTransports[0].doPark(myParking);
        myTransports[1].doPark(myParking);
        myTransports[3].doPark(myParking);
        myTransports[5].doPark(myParking);
        myTransports[2].doPark(myParking);
        myTransports[6].doPark(myParking);
        myTransports[8].doPark(myParking);
        System.out.println("Состояние: ");
        for (int i = 0; i < myTransports.length; i++) {
            myTransports[i].printTransport();
        }
        System.out.println();
        System.out.println("Освобождаем несколько мест вразброс");
        System.out.println();
        myTransports[1].doUnpark(myParking);
        myTransports[3].doUnpark(myParking);
        myTransports[5].doUnpark(myParking);
        myTransports[0].doUnpark(myParking);
        myTransports[1].doUnpark(myParking);
        System.out.println("Состояние: ");
        for (int i = 0; i < myTransports.length; i++) {
            myTransports[i].printTransport();
        }
        System.out.println();
        System.out.println("Пытаемся всех запарковать");
        System.out.println();
        for (int i = 0; i < myTransports.length; i++) {
            myTransports[i].doPark(myParking);
        }
        System.out.println("Состояние: ");
        for (int i = 0; i < myTransports.length; i++) {
            myTransports[i].printTransport();
        }

    }

}
