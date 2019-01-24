import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TvRemote tvRemote = new TvRemote();
        tvRemote.pressShowChannelList();
        System.out.println("Введите номер канала (от 1 до "+tvRemote.countOfChannels()+")");
        Scanner scanner =new Scanner(System.in);
        tvRemote.pressChannelButton(scanner.nextInt());
        tvRemote.pressChannelButton(scanner.nextInt());
        tvRemote.showProgrammName();
        tvRemote.pressChannelButton(scanner.nextInt());

    }
}
