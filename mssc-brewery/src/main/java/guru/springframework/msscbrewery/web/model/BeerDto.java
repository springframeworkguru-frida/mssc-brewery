package guru.springframework.msscbrewery.web.model;


import java.time.OffsetDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;

    //date type using in public facing interface
    private OffsetDateTime createdDate;

    private OffsetDateTime lastUpdatedDate;
}
