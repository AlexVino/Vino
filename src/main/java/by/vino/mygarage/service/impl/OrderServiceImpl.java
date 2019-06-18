package by.vino.mygarage.service.impl;

import by.vino.mygarage.dao.api.AdRepository;
import by.vino.mygarage.dao.api.CarRepository;
import by.vino.mygarage.dao.api.OrderRepository;
import by.vino.mygarage.dao.jpa.Ad;
import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.dao.jpa.Order;
import by.vino.mygarage.dao.jpa.User;
import by.vino.mygarage.exception.ErrorCode;
import by.vino.mygarage.exception.RestException;
import by.vino.mygarage.rest.dto.OrderDto;
import by.vino.mygarage.rest.dto.OrderExtDto;
import by.vino.mygarage.service.api.AdService;
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
    @Autowired
    private AdRepository adRepository;
    @Autowired
    private AdService adService;

    @Override
    public Order create(int adId, User user) {
        if (orderRepository.findByAd_AdId(adId) != null) {
            throw new RestException(ErrorCode.CAR_ALREADY_ORDERED);
        }
        //Car car = carRepository.findById(carId).orElse(null);
        Ad ad = adRepository.findById(adId).orElse(null);
        if (ad == null) {
            throw new RestException(ErrorCode.AD_DOES_NOT_EXIST);
        }
        Order order = new Order();
        order.setAd(ad);
        order.setUser(user);
        return orderRepository.save(order);
    }

    @Override
    public void remove(int orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public void removeByAdId(int adId) {
        Order order = orderRepository.findByAd_AdId(adId);
        orderRepository.deleteById(order.getOrderId());
    }

    @Override
    public void removeWithAd(int orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            orderRepository.deleteById(orderId);
            //carRepository.deleteById(order.getCar().getCarId());
            //adRepository.deleteById(order.getAd().getAdId());
            adService.remove(order.getAd().getAdId());
        }
    }

    @Override
    public OrderDto getByAdIdAndUsername(int adId, String username) {
        return toDto(orderRepository.findByAd_AdIdAndUser_Username(adId, username));
    }

    @Override
    public List<OrderDto> getAll(String username) {
        return toDtos(orderRepository.findAllByUser_Username(username));
    }


    @Override
    public List<OrderExtDto> getAllDealers(String username) {
        return toExtDtos(orderRepository.findAllByAd_User_Username(username));
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
                order.getAd().getCar().getComplectation().getModel().getMake().getMakeName(),
                order.getAd().getCar().getComplectation().getModel().getModelName()));
        dto.setPrice(order.getAd().getCar().getPrice());
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
                        order.getAd().getCar().getComplectation().getModel().getMake().getMakeName(),
                        order.getAd().getCar().getComplectation().getModel().getModelName()));
        dto.setPrice(order.getAd().getCar().getPrice());
        dto.setFirstname(order.getUser().getFirstname());
        dto.setLastname(order.getUser().getLastname());
        dto.setPhone(order.getUser().getPhone());
        return dto;
    }
}
