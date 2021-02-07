package guru.springframework.msscbrewery.web.controller.v2;


import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {

        this.beerServiceV2 = beerServiceV2;
    }


    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // POST - create new beer
    public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDtoV2){

        BeerDtoV2 savedDto = beerServiceV2.savedBeer(beerDtoV2);

        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to url
        headers.add("Location", "http://localhost:8080/api/v2/beer"+ savedDto.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"}) //id is owned by the internal system, read-only property for the client
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, BeerDtoV2 beerDtoV2){

        beerServiceV2.updateBeer(beerId, beerDtoV2);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteById(beerId);
    }
}
