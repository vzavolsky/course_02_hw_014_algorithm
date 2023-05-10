import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayListTest {

    private final ArrayList arrayList = new ArrayList(10);

    @BeforeEach
    public void beforeEach() {
        arrayList.add("Zero");
        arrayList.add("First");
        arrayList.add(null);
        arrayList.add("Second");
        arrayList.add("Third");
        arrayList.add("Fourth");
    }

}
