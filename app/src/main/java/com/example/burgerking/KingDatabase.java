/*
  Copyright 2019 Luca Steingen
 */

package com.example.burgerking;
import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class KingDatabase {

    /***
     * Retrieves a product object using the provided id.
     */
    public static Product getProductById(int productID) {
        return products.get(productID);
    }

    /***
     * Return an ArrayList containing all the products in the database.
     */
    public static ArrayList<Product> getAllProducts() {
        return new ArrayList<Product>((List) Arrays.asList(products.values().toArray()));
    }

    /***
     * Return an ArrayList containing all the products that were ordered.
     */
    public static ArrayList<Product> getAllOrderedProducts() {
        ArrayList<Product> lst = new ArrayList<>();                                                 // Create ArrayList of Products called 'lst'
        for (int i = 1; i <= getAllProducts().size(); i++)                                          // From first ordered product to last ordered product, do...
            if (Objects.requireNonNull(products.get(i)).getAmount() > 0) {                          // A product is a ordered product, if it was ordered at least once.
                lst.add(products.get(i));                                                           // Add it to lst.
            }
        return lst;
        }

    // You can ignore everything below this for now.
    @SuppressLint("UseSparseArrays")
    private static final HashMap<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(
                1,
                "Whopper",
                "Our WHOPPER® Sandwich is a ¼ lb of savory flame-grilled beef topped with juicy tomatoes, fresh lettuce, creamy mayonnaise, ketchup, crunchy pickles, and sliced white onions on a soft sesame seed bun.\n" +
                        "\n" +
                        "Served with a small side of piping hot, thick cut French Fries or golden Onion Rings and a small fountain drink of your choice to make it a meal.",
                6.49,
                0,
                R.drawable.product1_image
        ));

        products.put(2, new Product(
                2,
                "Double Quarter Pound",
                "Our Double Quarter Pound™ Sandwich has over ½ lb. of flame-grilled 100% beef, topped with all of our classic favorites: American cheese, freshly sliced onions, zesty pickles, ketchup, & mustard all on a toasted sesame seed bun.",
                5.39,
                0,
                R.drawable.product2_image
        ));

        products.put(3, new Product(
                3,
                "Single PRETZEL BACON",
                "Our Single PRETZEL BACON™ Sandwich features one ¼ lb. of savory flame-grilled 100% beef patties, topped with smoky bacon, melted American cheese, tangy mustard and creamy mayonnaise all on a toasted pretzel bun.",
                6.19,
                0,
                R.drawable.product3_image
        ));

        products.put(4, new Product(
                4,
                "Spicy Crispy Chicken",
                "Introducing the Spicy Crispy Chicken Sandwich made with juicy, tender and crispy 100% white meat chicken, seasoned and breaded with bold flavors and just the right amount of heat; topped with fresh lettuce, a ripe tomato, and creamy mayonnaise all on a potato bun.",
                4.59,
                0,
                R.drawable.product4_image
        ));

        products.put(5, new Product(
                5,
                "Grilled Chicken",
                "Our New Grilled Chicken Sandwich is made with seasoned 100% white meat chicken filet, flame-grilled to perfection, marinated with spices, layered with fresh lettuce, ripe tomato, and sweet honey mustard on a toasted potato bun.",
                3.99,
                0,
                R.drawable.product5_image
        ));

        products.put(6, new Product(
                6,
                "Chicken Club Salad",
                "Our Chicken Club Salad is a mix of crispy green romaine, green leaf and radicchio lettuce, thick-cut smoked bacon pieces, shredded cheddar cheese, juicy-ripened tomatoes, and buttery garlic croutons.",
                5.59,
                0,
                R.drawable.product6_image
        ));

        products.put(7, new Product(
                7,
                "Chicken Garden Salad",
                "Our Chicken Garden Salad is a mix of crisp green romaine, green leaf and radicchio lettuce, juicy-ripened tomatoes, buttery garlic croutons, and shredded cheddar cheese.",
                5.99,
                0,
                R.drawable.product7_image
        ));

        products.put(8, new Product(
                8,
                "Garden Side Salad",
                "Our Garden Side Salad is a blend of premium lettuces garnished with juicy tomatoes, home-style croutons, a three-cheese medley, and your choice of KEN’S® salad dressing. Nutrition Information does not reflect home-style croutons or KEN’S salad dressing.",
                6.19,
                0,
                R.drawable.product8_image
        ));

        products.put(9, new Product(
                9,
                "Egg-Normous Burrito",
                "Featuring a generous serving of savory sausage, thick-cut smoked bacon, lots of fluffy eggs, shredded cheddar cheese, golden hash browns, plus a creamy spicy sauce all wrapped up in a warm flour tortilla and served with a side of Picante Sauce.",
                5.39,
                0,
                R.drawable.product9_image
        ));

        products.put(10, new Product(
                10,
                "Chicken Nuggets",
                "Made with white meat, our bite-sized Chicken Nuggets are tender and juicy on the inside and crispy on the outside. Coated in a homestyle seasoned breading, they are perfect for dipping in any of our delicious dipping sauces.",
                2.99,
                0,
                R.drawable.product10_image
        ));

        products.put(11, new Product(
                11,
                "Onion Rings",
                "Served hot and crispy, our golden Onion Rings are the perfect treat for plunging into one of our bold or classic sauces.",
                1.99,
                0,
                R.drawable.product11_image
        ));

        products.put(12, new Product(
                12,
                "French Fries",
                "More delicious than ever, our signature piping hot, thick cut Salted French Fries are golden on the outside and fluffy on the inside.",
                1.99,
                0,
                R.drawable.product12_image
        ));

        products.put(13, new Product(
                13,
                "Crispy Tacco",
                "Featuring a generous serving of savory sausage, thick-cut smoked bacon, lots of fluffy eggs, shredded cheddar cheese, golden hash browns, plus a creamy spicy sauce all wrapped up in a warm flour tortilla and served with a side of Picante Sauce.",
                3.39,
                0,
                R.drawable.product13_image
        ));

        products.put(14, new Product(
                14,
                "BK Coffee",
                "Our BK® Café Coffee blend is made with 100% Arabica beans and freshly brewed to deliver perfectly balanced flavor in every cup.",
                2.00,
                0,
                R.drawable.product14_image
        ));

        products.put(15, new Product(
                15,
                "Vanilla Soft Ice",
                "We didn’t invent soft serve, but with one taste of our cool, creamy, and velvety Vanilla Soft Serve, you’ll think we perfected it. Your choice of classic cone or cup.",
                1.00,
                0,
                R.drawable.product15_image
        ));
    }
}