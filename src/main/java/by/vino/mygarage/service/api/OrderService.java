package by.vino.mygarage.service.api;

import by.vino.mygarage.dao.jpa.Order;
import by.vino.mygarage.dao.jpa.User;
import by.vino.mygarage.rest.dto.BaseCarDto;
import by.vino.mygarage.rest.dto.OrderDto;
import by.vino.mygarage.rest.dto.OrderExtDto;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Locale;

public interface OrderService {
    Order create(int carId, User user);

    void remove(int orderId);

    void removeWithCar(int orderId);

    OrderDto getByCarIdAndUsername(int carId, String username);

    List<OrderDto> getAll(String username);

    List<OrderExtDto> getAll();
}
