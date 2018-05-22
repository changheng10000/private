package concurrent;

/**
 * Created by changheng on 17/11/23.
 */
public class EnumTest {
    public static void main(String[] args) {
        for (Shrubbery shrubbery : Shrubbery.values()) {
            System.out.println(Shrubbery.GROUND);
            System.out.println(shrubbery.compareTo(Shrubbery.GROUND));
            System.out.println(shrubbery==Shrubbery.GROUND);
            System.out.println(shrubbery.equals(Shrubbery.GROUND));
            System.out.println(shrubbery.getDeclaringClass());
            System.out.println(shrubbery.name());
            System.out.println(shrubbery.ordinal());
            Shrubbery shrubbery1 = Enum.valueOf(Shrubbery.class, shrubbery.name());
            System.out.println(shrubbery1);
            System.out.println(shrubbery==shrubbery1);
            System.out.println(shrubbery==Shrubbery.GROUND);
        }
    }
}

enum Shrubbery{
    GROUND,CRAWLING,HANGING
}
