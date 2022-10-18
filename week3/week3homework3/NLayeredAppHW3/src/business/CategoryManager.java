package business;

import java.lang.System.Logger;
import java.util.List;

import dataAccess.CategoryDao;
import dataAccess.hibernate.HibernateCategoryDao;
import entities.Category;

public class CategoryManager {
	private CategoryDao categoryDao;
	private Logger[] loggers;
	private List<Category> categories;
	
	public CategoryManager(CategoryDao categoryDao, Logger[] loggers, List<Category> categories) {
		super();
		this.categoryDao = categoryDao;
		this.loggers = loggers;
		this.categories = categories;
	}

	 public CategoryManager(HibernateCategoryDao hibernateCategoryDao, List<Logger> loggers2) {
		
	}

	public void add(Category category) throws Exception {


	        for (Category categry : categories) {
	            if (categry.getCategoryName().equals(category.getCategoryName())) {
	                throw new Exception("Kategori adı diğerleriyle aynı olamaz !");

	            }

	        }
	        categoryDao.add(category);
	        categories.add(category);
	        for (Logger logger : loggers) {
	            logger.log(null, category.getCategoryName());
	        }
	    }
}
