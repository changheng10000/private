package six;

import org.springframework.context.ApplicationEvent;

/**
 * Created by changheng on 17/9/14.
 */
public class TestEvent extends ApplicationEvent {
    public String msg;

    public TestEvent(Object source){
        super(source);
    }

    public TestEvent(Object source, String msg){
        super(source);
        this.msg = msg;
    }

    public void print(){
        System.out.println(msg);
    }
}
