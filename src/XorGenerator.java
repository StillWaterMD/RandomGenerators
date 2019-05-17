import java.util.Date;
import java.util.Random;

public class XorGenerator  extends Random {

    long current;


    XorGenerator() {

        Date date = new Date();

        this.current = date.getTime();

    }

    private long shift(long x) {
        x ^= (x << 21);
        x ^= (x >>> 35);
        x ^= (x << 4);
        return x;
    }

    public int nextInt(int limit) {
        current = shift(current);
        if (current < 0) {

            return nextInt(limit);

        }
        if (limit > 1) {
            return (int) (current % limit);
        } else {
            return (int) current;
        }

    }
}
