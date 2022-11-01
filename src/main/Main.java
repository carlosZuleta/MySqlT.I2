package main;

import model.ControlSystemInformation;
import model.Pais;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Component {

    public static Scanner sn = new Scanner(System.in);
    public static ControlSystemInformation control= new ControlSystemInformation();

    public static void main(String[] args) {
        firstmenu();
    }


    public static void firstmenu(){

        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Insertar comando");
            System.out.println("2. Importar datos desde archivo .SQL");
            System.out.println("3. Salir");


            try {

                System.out.println("Escribe una de las opciones: ");
                opcion = sn.nextInt();
                sn.nextLine();

                switch (opcion) {
                    case 1:
                        verComando();
                        break;
                    case 2:
                        leerArchivoTxt();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }
    public static void verComando(){
        String posibles1 = "INSERT";
        String posibles2 = "SELECT";
        String posibles3 = "DELETE";


        String comando;
        System.out.println("inserte comando: ");

        comando = sn.nextLine();

        String aux = comando;
        aux = aux.toUpperCase();

        String[] comando1= aux.split("\\(");

        String aux2 = comando1[0];


        String[] comando2 =aux2.split(" ");
        String aux3 = comando2[0];


        if(aux3.equals(posibles1)){
            agregarDatos(comando);
        } else if (aux3.equals(posibles2)) {
            buscarYFiltrar(comando);
        } else if (aux3.equals(posibles3)) {
            eliminarDato(comando);
        }

    }
    public static void agregarDatos(String comandoU){


        int res = control.verifyComandoAgregar(comandoU);

        if(res==1){
            control.agregarPais(comandoU);
            System.out.println("pais agregado con exito");
        } else if (res==0) {
            control.agregarCiudad(comandoU);
            System.out.println("ciudad agregado con exito");
        }else if(res==2){
            System.out.println("comando incorrecto");
        }

    }

    public static void buscarYFiltrar(String comandoU){

        control.verifyComandoBuscar(comandoU);

    }
    public static void eliminarDato(String comando){

    }

    public static void leerArchivoTxt()  {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null);

        if(seleccion == JFileChooser.APPROVE_OPTION){

            File fichero = fileChooser.getSelectedFile();

            try{
                FileReader fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                String comando;

                while((comando=br.readLine())!=null){
                    agregarDatos(comando);
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }



    }

}
