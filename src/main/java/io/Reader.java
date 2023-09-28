package io;

import java.io.*;

/**
 * @Author: suruomo
 * @Date: 2021/8/26 13:34
 * @Description:
 */
public class Reader {
    public static void main(String[] args) throws IOException {
        File file=new File("C:\\Users\\miaoyuanyang\\Desktop\\test.txt");
        FileReader inputStream=new FileReader(file);
        BufferedReader bufferedInputStream=new BufferedReader(inputStream);
        String line="";
        while ((line=bufferedInputStream.readLine())!=null){
            System.out.println(line);
        }
        inputStream.close();
        bufferedInputStream.close();
    }
}
