package com.project.OnlineAuctionSystemBackend.service;

import com.project.OnlineAuctionSystemBackend.dto.ItemDto;
import com.project.OnlineAuctionSystemBackend.dto.SubCategoriesDto;
import com.project.OnlineAuctionSystemBackend.entity.CategoriesTable;
import com.project.OnlineAuctionSystemBackend.entity.ItemsTable;
import com.project.OnlineAuctionSystemBackend.entity.SubCategoriesTable;
import com.project.OnlineAuctionSystemBackend.repository.CategoriesTableRepository;
import com.project.OnlineAuctionSystemBackend.repository.ItemsTableRepository;
import com.project.OnlineAuctionSystemBackend.repository.SubCategoriesTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MasterService {

    @Autowired
    private CategoriesTableRepository categoriesTableRepository;

    @Autowired
    private SubCategoriesTableRepository subCategoriesTableRepository;

    @Autowired
    private ItemsTableRepository itemsTableRepository;

    public List<CategoriesTable> getCategories() {
        List<CategoriesTable> categoriesList = categoriesTableRepository.findAll();
        return categoriesList;
    }

    public List<SubCategoriesDto> getSubCategories(Integer categoryId) {
        List<SubCategoriesDto> subCategoriesDtoList = new ArrayList<>();
        List<SubCategoriesTable> subCategoriesTableList = subCategoriesTableRepository.findByCategory_CategoryId(categoryId);
        subCategoriesTableList.forEach(subCategoriesTable -> {
            SubCategoriesDto subCategoriesDto= new SubCategoriesDto();
            subCategoriesDto.setSubCategoryId(subCategoriesTable.getSubCategoryId());
            subCategoriesDto.setSubCategoryName(subCategoriesTable.getSubCategoryName());
            subCategoriesDtoList.add(subCategoriesDto);
        });
        return subCategoriesDtoList;
    }

    public String saveNewItem(ItemDto itemDto)  {
        ItemsTable itemsTable= new ItemsTable();
        itemsTable.setTitle(itemDto.getTitle());
        itemsTable.setDescription(itemDto.getDescription());

        Optional<CategoriesTable> category = categoriesTableRepository.findById(itemDto.getCategoryId());
        Optional<SubCategoriesTable> subCategory = subCategoriesTableRepository.findById(itemDto.getSubCategoryId());
        if(category.isPresent() && subCategory.isPresent()) {
            itemsTable.setCategory(category.get());
            itemsTable.setSubCategory(subCategory.get());
        }
        itemsTable.setStartBid(itemDto.getStartBid());
        ItemsTable itemsTable1= itemsTableRepository.save(itemsTable);

        return "true";
    }

    public List<ItemDto> getAuctionItems() {
        List<ItemsTable> itemsTableList = itemsTableRepository.findAll();
        List<ItemDto> itemDtoList= new ArrayList<>();
        itemsTableList.forEach(itemsTable -> {
            ItemDto itemDto = new ItemDto();
            itemDto.setItemId(itemsTable.getItemId());
            itemDto.setTitle(itemsTable.getTitle());
            itemDto.setDescription(itemsTable.getDescription());
            itemDto.setStartBid(itemsTable.getStartBid());
            itemDtoList.add(itemDto);
        });
        return itemDtoList;
    }

    public ItemDto getAuctionItem(Integer itemId) {
        Optional<ItemsTable> itemsTable = itemsTableRepository.findById(itemId);
        ItemDto itemDto = new ItemDto();
        if(itemsTable.isPresent()){
            itemDto.setItemId(itemsTable.get().getItemId());
            itemDto.setTitle(itemsTable.get().getTitle());
            itemDto.setDescription(itemsTable.get().getDescription());
            itemDto.setStartBid(itemsTable.get().getStartBid());
            itemDto.setCategoryName(itemsTable.get().getCategory().getCategoryName());
            itemDto.setSubCategoryName(itemsTable.get().getSubCategory().getSubCategoryName());
        }
        return itemDto;
    }
}
