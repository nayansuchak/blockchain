
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockClient {
    public static void main(String[] args) {
        List<Block> blockChain = new ArrayList<>();
        Block block1 = new Block("00000000000000", "This is First Block", LocalDateTime.now(), new Random().nextInt());
        block1.mineBlock(4);
        blockChain.add(block1);
        System.out.println(blockChain);
    }
}
