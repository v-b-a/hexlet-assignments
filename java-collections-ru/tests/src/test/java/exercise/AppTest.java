package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list;
        List<Integer> list2 = new ArrayList<>();
        list = List.of(1,2,3,4);
        int count = 2;
        int count2 = 0;
        List<Integer> newList = App.take(list, count);
        List<Integer> newList2 = App.take(list2, count);
        List<Integer> newList3 = App.take(list2, count2);
        List<Integer> expected = List.of(1,2);
        List<Integer> expected2 = new ArrayList<>();
        assertThat(newList).isEqualTo(expected);
        assertThat(newList2).isEqualTo(expected2);
        assertThat(newList3).isEqualTo(expected2);
        // END
    }
}
