package n1exercici2;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    public static void main(String[] args) {
        String directorio = "";
        ArrayList<File> files = new ArrayList<File>();


        if (args.length > 0) {
            directorio = args[0];
            System.out.println("El directorio que voy a listar es: " + directorio);
            files = recursiveMetod(files,directorio);

            for (int i = 0; i < files.size(); i++) {
                File file;
                file = files.get(i);
                boolean isDirectory = files.get(i).isDirectory();

                if (isDirectory) {
                    files = recursiveMetod(files, files.get(i).getAbsolutePath());
                }
            }

            Collections.sort(files);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            for (int i = 0; i < files.size(); i++) {
                File archivo = files.get(i);
                System.out.println(String.format("%s (%s) - %s",
                        archivo.getAbsolutePath(),
                        archivo.isDirectory() ? "Carpeta" : "Archivo",
                        sdf.format(archivo.lastModified())
                ));
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
