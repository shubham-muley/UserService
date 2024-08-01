package dev.ecommerce.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "token")
public class Token extends BaseModel{
    private String tokenValue;
    private Date expiryDate;

    @ManyToOne
    private User user;
}
