import java.util.Random;
public class Snake extends Obstacle{
    public Snake() {
        super(4, "YILAN", 3+ (int) (Math.random() * 4), 12, 0);
    }
}
