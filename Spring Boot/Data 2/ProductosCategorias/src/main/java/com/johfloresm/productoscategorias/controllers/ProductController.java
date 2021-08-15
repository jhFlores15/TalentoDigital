package com.johfloresm.productoscategorias.controllers;

import com.johfloresm.productoscategorias.models.Category;
import com.johfloresm.productoscategorias.models.Product;
import com.johfloresm.productoscategorias.services.CategoryService;
import com.johfloresm.productoscategorias.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("products")
public class ProductController{

    @Autowired
    private ProductService  productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("new")
    public String create(@ModelAttribute("product") Product product){
        return "products/create.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String store (@Valid @ModelAttribute("product") Product product, BindingResult result){
        if(result.hasErrors()){
            return "products/create.jsp";
        }

        productService.createProduct(product);
        return "redirect:/products/"+product.getId();
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getCategories());
        return "products/show.jsp";
    }

    @RequestMapping(value = "/{idProduct}", method = RequestMethod.POST)
    public String addCategory(@PathVariable("idProduct") Long idProduct, @RequestParam("idCategory") Long idCategory){
        Product product = productService.getProductById(idProduct);
        Category category = categoryService.getCategoryById(idCategory);
        product.setCategory(category);
        productService.createProduct(product);

        return "redirect:/products/"+idProduct;
    }

}
