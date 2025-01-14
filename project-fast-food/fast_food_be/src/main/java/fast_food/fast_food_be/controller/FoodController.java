package fast_food.fast_food_be.controller;


import fast_food.fast_food_be.dto.CartDto;
import fast_food.fast_food_be.dto.ListCartDto;
import fast_food.fast_food_be.entity.Customer;
import fast_food.fast_food_be.entity.Food;
import fast_food.fast_food_be.entity.OrderFood;
import fast_food.fast_food_be.service.CustomerService;
import fast_food.fast_food_be.service.FoodService;
import fast_food.fast_food_be.service.OrderFoodService;
import fast_food.fast_food_be.service.security.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {

    @Autowired
    FoodService foodService;

    @Autowired
    OrderFoodService orderFoodService;

    @Autowired
    AccountService accountService;

    @Autowired
    CustomerService customerService;

    @GetMapping("home/searchKey")
    public ResponseEntity<List<Food>> searchFood(@RequestParam(defaultValue = "keySearch") String keySearch) {
        List<Food> listFood = foodService.searchListFood(keySearch);
        if (listFood.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listFood, HttpStatus.OK);
    }

    @GetMapping("home/transaction/{username}")
    public ResponseEntity<List<OrderFood>> searchTransactionOfOrders(@PathVariable("username") String username) {
        List<OrderFood> orderFoodList = orderFoodService.getInfoOrderFood(username);
        if (orderFoodList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderFoodList, HttpStatus.OK);
    }

    @GetMapping("home/infoCustomer/{username}")
    public ResponseEntity<Customer> getInfoCustomer(@PathVariable("username") String username) {
        Customer customer = customerService.getInfoCustomer(username);
        if (customer != null) {
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("home/list")
    public ResponseEntity<Page<Food>> findAllFood(@PageableDefault(value = 12) Pageable pageable) {
        Page<Food> listFood = foodService.getListFood(pageable);
        if (listFood.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listFood, HttpStatus.OK);
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable("id") Long foodId) {
        Food food = foodService.getFoodById(foodId);
        if (food != null) {
            return new ResponseEntity<>(food, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "home/orders/{username}")
    public ResponseEntity<Void> createTransaction(@RequestBody ListCartDto listCartDto, @PathVariable("username") String username) {
        Long ordersId = accountService.getAccountByUsernameDto(username);
        for (int i = 0; i < listCartDto.getCartDtoList().size(); i++) {
            Integer quantity_food = listCartDto.getCartDtoList().get(i).getQuantity();
            Long foodId = listCartDto.getCartDtoList().get(i).getFood().getFoodId();
            CartDto cartDto = new CartDto();
            cartDto.setOrdersId(ordersId);
            cartDto.setQuantity(quantity_food);
            cartDto.setFoodId(foodId);
            orderFoodService.saveOrderFoodDto(cartDto);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
