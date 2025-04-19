package group57.ssf.Safin_1921111;

import group57.ssf.UserClasses.User;

public class Commander extends User {
    public Commander(int id) {
        super(id);
    }

    public Commander(int id, String password, String fullName, String email, String contact, String bloodType, String gender, String role, String status, float salary) {
        super(id, password, fullName, email, contact, bloodType, gender, role, status, salary);
    }
//    private String Level, Special, batch;
//
//    public Commander(String level, String special, String batch) {
//        Level = level;
//        Special = special;
//        this.batch = batch;
//    }
}
