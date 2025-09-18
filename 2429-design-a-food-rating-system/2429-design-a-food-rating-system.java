class FoodRatings {
    private Map<String,String> foodToCuisine;
    private Map<String,Integer> foodToRating;
    private Map<String,TreeSet<String>> cuisineToFoods;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine=new HashMap<>();
        foodToRating=new HashMap<>();
        cuisineToFoods=new HashMap<>();
        for(int i=0;i<foods.length;i++){
            String food=foods[i];
            String cuisine=cuisines[i];
            int rating=ratings[i];
            foodToCuisine.put(food,cuisine);
            foodToRating.put(food,rating);
            // Always keep foods sorted by rating (descending)
            // Break ties using lexicographic order (ascending)
            cuisineToFoods.computeIfAbsent(cuisine,k->new TreeSet<>((a,b)->{
                int cmp=Integer.compare(foodToRating.get(b),foodToRating.get(a));
                if(cmp==0) return a.compareTo(b);
                return cmp;
            })).add(food);


        }
    }
    
    public void changeRating(String food, int newRating) {
        
        String cuisine=foodToCuisine.get(food);
        TreeSet<String> set=cuisineToFoods.get(cuisine);
        set.remove(food);
        foodToRating.put(food,newRating);
        set.add(food);
    }
    
    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first();
    }
}
// Map<String, PriorityQueue<String>> cuisineToFoods;

// HashMap foodToCuisine: food → cuisine
// HashMap foodToRating: food → rating
// HashMap cuisineToFoods: cuisine → ordered set of foods

// cuisineToFoods.putIfAbsent(cuisine, 
//     new TreeSet<>((a, b) -> {
//         int cmp = Integer.compare(foodToRating.get(b), foodToRating.get(a));
//         return (cmp == 0) ? a.compareTo(b) : cmp;
//     })
// );

// cuisineToFoods.get(cuisine).add(food);


/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */