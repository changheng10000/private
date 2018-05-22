package tkj;

import java.util.ArrayList;

public class TupleList<A, B, C>  extends ArrayList<TwoTuple.ThreeTuple<A, B, C>> {
    public static void main(String[] args) {
        TupleList<String, Integer, Double> threeTuples = new TupleList<>();
        threeTuples.add(TwoTuple.return3());
        threeTuples.add(TwoTuple.return3());

        System.out.println(threeTuples);
    }
}
