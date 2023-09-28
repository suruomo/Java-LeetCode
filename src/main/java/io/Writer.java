package io;

import java.io.*;

/**
 * @Author: suruomo
 * @Date: 2021/8/26 13:52
 * @Description:
 */
public class Writer {
    public static void main(String[] args) throws IOException {
        File file=new File("C:\\Users\\miaoyuanyang\\Desktop\\test.txt");
        // true为追加写
        FileWriter writer=new FileWriter(file,true);
        BufferedWriter bufferedInputStream=new BufferedWriter(writer);
        bufferedInputStream.write("asdabdahsdahsdhahsdu"+"\n");
        bufferedInputStream.write("asdas"+"\n");
        bufferedInputStream.write("asdas"+"\n");
        bufferedInputStream.write("asdas"+"\n");
        bufferedInputStream.flush();
        writer.close();
        bufferedInputStream.close();
    }
}
