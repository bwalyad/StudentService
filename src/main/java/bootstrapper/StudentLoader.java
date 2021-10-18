package bootstrapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Student;
import com.example.demo.model.StudentStatus;
import com.example.demo.repositories.StudentRepository;

@Component 
public class StudentLoader implements CommandLineRunner{
	public final StudentRepository studentRepository ;
	
	public StudentLoader (StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

@Override
public void run(String args[]) throws Exception {
	loadStudents();
}


private void loadStudents() {
	if(studentRepository.count()==0) {
		studentRepository.save(
				Student.builder()
				.first_name("Jane")
				.last_name("Doe")
				.studentStatus(StudentStatus.NOT_COMPLETED)
				.build()
				);
		studentRepository.save(
				Student.builder()
				.first_name("Mary")
				.last_name("Jane")
				.studentStatus(StudentStatus.NOT_COMPLETED)
				.build()
				);
		System.out.println("Sample Student Records Created");
	}
	
}
}
