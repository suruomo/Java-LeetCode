package advanced.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2021/8/11 12:57
 * @Description: 267. 回文排列 II
 * 给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。
 *
 * 如不能形成任何回文排列时，则返回一个空列表。
 */
public class GeneratePalindromes {

    public static List<String> generatePalindromes(String s) {
        List<String> ans=new ArrayList<>();
        char[] chars=s.toCharArray();
        dfs(ans,chars,0);
        return ans;
    }

    private static void dfs(List<String> ans,  char[] chars, int index) {
        if (index==chars.length){
            if (check(chars)){
                String s=new String(chars);
                if (!ans.contains(s)){
                    ans.add(s);
                }
            }
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars,i,index);
            dfs(ans, chars, index+1);
            swap(chars,i,index);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char c=chars[i];
        chars[i]=chars[j];
        chars[j]=c;
    }

    private static boolean check(char[] chars) {
        int i=0,j=chars.length-1;
        while (i<j){
            if (chars[i]!=chars[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s="aabbccd";
       List<String> list=generatePalindromes(s);
       for(String ss:list){
           System.out.println(ss);
       }
    }
}
