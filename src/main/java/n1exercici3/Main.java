package n1exercici3;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Main extends Exception{
    public static void main(String[] args) {

        String directorio = "";
        ArrayList<File> files = new ArrayList<File>();


        if (args.length > 0) {
            directorio = args[0];
            System.out.println("El directorio que voy a listar es: " + directorio);
            files = recursiveMetod(files, directorio);

            for (int i = 0; i < files.size(); i++) {
                File file;
                file = files.get(i);
                boolean isDirectory = files.get(i).isDirectory();

                if (isDirectory) {
                    files = recursiveMetod(files, files.get(i).getAbsolutePath());
                }
            }
            FileWriter fichero = null;
            PrintWriter pw = null;
            Collections.sort(files);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


            try {
                fichero = new FileWriter("directoryList.txt");
                pw = new PrintWriter(fichero);
                for (int i = 0; i < files.size(); i++) {
                    File archivo = files.get(i);

                    pw.println(String.format("%s (%s) - %s",
                            archivo.getAbsolutePath(),
                            archivo.isDirectory() ? "Carpeta" : "Archivo",
                            sdf.format(archivo.lastModified() + i)));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != fichero)
                        fichero.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            System.out.println("Me tienes que indicar un directorio para listar.");
        }
    }

    public static ArrayList<File> recursiveMetod(ArrayList<File> archivosORIG, String directorio) {
        File carpeta = new File(directorio);
        String[] listado = carpeta.list();
        ArrayList<File> files = archivosORIG;

        for (int i=0; i< listado.length; i++) {
            String fileName = directorio + "/" + listado[i];
            files.add(new File(fileName));

        }

        if (files == null || files.size() == 0) {
            System.out.println("No hay elementos dentro de la carpeta actual");
            return files;
        } else {

        }
        return files;
    }
}
