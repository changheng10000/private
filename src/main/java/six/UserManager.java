package six;

import java.util.Date;

/**
 * Created by changheng on 17/9/15.
 */
public class UserManager {
    private Date dateValue;

    @Override
    public String toString() {
        return "UserManager{" +
                "dateValue=" + dateValue +
                '}';
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }
}
