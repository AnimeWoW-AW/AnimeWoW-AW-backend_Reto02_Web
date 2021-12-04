/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.service;

import Reto2_Web.model.Product;
import Reto2_Web.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nicolay
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    /**
     * Metodo para obtener all
     * @return
     */
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    /**
     * Metodo para obtener el producto
     * @param reference
     * @return
     */
    public Optional<Product> getProduct(String reference) {
        return productRepository.getProduct(reference);
    }

    /**
     * Metodo para crear el producto
     * @param product
     * @return
     */
    public Product save(Product product) {
        if (product.getReference() == null) {
            return product;
        } else {
            return productRepository.save(product);
        }
    }

    /**
     * Metodo para actualizar el producto
     * @param product
     * @return
     */
    public Product update(Product product) {
        if (product.getReference() != null) {
            Optional<Product> dbProduct = productRepository.getProduct(product.getReference());
            if (!dbProduct.isEmpty()) {
                if (product.getBrand()!= null) {
                    dbProduct.get().setBrand(product.getBrand());
                }
                if (product.getCategory() != null) {
                    dbProduct.get().setCategory(product.getCategory());
                }
                if (product.getPresentation() != null) {
                    dbProduct.get().setPresentation(product.getPresentation());
                }
                if (product.getDescription() != null) {
                    dbProduct.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    dbProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    dbProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    dbProduct.get().setPhotography(product.getPhotography());
                }
                dbProduct.get().setAvailability(product.isAvailability());
                productRepository.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    /**
     * Metodo para eliminar el producto
     * @param reference
     * @return
     */
    public boolean delete(String reference){
        return getProduct(reference).map(product -> {
            productRepository.delete(product);
            return true;
        }).orElse(false);
    }

    /**public boolean delete(String reference) {
        Boolean aBoolean = getProduct(reference).map(product -> {
            productRepository.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }*/

}
