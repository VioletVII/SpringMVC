package SelectTest;

/**
 * @author
 * @description:
 * @create 2022/7/6-22:16
 */
public class test {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstring(" ");
        System.out.println(i);
    }
    public static int lengthOfLongestSubstring(String s) {
        s = s.trim();
        if(s.length()==0||s==null||"".equals(s)){
            return 0;
        }
        char[] str=s.toCharArray();
        int p=0;
        int q=1;
        int max=-1;
        while(p<q&&p<str.length){
            if(str[p]==str[q]){
                max=Math.max(q-p,max);
                p=q;
                q++;
            }else{
                q++;
            }
            if(q==str.length){
                p++;
                q=p+1;
            }
        }
        return max;
    }
}
