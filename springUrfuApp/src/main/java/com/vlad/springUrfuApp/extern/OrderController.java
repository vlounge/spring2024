package com.vlad.springUrfuApp.extern;

import com.vlad.springUrfuApp.app.AppUserService;
import com.vlad.springUrfuApp.app.OrderService;
import com.vlad.springUrfuApp.domain.AppUserEntity;
import com.vlad.springUrfuApp.domain.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Класс контоллера, для работы с заказамии
 */
@RestController
@RequestMapping("/api/orders")

@AllArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    private final AppUserService appUserService;
    /**
     * Метод регистрации нового заказа
     * @return Данные о заказе
     */
    @PostMapping
    public OrderDTO postOrder(@RequestBody OrderDTO orderDTO){
        log.trace("OrderDTO {} ", orderDTO);
        long appUserId = orderDTO.getUserId();
        if(orderDTO.isUserNew()){
            AppUserEntity appUserEntity = appUserService.newUser(new AppUserEntity(
                            orderDTO.getIp(),
                            orderDTO.getCity(),
                            orderDTO.getPhoneNumber(),
                            orderDTO.getName(),
                            "changeme"
                    ));
            appUserId = appUserEntity.getId();
        }
            orderService.newOrder(new OrderEntity(
                    appUserId,
                    false,
                    orderDTO.getItemId()
        ));


        return OrderDTO.builder()
                .userId(appUserId)
                .ip(orderDTO.getIp())
                .city(orderDTO.getCity())
                .phoneNumber(orderDTO.getPhoneNumber())
                .name(orderDTO.getName())
                .itemId(orderDTO.getItemId())
                .build();
    }
}
