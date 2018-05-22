package six;

import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Date;

/**
 * Created by changheng on 17/9/15.
 */
public class TestStr2DateConverter {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new Str2DateConverter());
        Date convert = conversionService.convert("2017-09-15 10:31:42", Date.class);
        System.out.println(convert);
    }
}
