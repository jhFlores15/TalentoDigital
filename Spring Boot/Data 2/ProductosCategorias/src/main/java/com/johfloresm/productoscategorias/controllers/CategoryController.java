package com.johfloresm.productoscategorias.controllers;

import com.johfloresm.productoscategorias.models.Category;
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

@Controller
@RequestMapping("categories")
public class CategoryController{

    @Autowired
    private ProductService  productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("new")
    public String create(@ModelAttribute("category") Category category){
        return "categories/create.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String store (@Valid @ModelAttribute("category") Category category, BindingResult result){
        if(result.hasErrors()){
            return "categories/create.jsp";
        }

        categoryService.createCategory(category);
        return "redirect:/categories/"+category.getId();
    }

    @RequestMapping("{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        model.addAttribute("products", productService.getProducts());
        return "categories/show.jsp";
    }

    @RequestMapping(value = "{idCategory}", method = RequestMethod.POST)
    public String addCategory(@PathVariable("idCategory") Long idCategory, @RequestParam("idProduct") Long idProduct){
        Product  product = productService.getProductById(idProduct);
        Category category = categoryService.getCategoryById(idCategory);
        category.setProduct(product);
        categoryService.createCategory(category);

        return "redirect:/categories/"+idCategory;
    }
    
    



}
