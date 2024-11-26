package DynamicProgramming;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RodCuttingTest {

    static final int[] solution = new int[]{0,1,5,8,10,13,17,18,22,25,30};

    /**
     * Deze test is al 7 keer trager dan de dynamic programming methode. (14ms < 2ms)
     */
    @Test
    public void naiveRodCutting() {
        for (int i = 0; i < solution.length; i++) {
            assertEquals(solution[i], RodCutting.cutRod(RodCutting.prices,i));
        }
    }

    @Test
    public void bottomUpRodCutting() {
        for (int i = 0; i < solution.length; i++) {
            assertEquals(solution[i], RodCutting.bottomUpCutRod(RodCutting.prices,i));
        }
    }

}
