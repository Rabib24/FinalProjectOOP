package group57.ssf.Safin_1921111;

import group57.ssf.UserClasses.User;

public class Commander extends User {
    private String Level, Special, batch;

    public Commander(String level, String special, String batch) {
        Level = level;
        Special = special;
        this.batch = batch;
    }
}
