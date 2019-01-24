import java.util.Random;

public class TvSet {
    private static final int MAX_COUNT_OF_CHANNELS=100;
    private String tvModel;
    private TvChannel[] tvChannels;
    private int countOfChannel;
    private int currentChannel;

    public static int getMaxCountOfChannels() {
        return MAX_COUNT_OF_CHANNELS;
    }

    public String getTvModel() {
        return tvModel;
    }

    private void setTvModel(String tvModel) {
        this.tvModel = tvModel;
    }

    public int getCountOfChannel() {
        return countOfChannel;
    }

    public void setCountOfChannel(int countOfChannel) {
        this.countOfChannel = countOfChannel;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    private void setCurrentChannel(int currentChannel) {
        this.currentChannel = currentChannel;
    }

    public TvSet(String tvModel, int countOfChannel) {
        this.setTvModel(tvModel);
        if (countOfChannel>MAX_COUNT_OF_CHANNELS) {
            countOfChannel = MAX_COUNT_OF_CHANNELS;
        }
        if (countOfChannel<0) {
            countOfChannel = 0;
        }
        this.setCountOfChannel(countOfChannel);
        tvChannels = new TvChannel[MAX_COUNT_OF_CHANNELS];
        for (int i = 0; i < countOfChannel; i++) {
            tvChannels[i] = new TvChannel("Channel "+i,TvChannel.getMaxCountOfProgramm());
        }
    }

    public TvSet(String tvModel, TvChannel[] tvChannels) {
        this.setTvModel(tvModel);
        this.tvChannels = tvChannels;
        this.setCountOfChannel(this.tvChannels.length);
        Random random= new Random();
        this.setCurrentChannel(random.nextInt(this.tvChannels.length-1));
    }

    public void showChannel(int channelNum){
        if (channelNum<getCountOfChannel()) {
            setCurrentChannel(channelNum);
            tvChannels[channelNum].showCurrentProgramm();
        } else {
            System.out.println("Канал "+channelNum+" не найден!");
            tvChannels[getCurrentChannel()].showCurrentProgramm();
        }
    }

    public void showTvChannels() {
        System.out.println("Список каналов");
        for (int i = 0; i < getCountOfChannel(); i++) {
            System.out.println(tvChannels[i].getTvChannelName());
        }
    }

    public void getCurrentAllProgrammName() {
        for (int i = 0; i < getCountOfChannel(); i++) {
            System.out.println(tvChannels[i].getTvChannelName()+" : "+ tvChannels[i].getCurrentProgrammName());

        }
    }

}
