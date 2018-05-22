package six;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by changheng on 17/9/15.
 */
public class TestPropertyEditor {

    private void testDate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserManager userManager = (UserManager) context.getBean("userManager");
        System.out.println(userManager);
    }
}
