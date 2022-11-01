package model;

import java.nio.channels.Pipe;

public class Pais implements Comparable<Pais> {

    private String id;
    private String name;
    private Double population;
    private String countryCode;



    public Pais(String id, String name, Double population, String countryCode) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.countryCode = countryCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public int compareTo(Pais o) {
        int compareId = this.getId().compareTo(o.getId());
        if (compareId == 0) {
            int compareName = this.getName().compareTo(o.getName());
            if (compareName == 0) {
                int comparePopulation = this.getPopulation().compareTo(o.getPopulation());
                if (comparePopulation == 0) {
                    int compareCountryCode = this.getCountryCode().compareTo(o.getCountryCode());
                    return compareCountryCode;
                }else{
                    return comparePopulation;
                }
            } else {
                return compareName;
            }
        } else {
            return compareId;
        }
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }

}
