package advanced.array_string;

import java.util.HashSet;

/**
 * @Author: suruomo
 * @Date: 2021/7/28 9:56
 * @Description: 288. 单词的唯一缩写（哈希）
 * 一个单词的缩写需要遵循 <起始字母><中间字母数><结尾字母> 这样的格式。
 * 假设你有一个字典和一个单词，请你判断该单词的缩写在这本字典中是否唯一。
 * 若单词的缩写在字典中没有任何 其他 单词与其缩写相同，则被称为单词的唯一缩写。
 */
public class IsUnique {
    public HashSet<String> set;

    /**
     * 判断是否存在
     * @param word
     * @return
     */
    public boolean isUnique(String word) {
        if (word==null||word.length()==0){
            return false;
        }
        String ans=process(word);
        if (!set.contains(ans)){
            return true;
        }
        return false;
    }

    /**
     * 字典中单词缩写
     * @param dictionary
     */
    public void ValidWordAbbr(String[] dictionary) {
        set=new HashSet<>();
        for(String s:dictionary){
            String ans=process(s);
            if (!set.contains(ans)){
                set.add(ans);
            }
        }
    }

    /**
     * 求一个单词的缩写
     * @param s
     * @return
     */
    private String process(String s) {
        if (s.length()<3){
            return s;
        }
        int len=s.length();
        return s.substring(0,1)+(len-2)+s.substring(len-1);
    }
}
