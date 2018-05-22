package six;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by changheng on 17/9/15.
 */
public class DatePropertyEditor extends PropertyEditorSupport {
    private String format = "yyyy-MM-dd";

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println(text);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try{
            Date date = simpleDateFormat.parse(text);
            this.setValue(date);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
