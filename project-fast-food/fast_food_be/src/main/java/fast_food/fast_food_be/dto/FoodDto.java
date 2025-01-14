package fast_food.fast_food_be.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodDto {
    private Long foodId;
    private String foodName;
    private Integer foodPrice;
    private String image;
}
