package com.kodilla.ecommercee.domain.user;

import com.kodilla.ecommercee.domain.order.Order;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "User")
public class User {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "USER_KEY")
    private int userKey;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "orderId"
    )
    public List<Order> order = new ArrayList<>();

    public User(String username, int status, int userKey) {
        this.username = username;
        this.status = status;
        this.userKey = userKey;
    }
}