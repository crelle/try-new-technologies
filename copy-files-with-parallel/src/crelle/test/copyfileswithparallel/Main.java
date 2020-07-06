package crelle.test.copyfileswithparallel;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try{
            ParallelTasks tasks = new ParallelTasks();
            File folder = new File("e:\\io-test");
            for (File file:folder.listFiles()) {
                tasks.add(new CopyFileTask(file.getAbsolutePath(),"e:\\io-test\\to\\"+file.getName()));
            }
            tasks.go();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
