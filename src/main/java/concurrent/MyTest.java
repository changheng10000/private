package concurrent;

import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * Created by changheng on 17/9/11.
 */
public class MyTest {
    public static void main(String[] args) {
//        System.out.println(strStr2("aaa", "aaaa"));

        System.out.println(isEven(-1602254855));
        System.out.println(isEven2(-1602254855));
    }



    public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int needFind = target - nums[i];
            if (map.containsKey(needFind) && map.get(needFind)!=i){
                return new int[]{map.get(needFind), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 1.获得x,y的二进制编码
     * 2.分隔x,y的二进制编码为集合
     * 3.比较相同位置x,y的不同并计数
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        String xBinary = Integer.toBinaryString(x^y);
        char[] chars = xBinary.toCharArray();
        int res = 0;
        for (char aChar : chars) {
            if(aChar=='1'){
                res++;
            }
        }
        return res;
    }

    @Test
    public void testhammingDistance(){
        int i = hammingDistance(1, 4);
        System.out.println(i);
    }

    public boolean judgeCircle(String moves) {
        char[] moveChars = moves.toCharArray();
        int initX = 0;
        int initY = 0;
        for (char moveChar : moveChars) {
            switch (moveChar){
                case 'R':
                    initX++;
                    break;
                case 'L':
                    initX--;
                    break;
                case 'U':
                    initY++;
                    break;
                case 'D':
                    initY--;
                    break;
                default:
                    break;
            }
        }
        return initX==0 && initY==0;
    }

    @Test
    public void testjudgeCircle(){
        System.out.println(judgeCircle("UUDDRULD"));
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }

        t1.val = t1.val+t2.val;
        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        t1.left = left;
        t1.right = right;
        return t1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    @Test
    public void testidentityToString(){
        System.out.println(System.identityHashCode(this));
        System.out.println(ObjectUtils.identityToString(this));
    }

    public int arrayPairSum(int[] nums) throws Exception{
        if(nums.length%2 !=0){
            throw new Exception("数组长度必须为偶数");
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if((i+1)%2==0){
                sum += Math.min(nums[i-1], nums[i]);
            }
        }
        return sum;
    }

    @Test
    public void testarrayPairSum() throws Exception{
        int i = arrayPairSum(new int[]{1, 4, 3, 2, 5, 8});
        System.out.println(i);
    }

    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        if(s.startsWith("1")){
            String s1 = Integer.toBinaryString(~num);
            num = Integer.parseInt(s1.substring(s1.indexOf("0")), 2);
        }
        return num;
    }

    @Test
    public void testfindComplement(){
        int complement = findComplement(5);
        System.out.println(complement);
    }

