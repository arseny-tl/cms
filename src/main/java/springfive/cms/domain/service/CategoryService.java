package springfive.cms.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfive.cms.domain.models.Category;
import springfive.cms.domain.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Category update(Category category) {
    return this.categoryRepository.save(category);
  }

  public Category create(Category category) {
    return this.categoryRepository.save(category);
  }

  public void delete(String id) {
    final Category category = this.categoryRepository.findOne(id);
    this.categoryRepository.delete(category);
  }

  public Category findOne(String id) {
    return this.categoryRepository.findOne(id);
  }

  public List<Category> findAll() {
    return this.categoryRepository.findAll();
  }
}
