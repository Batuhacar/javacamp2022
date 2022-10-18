import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;

import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import core.logging.DatabaseLogger;
import core.logging.EmailLogger;
import core.logging.FileLogger;
import dataAccess.hibernate.HibernateCategoryDao;
import dataAccess.hibernate.HibernateInstructorDao;
import dataAccess.jdbc.JdbcCourseDao;
import entities.Category;
import entities.Course;
import entities.Instructor;

public class Main {

	public static void main(String[] args) throws Exception {
			Logger[] loggers = { new DatabaseLogger(), new FileLogger(), new EmailLogger() };

			Category category = new Category(1, "Programming");

			List<Category> categoryDb = new ArrayList<>();

			CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(), loggers, categoryDb);
			categoryManager.add(category);

			System.out.println("-----");

			Course course1 = new Course(1, "Yazılım Geliştirici Yetiştirme Kampı (C# + ANGULAR)", 100);
			Course course2 = new Course(2, "Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)\r\n"
					+ "", 100);
			Course course3 = new Course(3, "Yazılım Geliştirici Yetiştirme Kampı (JavaScript)", 100);
			Course course4 = new Course(4, "Senior Yazılım Geliştirici Yetiştirme Kampı (.NET)", 100);
			Course course5 = new Course(5, "(2022) Yazılım Geliştirici Yetiştirme Kampı - JAVA\r\n"
					+ "", 200);

			List<Course> courseDb = new ArrayList<>();

			CourseManager courseManager = new CourseManager(new JdbcCourseDao(), loggers, courseDb);
			courseManager.add(course1);
			courseManager.add(course2);
			courseManager.add(course3);
			courseManager.add(course4);
			courseManager.add(course5);

			System.out.println("-----");

			Instructor instructor = new Instructor(1, "Engin", "Demirog");
			InstructorManager instructorManager = new InstructorManager(new HibernateInstructorDao(), loggers);
			instructorManager.add(instructor);

	}
	
}