    public String[] findWords(String[] words) {
        String up = "qwertyuiopQWERTYUIOP";
        String medium = "asdfghjklASDFGHJKL";
        String down = "zxcvbnmZXCVBNM";
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (containsAll(up, word)) {
                res.add(word);
                continue;
            }

            if (containsAll(medium, word)) {
                res.add(word);
                continue;
            }

            if (containsAll(down, word)) {
                res.add(word);
                continue;
            }
        }
        return res.toArray(new String[]{});
    }

    private boolean containsAll(String down, String word) {
        char[] wordS = word.toCharArray();
        for (char w : wordS) {
            if(down.indexOf(w)==-1){
                return false;
            }
        }
        return true;
    }

    @Test
    public void testfindWords(){
        String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        String[] words1 = findWords(words);
        System.out.println(Arrays.toString(words1));
    }

    @Test
    public void testchar(){
        String word = "test";
        String otherWord = "toat";
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            if(otherWord.indexOf(aChar)!=-1){
                System.out.println(aChar);
                System.out.println("testing!!!");
            }
        }
    }

    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        String collect = Arrays.stream(strings).map(st -> new StringBuilder(st).reverse().toString()).collect(Collectors.joining(" "));
        return collect;
    }

    public String reverseWords2(String s) {
        String[] strings = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String string : strings) {
            res.append(new StringBuilder(string).reverse().toString()+" ");
        }
        return res.toString().trim();
    }



    @Test
    public void testreverseWords(){
        String s = "Our objective is to get the best possible line. The best possible line will be such so that the average squared vertical distances of the scattered points from the line will be the least. Ideally, the line should pass through all the points of our training data set. In such a case, the value of J(θ0,θ1) will be 0. The following example shows the ideal situation where we have a cost function of 0";
        String s1 = reverseWords2(s);
        System.out.println(s1);
    }


    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = chars.length-1; i >= 0; i--) {
            res.append(chars[i]);
        }
        return res.toString();
    }

    @Test
    public void testreverseString(){
        String hello = new StringBuilder("hello").reverse().toString();
        System.out.println(hello);
    }

    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Your goal is to reach the last index in the minimum number of jumps.

     For example:
     Given array A = [2,3,1,1,4]

     The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

     Note:
     You can assume that you can always reach the last index.

     解决方案:
        1.判断index=处的值作为最大步数是否已经到达lastindex处,如果没有,继续2;如果已到达,返回该处索引
        2.获取根据index=处的值代表的步数内的最大值代表的索引max
        3 .判断index=+max处的值作为最大步数是否已经到达lastindex处,如果没有,继续2;如果已到达,返回该处索引
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int length = nums.length;
        int sumJump = 0;
        int jumpIndex = 0;
        if(length==1){
            return sumJump;
        }
        outer:
        while (jumpIndex <= length-1){
            Map<Integer,Integer> jumpMap = new HashMap<>();
            if(jumpIndex!=0 && nums[jumpIndex] == 0){
                jumpIndex--;
                continue;
            }
            if(nums[jumpIndex+1]==0 && nums[jumpIndex]==1){
                jumpIndex--;
                continue;
            }

            if(jumpIndex+nums[jumpIndex] >= length-1){
                sumJump++;
                break ;
            }
            for(int i=jumpIndex+1; i<=jumpIndex+nums[jumpIndex]; i++){
                jumpMap.put(i, nums[i]);
            }
            Integer[] array = jumpMap.values().toArray(new Integer[]{});
            Arrays.sort(array);
            int jumpValue = array[array.length-1];
            if(nums[jumpIndex] > jumpValue){
                jumpIndex = jumpIndex + nums[jumpIndex];
                sumJump++;
                continue;
            }
            for (Map.Entry<Integer, Integer> entry : jumpMap.entrySet()) {
                if(entry.getValue()==jumpValue){
                    jumpIndex = entry.getKey();
                    sumJump++;
                    continue outer;
                }
            }

        }

        return sumJump;
    }

    @Test
    public void testJump(){
        int[] nums = new int[]{3,0,2,0,3};
        System.out.println(jump(nums));
    }

    @Test
    public void testConcurrentLinkedQueue(){
        ConcurrentLinkedQueue<String> strings = new ConcurrentLinkedQueue<>();
        strings.add("hello");
    }

    @Test
    public void testLocalDate2String(){
        System.out.println(LocalDate.now().plusWeeks(1).toString());
    }

    @Test
    public void testctlof(){
        System.out.println(COUNT_BITS);
        System.out.println();
        System.out.println(RUNNING);
        System.out.println(ctl.get());
        System.out.println(workerCountOf(ctl.get()));;
    }

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }


    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

     The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     * @param source
     * @return
     */
    private static boolean validOpenCloseChar(String source){
        char[] chars = source.toCharArray();
        if(chars.length<=1){
            return false;
        }
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('{', '}');

        for (int i = 0; i < chars.length; i+=2) {

            Character character = charMap.get(chars[i]);
            if(Objects.isNull(character)){
                return false;
            }
            if(character.equals(chars[i+1])){
                continue;
            }
            return false;
        }


        return true;
    }


    /**
     * Implement strStr().

     Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {

        if(needle == null || needle.length()==0){
            return 0;
        }

        if(needle.length()>haystack.length()){
            return -1;
        }

        if(haystack.length()==0){
            return -1;
        }


        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();


        int firstIndex = -1;
        for (int i = 0; i < haystacks.length; i++) {
            if(haystacks[i] == needles[0]){
                firstIndex = i;
                break;
            }
        }


        if(firstIndex<0){
            return firstIndex;
        }
        int needleLength = needles.length;

        for(int i = firstIndex + 1,restIndex = 1; i < firstIndex + needleLength; i++,restIndex++){
            if(haystacks[i] != needles[restIndex]){
                return -1;
            }
        }

        return firstIndex;
    }

    public static int strStr2(String haystack, String needle){
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;

        for (i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isEven(int num){
        return (num & 1) == 0;
    }

    static boolean isEven2(int num){
        return (num % 2) ==0;
    }


}
