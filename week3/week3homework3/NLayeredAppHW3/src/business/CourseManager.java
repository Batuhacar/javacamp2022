package business;

import java.lang.System.Logger;
import java.util.List;

import dataAccess.CourseDao;
import dataAccess.hibernate.HibernateCourseDao;
import entities.Course;

public class CourseManager {
	private CourseDao courseDao;
	private Logger[] loggers;
	private List <Course> courses;
	
	public CourseManager(CourseDao courseDao,Logger[] loggers, List<Course> courses) {
		this.courseDao = courseDao;
		this.loggers = loggers;
		this.courses = courses;
	}


	public CourseManager(HibernateCourseDao hibernateCourseDao, List<Logger> loggers2) {
		// TODO Auto-generated constructor stub
	}


	public void add(Course course) throws Exception {
		if (course.getUnitPrice() < 0) {
			throw new Exception("Kurs fiyatı 0'dan küçük olamaz");

		}
		for(Course cours : courses) {
			if(cours.getCourseName().equals(course.getCourseName())) {
				throw new Exception("Kurs adı diğerleriyle aynı olamaz");
			}
		}

		courseDao.add(course);
		courses.add(course);
		for(Logger logger : loggers) {
			logger.log(null, course.getCourseName());
			
		}
	}
}