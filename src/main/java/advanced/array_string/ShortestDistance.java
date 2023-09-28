package advanced.array_string;

/**
 * @Author: suruomo
 * @Date: 2021/7/24 17:34
 * @Description: 245.最短单词距离
 * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
 *
 * 示例:
 * 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
 *
 * 输入: word1 =“coding”, word2 =“practice”
 *
 * 输出: 3
 *
 * 输入: word1 ="makes", word2 ="makes"
 *
 * 输出: 3

 */
public class ShortestDistance {
    public static void main(String[] args) {
        String[] words={"practice", "makes", "perfect", "coding", "makes"};
        String word1="makes";
        String word2="makes";
        System.out.println(shortestDistance(words,word1,word2));
    }

    private static int shortestDistance(String[] words, String word1, String word2) {
        int i1=-1,i2=-1;
        int ans=Integer.MAX_VALUE;
        int len=words.length;
        for (int i = 0; i < len; i++) {
            // 1.两个单词相同时
            if (words[i]==word1&&words[i]==word2){
                if (i1!=-1){
                    ans=Math.min(ans,i-i1);
                    break;
                }else {
                    i1=i;
                    continue;
                }
            }
            // 2.两个单词不同时
            if (words[i]==word1){
                i1=i;
            }else if (words[i]==word2){
                i2=i;
            }
            if (i1!=-1&&i2!=-1){
                ans=Math.min(ans,Math.abs(i2-i1));
            }
        }
        return ans;
    }
}
