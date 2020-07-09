package crelle.test.multithread.server.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterTaskToFile extends Thread {

    private String paras = "";
    public WriterTaskToFile(String paras) {
        this.paras = paras;
    }

    @Override
    public void run() {
        FileWriter fileWriter = null;
        try{
            File file = new File("E:\\thread-test\\write-num.txt");
            File parentFile = file.getParentFile();
            if(!parentFile.exists()){
                parentFile.mkdirs();
            }
            fileWriter = new FileWriter(file,true);
            fileWriter.append(paras+"\r\n");
            fileWriter.flush();
        }catch (Exception e){

        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
