package by.vino.mygarage.rest.impl;

import by.vino.mygarage.dao.api.MakeRepository;
import by.vino.mygarage.dao.jpa.Make;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/rest/makes")
public class MakeControllerImpl {

    @Autowired
    private MakeRepository makeRepository;

    /**
     * Processes GET request to '/rest/makes' and
     * returns all car by filter and sort.
     *
     * @return list of cars
     * */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listMakes(@QuerydslPredicate(root = Make.class) Predicate predicate) {
        Iterable<Make> all = makeRepository.findAll(predicate);
        return ResponseEntity.ok(toListDto(all));
    }

    private List toListDto(Iterable<Make> makes) {
        List<String> list = new ArrayList<>();
        for (Make make : makes) {
            list.add(make.getMakeName());
        }
        return list;
    }

}