package co.rmgs.workshop.entity;

public class CountryDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String continent;

    public String getContinent() {
        return continent;
    }

    public void setContinent(String Continent) {
        this.continent = Continent;
    }

    private String population;

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    private String lifeExpectancy;

    public String getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(String lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    private String countryLanguage;

    public String getCountryLanguage() {
        return countryLanguage;
    }

    public void setCountryLanguage(String countryLanguage) {
        this.countryLanguage = countryLanguage;
    }

    public static CountryDTO of(String name, String continent, String population, String lifeExpectancy, String countryLanguage) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.name = name;
        countryDTO.continent = continent;
        countryDTO.countryLanguage = countryLanguage;
        countryDTO.lifeExpectancy = lifeExpectancy;
        countryDTO.population = population;
        return countryDTO;
    }

}
