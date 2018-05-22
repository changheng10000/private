package tkj;

/**
 * 二元组
 * 三,四,五..可简单的继承上一个元组
 */
public class TwoTuple<A, B> {
    /**
     * 使用public的原因:
     *  1.格式简介明了,客户端只可访问,不可修改(final);
     *  2.如果想要使用具有不同元素的元组,强制要求另外创建一个新的对象
     */
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    //三元组
    static class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
        public final C third;
        public ThreeTuple(A first, B second, C third) {
            super(first, second);
            this.third = third;
        }

        @Override
        public String toString() {
            return "ThreeTuple{" +
                    "first=" + first +
                    ", second=" + second +
                    ", third=" + third +
                    '}';
        }
    }

    public static TwoTuple<Integer, String> return2(){
        return new TwoTuple<>(15, "Jack");
    }

    public static ThreeTuple<String, Integer, Double> return3(){
        return new ThreeTuple<>("Tom", 16, 60.10);
    }

    public static void main(String[] args) {
        TwoTuple<Integer, String> x = return2();
        System.out.println(x);
        System.out.println(return3());
    }
}
