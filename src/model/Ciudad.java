package model;

public class Ciudad implements Comparable<Ciudad> {

    private String id;
    private String name;
    private String countryId;
    private Integer population;

    @Override
    public String toString() {
        return "Ciudad{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", countryId='" + countryId + '\'' +
                ", population=" + population +
                '}';
    }

    public Ciudad(String id, String name, String countryId, Integer population) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.population = population;
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

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public int compareTo(Ciudad o) {
        int compareName = this.getName().compareTo(o.getName());
        if(compareName ==0){
            int compareId= this.getId().compareTo(o.getId());
            if(compareId==0){
                int compareCountId = this.getCountryId().compareTo(o.getCountryId());
                if(compareCountId == 0){
                    int comparePopulation = this.getPopulation().compareTo(o.getPopulation());
                    return comparePopulation;
                }else{
                    return compareCountId;
                }
            }else {
                return compareId;
            }
        }else{
            return compareName;
        }

    }
}
