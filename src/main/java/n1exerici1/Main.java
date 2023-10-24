package n1exerici1;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    public static void main(String[] args) {
        ArrayList<String> directoryList = new ArrayList<String>();
        String directorio = "";
        if (args.length>0)
        {
            directorio = args[0];
            System.out.println("El directorio que voy a listar es: " + directorio);

            File carpeta = new File(directorio);
            String[] listado = carpeta.list();
            if (listado == null || listado.length == 0) {
                System.out.println("No hay elementos dentro de la carpeta actual");
                return;
            }
            else {
                for (int i=0; i< listado.length; i++) {
                    directoryList.add(listado[i]);

                }
                Collections.sort(directoryList);
                System.out.println(directoryList);
            }
        }else{
            System.out.println("Me tienes que indicar un directorio para listar.");
        }
    }
}
