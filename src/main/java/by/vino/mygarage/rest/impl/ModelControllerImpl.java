package by.vino.mygarage.rest.impl;

import by.vino.mygarage.dao.api.ModelRepository;
import by.vino.mygarage.dao.jpa.Model;
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
@RequestMapping("/rest/models")
public class ModelControllerImpl {

    @Autowired
    private ModelRepository modelRepository;

    /**
     * Processes GET request to '/rest/cars' and
     * returns all car by filter and sort.
     *
     * @return list of cars
     * */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listModels(@QuerydslPredicate(root = Model.class) Predicate predicate) {
        Iterable<Model> all = modelRepository.findAll(predicate);
        return ResponseEntity.ok(toListDto(all));
    }

    private List toListDto(Iterable<Model> models) {
        List<String> list = new ArrayList<>();
        for (Model model : models) {
            list.add(model.getModelName());
        }
        return list;
    }

}