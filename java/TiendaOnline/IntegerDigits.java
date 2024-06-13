public class IntegerDigits {
    public static void main(String[] args) {
        assert count(318) == 3;
        assert count(-92563) == 5;
        assert count(4666) == 4;
        assert count(-314890) == 6;
        assert count(654321) == 6;
        assert count(638476) == 6;
    }

    public static int count(int n) {
        if (Math.abs(n) < 10) {
            return 1;
        }
        return 1 + count(n / 10);
	}
}
