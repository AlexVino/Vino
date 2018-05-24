package by.vino.mygarage.service.impl;

import by.vino.mygarage.dao.api.CarRepository;
import by.vino.mygarage.dao.api.OrderRepository;
import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.dao.jpa.Order;
import by.vino.mygarage.dao.jpa.User;
import by.vino.mygarage.exception.ErrorCode;
import by.vino.mygarage.exception.RestException;
import by.vino.mygarage.rest.dto.OrderDto;
import by.vino.mygarage.rest.dto.OrderExtDto;
import by.vino.mygarage.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CarRepository carRepository;

    @Override
    public Order create(int carId, User user) {
        if (orderRepository.findByCar_CarId(carId) != null) {
            throw new RestException(ErrorCode.CAR_ALREADY_ORDERED);
        }
        Car car = carRepository.findById(carId).orElse(null);
        if (car == null) {
            throw new RestException(ErrorCode.CAR_DOES_NOT_EXIST);
        }
        Order order = new Order();
        order.setCar(car);
        order.setUser(user);
        return orderRepository.save(order);
    }

    @Override
    public void remove(int orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public void removeByCarId(int carId) {
        Order order = orderRepository.findByCar_CarId(carId);
        orderRepository.deleteById(order.getOrderId());
    }

    @Override
    public void removeWithCar(int orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            orderRepository.deleteById(orderId);
            carRepository.deleteById(order.getCar().getCarId());
        }
    }

    @Override
    public OrderDto getByCarIdAndUsername(int carId, String username) {
        return toDto(orderRepository.findByCar_CarIdAndUser_Username(carId, username));
    }

    @Override
    public List<OrderDto> getAll(String username) {
        return toDtos(orderRepository.findAllByUser_Username(username));
    }

    @Override
    public List<OrderExtDto> getAll() {
        return toExtDtos(orderRepository.findAll());
    }

    private List<OrderDto> toDtos(Iterable<Order> orders) {
        List<OrderDto> dtos = new ArrayList<>();
        if (orders != null) {
            for (Order order : orders) {
                dtos.add(toDto(order));
            }
        }
        return dtos;
    }

    private List<OrderExtDto> toExtDtos(Iterable<Order> orders) {
        List<OrderExtDto> dtos = new ArrayList<>();
        if (orders != null) {
            for (Order order : orders) {
                dtos.add(toExtDto(order));
            }
        }
        return dtos;
    }

    private OrderDto toDto(Order order) {
        if (order == null) {
            return null;
        }
        OrderDto dto = new OrderDto();
        dto.setId(order.getOrderId());
        dto.setFullModel(
                String.format("%s %s",
                order.getCar().getModel().getMake().getMakeName(),
                order.getCar().getModel().getModelName()));
        dto.setPrice(order.getCar().getPrice());
        return dto;
    }

    private OrderExtDto toExtDto(Order order) {
        if (order == null) {
            return null;
        }
        OrderExtDto dto = new OrderExtDto();
        dto.setId(order.getOrderId());
        dto.setFullModel(
                String.format("%s %s",
                        order.getCar().getModel().getMake().getMakeName(),
                        order.getCar().getModel().getModelName()));
        dto.setPrice(order.getCar().getPrice());
        dto.setFirstname(order.getUser().getFirstname());
        dto.setLastname(order.getUser().getLastname());
        dto.setPhone(order.getUser().getPhone());
        return dto;
    }
}
