package Assignment;

import java.util.ArrayList;

/**
 * @author qlizihang
 * @date 2023/5/14 20:21
 * @description:
 */
abstract class LoginPart {
    private String user;
    private String psw;
    public LoginPart(String user, String psw){
        this.user = user;
        this.psw = psw;
    }
    abstract void ability();
}
