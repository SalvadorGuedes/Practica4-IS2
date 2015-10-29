package practica.pkg4.is2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String pathName = "C:\\";
        File file = new File (pathName);
        String[] dire = file.list();
                
        String from = "C:\\Users\\Salvador\\Pictures\\programando.jpg";
        String to = "C:\\Users\\Salvador\\Pictures\\programando(1).jpg";
        
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File(from)));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(to)));
        
        Date date = new Date();
        while(true){
            int read = input.read();
            if(read < 0) break;
            output.write(read);
        }
        System.out.println(new Date().getTime()-date.getTime()+ " msg");
        
        input.close();
        output.flush();
        output.close();
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
