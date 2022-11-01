package main;

import model.ControlSystemInformation;
import model.Pais;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

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

                switch (opcion) {
                    case 1:
                        secondMenu();
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
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
    public static void secondMenu(){
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Agregar datos");
            System.out.println("2. buscar y filtrar");
            System.out.println("3. ordenar");
            System.out.println("4. Eliminar");
            System.out.println("5. volver al menu principal");


            try {

                System.out.println("Escribe una de las opciones: ");
                opcion = sn.nextInt();
                sn.nextLine();

                switch (opcion) {
                    case 1:
                        agregarDatos();
                        break;
                    case 2:
                        buscarYFiltrar();
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 2");
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
    public static void agregarDatos(){
        String comando;
        System.out.println("inserte comando: ");

        comando = sn.nextLine();

        int res = control.verifyComandoAgregar(comando);

        if(res==1){
            control.agregarPais(comando);
            System.out.println("pais agregado con exito");
        } else if (res==0) {
            control.agregarCiudad(comando);
            System.out.println("ciudad agregado con exito");
        }else if(res==2){
            System.out.println("comando incorrecto");
        }

    }

    public static void buscarYFiltrar(){
        String comando = "";
        System.out.println("digite el comando para hacer la busqueda: ");
        comando = sn.nextLine();
        control.verifyComandoBuscar(comando);

    }
}
