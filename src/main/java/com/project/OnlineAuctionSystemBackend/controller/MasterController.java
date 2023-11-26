package com.project.OnlineAuctionSystemBackend.controller;

import com.project.OnlineAuctionSystemBackend.dto.ItemDto;
import com.project.OnlineAuctionSystemBackend.dto.SubCategoriesDto;
import com.project.OnlineAuctionSystemBackend.dto.UserDto;
import com.project.OnlineAuctionSystemBackend.entity.CategoriesTable;
import com.project.OnlineAuctionSystemBackend.entity.SubCategoriesTable;
import com.project.OnlineAuctionSystemBackend.service.MasterService;
import com.project.OnlineAuctionSystemBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/master")
@CrossOrigin
public class MasterController {

    @Autowired
    private MasterService masterService;

    @GetMapping("/categories")
    private List<CategoriesTable> getCategories() {
        return masterService.getCategories();
    }

    @GetMapping("/subCategories/{categoryId}")
    private List<SubCategoriesDto> getSubCategories(@PathVariable("categoryId") Integer categoryId) {
        return masterService.getSubCategories(categoryId);
    }

    @PostMapping("/saveNewItem")
    private String saveNewItem(@RequestBody ItemDto itemDto){
        return  masterService.saveNewItem(itemDto);
    }

    @GetMapping("/getAuctionItems")
    private List<ItemDto> getAuctionItems(){
        return  masterService.getAuctionItems();
    }

    @GetMapping("/auctionItem/{itemId}")
    private ItemDto getAuctionItem(@PathVariable("itemId") Integer itemId){
        return  masterService.getAuctionItem(itemId);
    }
}
