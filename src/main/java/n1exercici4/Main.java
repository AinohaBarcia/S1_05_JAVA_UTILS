package n1exercici4;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> directoryList = new ArrayList<String>();
        String directorio = "   ";
        if (args.length > 0) {
            directorio = args[0];
            System.out.println("El archivo que voy a leer es: " + directorio);

            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;

            try {

                archivo = new File(directorio);
                fr = new FileReader(directorio);
                br = new BufferedReader(fr);

                // Lectura del fichero
                String linea;
                while ((linea = br.readLine()) != null)
                    System.out.println(linea);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}

