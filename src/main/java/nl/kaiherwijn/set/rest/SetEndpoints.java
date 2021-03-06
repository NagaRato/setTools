package nl.kaiherwijn.set.rest;

import nl.kaiherwijn.set.model.Card;
import nl.kaiherwijn.set.service.SetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SetEndpoints {
    SetService setService;

    @PostMapping("isSet")
    public @ResponseBody
    ResponseEntity<Boolean> isSet(@RequestBody List<Card> cards) {
        return new ResponseEntity<Boolean>(SetService.isSet(cards), HttpStatus.OK);
    }

    @PostMapping("calcComplCard")
    public @ResponseBody
    ResponseEntity<Card> calculateComplementingCard(@RequestBody List<Card> cards) {
        return new ResponseEntity<Card>(SetService.calculateComplementingCard(cards), HttpStatus.OK);
    }

    @PostMapping("hasSet")
    public @ResponseBody
    ResponseEntity<Boolean> hasSet(@RequestBody List<Card> cards) {
        return new ResponseEntity<Boolean>(SetService.hasSet(cards), HttpStatus.OK);
    }
}
