package by.vino.mygarage.rest.impl;

import by.vino.mygarage.dao.jpa.RoleEnum;
import by.vino.mygarage.dao.jpa.User;
import by.vino.mygarage.service.api.OrderService;
import by.vino.mygarage.service.api.UserService;
import by.vino.mygarage.util.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/orders")
public class OrderControllerImpl {

    @Autowired
    private OrderService orderService;
    @Autowired
    private SecurityHelper securityHelper;
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/{adId}")
    public ResponseEntity<?> create(@PathVariable("adId") int adId) {
        User user = userService.loadUserByUsername(securityHelper.getCurrentUser().getUsername());
        return ResponseEntity.ok(orderService.create(adId, user));
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_DEALER')")
    @GetMapping()
    public ResponseEntity<List<?>> getAll() {
        UserDetails user = securityHelper.getCurrentUser();
        if (securityHelper.isRoleAuthority(user, RoleEnum.ROLE_DEALER)) {
            return ResponseEntity.ok(orderService.getAllDealers(user.getUsername()));
        } else {
            return ResponseEntity.ok(orderService.getAll(user.getUsername()));
        }
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_DEALER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        UserDetails user = securityHelper.getCurrentUser();
        if (securityHelper.isRoleAuthority(user, RoleEnum.ROLE_DEALER)) {
            orderService.removeWithAd(id);
        } else {
            orderService.remove(id);
        }
        return ResponseEntity.ok(true);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/ads/{id}")
    public ResponseEntity<?> deleteByAdId(@PathVariable("id") int id) {
        orderService.removeByAdId(id);
        return ResponseEntity.ok(true);
    }
}