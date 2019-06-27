import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestStreamApi {
    @Test
    public void testStreamAPI(){
        List<Integer> list = List.of(3,4,5,7,9,6,8);
        Double sum = list.stream().filter((a) -> (a % 2 == 0)).map((a) -> (Math.pow(a,2))).reduce(Double::sum).get();
        assertThat(sum,is(116d));
    }
}
