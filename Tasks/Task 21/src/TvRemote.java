public class TvRemote {
    private TvSet  tvSet;

    public TvRemote() {
        tvSet = new TvSet("Random TV", TvSet.getMaxCountOfChannels());
    }

    public TvRemote(TvSet tvSet) {
        this.tvSet = tvSet;
    }

    public void pressShowChannelList() {
        tvSet.showTvChannels();
    }
    public void pressChannelButton(int channelNumber){
        tvSet.showChannel(channelNumber);
    }

    public int countOfChannels() {
        return tvSet.getCountOfChannel();
    }

    public void showProgrammName(){
        tvSet.getCurrentAllProgrammName();
    }

}
