package com.crelle;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        if(args.length<=0  ){
            System.out.println("请传入目录！！");
            return;
        }
	new start(args[0]);
    }


}

class start{
    public String dicPath;
    int fileCount = 0;
    public start(String dicPath) {
        this.dicPath = dicPath;
        go(dicPath);
        System.out.println("一共删除的文件数量为:"+fileCount);
    }

    private void go(String dicPath){

        try {
            File file = new File(dicPath);
           File[] files =  file.listFiles();
           for (int i=0;i<files.length;i++ ){
               if(files[i].isDirectory()){
                   go(files[i].getPath());
               }else{
                   files[i].delete();
                   fileCount++;
               }
           }
        }catch (Exception e){

        }
    }


}
