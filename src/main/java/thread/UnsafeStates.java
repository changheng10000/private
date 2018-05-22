package thread;

import java.util.Arrays;

/**
 * Created by changheng on 17/11/10.
 */
public class UnsafeStates {
    private String[] states = new String[]{"a","b"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafeStates unsafeStates = new UnsafeStates();
        String[] states = unsafeStates.getStates();
        System.out.println(Arrays.toString(states));
        states[0] = "c";

        String[] states1 = unsafeStates.getStates();
        System.out.println(Arrays.toString(states1));

        UnsafeStates unsafeStates2 = new UnsafeStates();
        System.out.println(Arrays.toString(unsafeStates2.getStates()));
    }
}