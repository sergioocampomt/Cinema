package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.entity.Category;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int categoryId){
        return categoryRepository.getCategory(categoryId);
    }
    
    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> e =categoryRepository.getCategory(category.getId());
            if(e.isPresent()){
                return category;
            }else{
                return categoryRepository.save(category);
            }
        }
    }
    
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> q =categoryRepository.getCategory(category.getId());
            if(q.isPresent()){
                if(category.getDescription()!=null){
                    q.get().setDescription(category.getDescription());
                }            
                if(category.getName()!=null){
                    q.get().setName(category.getName());
                }
                return categoryRepository.save(q.get());
            }
        }
        return category;
    }
    
    public boolean deleteCategory(int id){
        Boolean d = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
}
    
