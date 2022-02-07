package com.codecool.myrestaurantapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Order {

    private int id;
    private List<Receipt> foods;
    private Customer customer;
    private LocalDateTime orderTime;
    private BigDecimal totalPrice;
    private String formattedDateTime;

    public void countTotalPrice() {
        totalPrice = BigDecimal.ZERO;
        for (Receipt food : foods) {
            totalPrice = totalPrice.add(food.getPrice());
        }
    }
    public void formatDate() {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    formattedDateTime = orderTime.format(format);
    }
}
