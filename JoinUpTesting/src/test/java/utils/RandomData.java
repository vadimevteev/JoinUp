package utils;

import com.github.javafaker.Faker;

public class RandomData {
   private static final Faker faker = new Faker();

   public static int getRandomInt(){
        return faker.random().nextInt(6) + 3;
   }
}
