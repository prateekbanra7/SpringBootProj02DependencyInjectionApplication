package in.abc.target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import in.abc.dependent.ICourseMaterial;

@Component(value = "student")
public class Student {

	static {
		System.out.println("Student.class file is loading...");
	}

	public Student() {
		System.out.println("Student object is instantiated...");
	}

	@Autowired
//	@Qualifier(@Value("${course.choose}"))error
	@Qualifier("courseId")
	private ICourseMaterial material;

	public void preparation(String examName) {
		System.out.println("Preparation started for :: " + examName);
		String courseContent = material.courseContent();
		double price = material.price();
		System.out.println("Preparation is going on using :: " + courseContent + "material with price ::" + price);
		System.out.println("Preparation completed for ::" + examName);
	}

	public ICourseMaterial getMaterial() {
		return material;
	}

	public void setMaterial(ICourseMaterial material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Student [material=" + material + "]";
	}

}
