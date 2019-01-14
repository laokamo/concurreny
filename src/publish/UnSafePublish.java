package publish;

import java.util.Arrays;

/**
 * 不安全的发布对象
 */
public class UnSafePublish {

    private String[] states = {"a","b","c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        System.out.println(Arrays.toString(unSafePublish.getStates()));

        unSafePublish.getStates()[0] = "d";
        System.out.println(Arrays.toString(unSafePublish.getStates()));
    }
}
