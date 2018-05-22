package six;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by changheng on 17/9/15.
 */
public class Str2DateConverter implements Converter<String,Date> {

    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public Date convert(String source) {
//        try{
////            return DateUtils.parseDate(source,new String[]{"yyyy-MM-dd HH:mm:ss"});
//        }catch(ParseException e){
//            return null;
//        }
        return null;
    }
}
