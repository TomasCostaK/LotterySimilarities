public class BloomTest {
    public static void main(String[] args) {
        
        BloomFilterTest bloom = new BloomFilterTest(0.3,5);
        bloom.initialize();
        bloom.printBloom();
    }
}
