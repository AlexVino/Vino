package by.vino.mygarage.rest.impl;

import by.vino.mygarage.dao.jpa.Ad;
import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.rest.dto.BaseCarDto;
import by.vino.mygarage.service.api.AdService;
import by.vino.mygarage.service.api.CarService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping("/rest/ads")
public class AdControllerImpl {

    @Autowired
    private AdService adService;

    /**
     * Processes GET request to '/rest/ads' and
     * returns all ads by filter and sort.
     *
     * @return list of ads
     * */
    @GetMapping
    public ResponseEntity<?> listAds(
            @QuerydslPredicate(root = Ad.class) Predicate predicate, Pageable pageable, Locale locale) {
        return ResponseEntity.ok(adService.getAll(predicate, pageable, locale));
    }

    /**
     * Processes GET request to '/rest/ads/{id}' and
     * returns the ad.
     *
     * @return ad
     * */
    @GetMapping("/{id}")
    public ResponseEntity<?> getAd(@PathVariable("id") int adId, Locale locale) {
        return ResponseEntity.ok(adService.get(adId, locale));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DEALER') or hasRole('ROLE_USER')")
    public ResponseEntity<?> addAd(@RequestBody @Valid BaseCarDto dto, Locale locale) {
        return ResponseEntity.ok(adService.create(dto, locale));
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DEALER') or hasRole('ROLE_USER')")
    public ResponseEntity<?> updateAd(@RequestBody @Valid BaseCarDto dto, Locale locale) {
        return ResponseEntity.ok(adService.create(dto, locale));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DEALER') or hasRole('ROLE_USER')")
    public ResponseEntity<?> deleteAd(@PathVariable("id") int id) {
        adService.remove(id);
        return ResponseEntity.ok(true);
    }
}
