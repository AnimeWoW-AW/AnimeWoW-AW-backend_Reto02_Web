/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto2_Web.repository.crud;


import Reto2_Web.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Nicolay
 */
public interface ProductCrudRepository extends MongoRepository<Product, String> {
    
}
