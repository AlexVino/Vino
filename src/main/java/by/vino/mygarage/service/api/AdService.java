package by.vino.mygarage.service.api;

import by.vino.mygarage.dao.jpa.Ad;
import by.vino.mygarage.rest.dto.BaseCarDto;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Locale;

public interface AdService {
    /**
     * Creates new ad.
     *
     * @param ad ad
     * @param locale locale
     * */
    BaseCarDto create(BaseCarDto ad, Locale locale);

    /**
     * Updates ad.
     *
     * @param ad ad
     * */
    Ad update(Ad ad);

    /**
     * Removes ad.
     *
     * @param adId ad id
     * */
    void remove(int adId);

    /**
     * Load an ad.
     *
     * @param adId ad id
     * @param locale locale
     * */
    BaseCarDto get(int adId, Locale locale);

    /**
     * Loads list of ads by searching params.
     *
     * @param predicate search entity
     * @param pageable page, size
     */
    List<BaseCarDto> getAll(Predicate predicate, Pageable pageable, Locale locale);
}
