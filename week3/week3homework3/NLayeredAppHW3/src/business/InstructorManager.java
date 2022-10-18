package business;

import java.lang.System.Logger;
import dataAccess.InstructorDao;
import entities.Instructor;

public class InstructorManager {
	private InstructorDao instructorDao;
	private Logger[] loggers;

	public InstructorManager(InstructorDao instructorDao, Logger[] loggers2) {
		this.instructorDao = instructorDao;
		this.loggers = loggers2;

	}

	public void add(Instructor instructor) {
		instructorDao.add(instructor);
		for (Logger logger : loggers) {
			logger.log(null, instructor.getId()+instructor.getName()+instructor.getSurname() + "\n");
			}
	}
	

}
