package six;

/**
 * Created by changheng on 17/9/15.
 */
public class SimplePostProcessor {
    private String connStr;
    private String pwd;
    private String uname;

    public String getConnStr() {
        return connStr;
    }

    public void setConnStr(String connStr) {
        this.connStr = connStr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "SimplePostProcessor{" +
                "connStr='" + connStr + '\'' +
                ", pwd='" + pwd + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }
}
