package ru.saubanova;

import java.util.Random;

public class TvChannel {
    private static final int MAX_COUNT_OF_PROGRAMM = 100;
    private TvProgramm[] tvProgramms;
    private String tvChannelName;
    private int countOfProgramms;
    private int currentProgramm;

    public static int getMaxCountOfProgramm() {
        return MAX_COUNT_OF_PROGRAMM;
    }

    public String getTvChannelName() {
        return tvChannelName;
    }

    private void setTvChannelName(String tvChannelName) {
        this.tvChannelName = tvChannelName;
    }

    public int getCountOfProgramms() {
        return countOfProgramms;
    }

    private void setCountOfProgramms(int countOfProgramms) {
        this.countOfProgramms = countOfProgramms;
    }

    public int getCurrentProgramm() {
        return currentProgramm;
    }

    private void setCurrentProgramm(int currentProgramm) {
        if (currentProgramm > getCountOfProgramms()) {
            currentProgramm = getCountOfProgramms();
        }
        if (currentProgramm < 0) {
            currentProgramm = 0;
        }
        this.currentProgramm = currentProgramm;

    }

    public TvChannel(String tvChannelName, TvProgramm[] tvProgramms) {
        this.tvProgramms = tvProgramms;
        this.setTvChannelName(tvChannelName);
        this.setCountOfProgramms(this.tvProgramms.length);
        Random random = new Random();
        setCurrentProgramm(random.nextInt(countOfProgramms - 1));
    }

    public TvChannel(String tvChannelName, int countOfProgramm) {
        this.setTvChannelName(tvChannelName);
        if (countOfProgramm > MAX_COUNT_OF_PROGRAMM) {
            countOfProgramm = MAX_COUNT_OF_PROGRAMM;
        }
        if (countOfProgramm < 0) {
            countOfProgramm = 0;
        }
        tvProgramms = new TvProgramm[MAX_COUNT_OF_PROGRAMM];
        for (int i = 0; i < countOfProgramm; i++) {
            tvProgramms[i] = new TvProgramm();
        }
        this.setCountOfProgramms(countOfProgramm);
        Random random = new Random();
        setCurrentProgramm(random.nextInt(countOfProgramms - 1));
    }

    public String getCurrentProgrammName() {
        return tvProgramms[getCurrentProgramm()].getName();
    }

    public void showCurrentProgramm() {
        tvProgramms[getCurrentProgramm()].show();
    }

}
