package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ControlSystemInformation {



    public ControlSystemInformation() {

    }

    public ArrayList<Pais> countrys = new ArrayList<>();
    public ArrayList<Ciudad> citys = new ArrayList<>();

    public int verifyComandoAgregar(String comando){

        String posibles1 = "COUNTRIES";
        String posibles2 = "CITIES";

        String aux = comando;
        aux = aux.toUpperCase();

        String[] comando1= aux.split("\\(");

        String aux2 = comando1[0];


        String[] comando2 =aux2.split(" ");
        String aux3 = comando2[2];

        if(aux3.equals(posibles1) ){
            return 1;
        }else if(aux3.equals(posibles2)){
            return 0;
        }else{
            return 2;
        }
    }


    public Pais agregarPais(String comando){
        String aux = comando;
        aux = aux.toUpperCase();

        String[] comando1= aux.split("\\(");

        String[] comando2 = comando1[1].split("\\)");

        String[] comando3 = comando1[2].split("\\)");

        String[] comando4 = comando3[0].split(",");

        Double population =Double.parseDouble(comando4[2]);

        Pais p = new Pais(comando4[0],comando4[1],population,comando4[3]);

        countrys.add(p);

        return p;
    }


    public boolean agregarCiudad(String comando){
        String aux = comando;
        aux = aux.toUpperCase();

        String[] comando1= aux.split("\\(");

        String[] comando2 = comando1[1].split("\\)");

        String[] comando3 = comando1[2].split("\\)");

        String[] comando4 = comando3[0].split(",");

        String[] comando5 = comando4[2].split(" ");


        String[] comandoaux = comando4[3].split(" ");

        int population =Integer.parseInt(comandoaux[1]);

        String aux6 = comando5[1];


        for(int i = 0; i < countrys.size();i++){
            String id = countrys.get(i).getId();
            if(id.equals(aux6)){
                Ciudad c = new Ciudad(comando4[0],comando4[1],comando4[2],population);
                citys.add(c);
                return true;
            }
        }

        return false;
    }

    public void verifyComandoBuscar(String comando){

        String posibles1 = "COUNTRIES";
        String posibles2 = "CITIES";

        String aux = comando;
        aux = aux.toUpperCase();

        String[] comando1= aux.split(" ");



        if(comando1.length == 4){
            String aux1 = comando1[3];
            if(aux1.equals(posibles1)){
                listarpaises();
            } else if (aux1.equals(posibles2)) {
                listarCiudades();
            }else {
                System.out.println("comando incorrecto");
            }
        }


    }

    public void listarpaises(){
        for(int i=0;i<countrys.size();i++){
            System.out.println("[" + countrys.get(i).getName()+"]\n");
        }
    }

    public void listarCiudades(){
        for(int i=0;i<citys.size();i++){
            System.out.println("[" + citys.get(i).getName()+"]\n");
        }
    }





    //ORDENAMIENTOS Pais
    public void sortByIdC(){
        Collections.sort(countrys, Comparator.comparing(Pais::getId));
    }
    public void sortByNameC(){
        Collections.sort(countrys,Comparator.comparing(Pais::getName));
    }

    public void sortByPopulationC(){
        Collections.sort(countrys,Comparator.comparing(Pais::getPopulation));
    }
    public void sortByCountryCode(){
        Collections.sort(countrys,Comparator.comparing(Pais::getCountryCode));
    }

    //ORDENAMIENTOS ciudad

    public void sortByIdD(){
        Collections.sort(citys, Comparator.comparing(Ciudad::getId));
    }
    public void sortByNameD(){
        Collections.sort(citys,Comparator.comparing(Ciudad::getName));
    }

    public void sortByPopulationD(){
        Collections.sort(citys,Comparator.comparing(Ciudad::getPopulation));
    }
    public void sortByCountryId(){
        Collections.sort(citys,Comparator.comparing(Ciudad::getCountryId));
    }


}
