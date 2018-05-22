package six;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by changheng on 17/9/15.
 */
public class BeanPostProcessorTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SimplePostProcessor simplePostProcessor = (SimplePostProcessor)context.getBean("simpleBean");

    }
}
