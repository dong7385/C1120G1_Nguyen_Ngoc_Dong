package fast_food.fast_food_be.repository;

import fast_food.fast_food_be.dto.CartDto;
import fast_food.fast_food_be.entity.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderFoodRepository extends JpaRepository<OrderFood, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into order_food(food_id,quantity_food,orders_id) " +
            "values(?1,?2,?3) ", nativeQuery = true)
    void saveOrderFoodDto(Long foodId, Integer quantityFood, Long ordersId);

    @Query(value = "select * " +
            " from orders " +
            " join  `account` on orders.account_id = `account`.account_id " +
            " join order_food on orders.orders_id = order_food.orders_id " +
            " where `account`.`username`= ?1 ", nativeQuery = true)
    List<OrderFood> getInfoOrderFood(String username);
}
