import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.Objects; // Objects.equals, Objects.hash 사용

class FoodRatings {

    // 음식 이름으로 Food 객체를 빠르게 찾기 위한 맵
    private Map<String, Food> foodMap;
    // 음식 이름으로 해당 음식의 요리 종류를 빠르게 찾기 위한 맵
    private Map<String, String> foodCuisineMap;
    // 요리 종류별로 Food 객체들을 정렬된 상태로 유지하기 위한 맵
    // TreeSet은 평점(내림차순), 이름(오름차순)으로 Food 객체를 정렬합니다.
    private Map<String, TreeSet<Food>> cuisineToSortedFoodsMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        cuisineToSortedFoodsMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], ratings[i]);
            foodMap.put(foods[i], food); // 음식 이름으로 Food 객체 저장
            foodCuisineMap.put(foods[i], cuisines[i]); // 음식 이름으로 요리 종류 저장

            // 해당 요리에 대한 TreeSet을 가져오거나 새로 생성한 후, Food 객체 추가
            cuisineToSortedFoodsMap
                    .computeIfAbsent(cuisines[i], k -> new TreeSet<>())
                    .add(food);
        }
    }

    public void changeRating(String foodName, int newRating) {
        // 1. 해당 Food 객체와 요리 종류를 가져옵니다.
        Food oldFood = foodMap.get(foodName);
        String cuisine = foodCuisineMap.get(foodName);

        // 2. TreeSet에서 기존 Food 객체를 제거합니다.
        // Food 객체의 평점이 변경되면 TreeSet 내에서의 정렬 위치가 바뀌므로,
        // 변경 전에 제거하는 것이 중요합니다. (O(log M) 시간 복잡도)
        TreeSet<Food> sortedFoods = cuisineToSortedFoodsMap.get(cuisine);
        sortedFoods.remove(oldFood);

        // 3. Food 객체의 평점을 업데이트합니다.
        oldFood.changeRating(newRating);

        // 4. 업데이트된 Food 객체를 TreeSet에 다시 추가합니다.
        // 객체는 새로운 평점에 따라 올바른 정렬 위치에 삽입됩니다. (O(log M) 시간 복잡도)
        sortedFoods.add(oldFood);
    }

    public String highestRated(String cuisine) {
        // TreeSet은 항상 정렬된 상태를 유지하므로, 첫 번째 요소가 가장 높은 평점의 음식입니다.
        // (O(1) 시간 복잡도)
        return cuisineToSortedFoodsMap.get(cuisine).first().getName();
    }

    // Food 클래스: Comparable 인터페이스를 구현하여 TreeSet에서 정렬 가능하게 함
    public class Food implements Comparable<Food> {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        public int getRating() {
            return this.rating;
        }

        public String getName() {
            return this.name;
        }

        public void changeRating(int rating) {
            this.rating = rating;
        }

        // TreeSet 정렬을 위한 비교 로직 구현:
        // 1. 평점은 내림차순 (높은 평점이 먼저 오도록)
        // 2. 평점이 같으면 이름은 오름차순 (사전순으로 빠른 이름이 먼저 오도록)
        @Override
        public int compareTo(Food other) {
            // 평점이 다르면 평점을 기준으로 내림차순 정렬
            if (this.rating != other.rating) {
                return other.rating - this.rating;
            }
            // 평점이 같으면 이름을 기준으로 오름차순 정렬
            return this.name.compareTo(other.name);
        }

        // Food 객체의 동일성 정의: 이름이 같으면 같은 음식으로 간주
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Food food = (Food) o;
            return Objects.equals(name, food.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}