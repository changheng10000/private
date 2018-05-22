package seven;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by changheng on 17/10/26.
 */
public class AwareTets {
    public static void main(String[] args) throws Exception{
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService service=context.getBean(AwareService.class);
        service.outputResult();
        context.close();
    }
}
