package co.rmgs.workshop.entity.service;

import co.rmgs.workshop.entity.CountryDTO;
import co.rmgs.workshop.entity.service.exception.CountryNotFoundException;
import co.rmgs.workshop.entity.service.exception.DatabaseConnectionException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CountryService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public CountryDTO getCountry(String code) {
        try {
            String countrySQL = "select name"
                    + ", continent"
                    + ", population"
                    + ", life_expectancy"
                    + ", lang.language"
                    + " from country cou"
                    + " join country_language lang on lang.country_code = cou.code"
                    + " and lang.is_official = true"
                    + " where cou.code = ?";

            List<CountryDTO> countries = jdbcTemplate.query(countrySQL,
                    new Object[]{code},
                    (rs, rowNum) -> CountryDTO.of(rs.getString("name"),
                            rs.getString("continent"),
                            rs.getString("population"),
                            rs.getString("life_expectancy"),
                            rs.getString("language")));
            if (countries != null && !countries.isEmpty()) {
                return countries.get(0);
            } else {
                throw new CountryNotFoundException("INVALID_COUNTRY_CODE");
            }
        } catch (DataAccessException e) {
            throw new DatabaseConnectionException("INTERNAL_ERROR");
        }
    }
}
