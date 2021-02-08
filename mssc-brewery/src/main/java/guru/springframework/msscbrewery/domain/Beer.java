package guru.springframework.msscbrewery.domain;

import java.sql.Timestamp;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//the beer entity that we'd be persisting to the persistence tier(JPA or MongoDB...)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {
    private UUID id;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;

    //use with database,因为interface与这儿不一样所以要转换
    private Timestamp createdDate;
    private Timestamp lastUpdatedDate;
}
