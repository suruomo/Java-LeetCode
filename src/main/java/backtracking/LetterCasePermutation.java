package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2021/8/9 13:59
 * @Description: 784. 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        char[] chars=s.toCharArray();
        int n=chars.length;
        dfs(ans,chars,n,0);
        return ans;
    }

    private void dfs(List<String> ans, char[] chars, int n, int index) {
        ans.add(new String(chars));
        for (int i = index; i < n; i++) {
            if(!Character.isDigit(chars[i])){
                char c=chars[i];
                chars[i]=(char)(chars[i]-'a'>=0?chars[i]-32:chars[i]+32);
                dfs(ans, chars, n, i+1);
                chars[i]=c;
            }
        }
    }
}
