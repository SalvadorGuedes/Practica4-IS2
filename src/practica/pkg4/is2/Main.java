package practica.pkg4.is2;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String pathName = "C:\\";
        File file = new File (pathName);
        String[] dire = file.list();
        for(String dire1: dire){
            System.out.println(dire1);
        }
        
        print (file.listFiles(), "");
    }

    private static void print(File[] listFiles, String ident) {
        if(listFiles == null){
            return;
        }
        
        for (File listFile : listFiles) {
            System.out.println(ident+(listFile.isDirectory()?"+": " ")+listFile.getName());
            if (listFile.isFile() || listFile.isHidden()) continue;
            print(listFile.listFiles(), ident + " ");
        }
        
    }
    
}
