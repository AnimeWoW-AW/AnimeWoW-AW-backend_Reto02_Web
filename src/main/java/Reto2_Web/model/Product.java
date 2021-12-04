package Reto2_Web.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Nicolay
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")

public class Product {
    @Id
    private String reference;
    private String brand;
    private String category;
    private String presentation;
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;

}