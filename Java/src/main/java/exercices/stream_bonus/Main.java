package exercices.stream_bonus;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
	public static void main(String[] args)
	{
		Teacher teacher1 = new Teacher("John Doe", "Mathematics", 2010);
		Teacher teacher2 = new Teacher("Jane Smith", "Physics", 2015);
		Teacher teacher3 = new Teacher("Michael Johnson", "Chemistry", 2005);
		Teacher teacher4 = new Teacher("Michel Papin", "Informatique", 2003);

		List<Teacher> teacherList = Arrays.asList(teacher1, teacher2, teacher3, teacher4);

		Course course1 = new Course(1, "Calculus", teacher1, 15);
		Course course2 = new Course(2, "Mechanics", teacher2, 10);
		Course course3 = new Course(3, "Organic Chemistry", teacher3, 12);
		Course course4 = new Course(4, "Java", teacher4, 12);

		List<Course> courseList = Arrays.asList(course1, course2, course3, course4);

		Student student1 = new Student("Alice", 18);
		Student student2 = new Student("Bob", 20);
		Student student3 = new Student("Charlie", 19);
		Student student4 = new Student("David", 21);
		Student student5 = new Student("Eve", 22);

		List<Student> studentList = Arrays.asList(student1, student2, student3, student4, student5);

		student1.addCourse(course1);
		student1.addCourse(course2);

		student2.addCourse(course3);
		student2.addCourse(course1);

		student3.addCourse(course4);
		student3.addCourse(course3);
		student3.addCourse(course1);

		student4.addCourse(course3);
		student4.addCourse(course1);
		student4.addCourse(course2);
		student4.addCourse(course4);

		student5.addCourse(course1);
		student5.addCourse(course3);
		student5.addCourse(course2);

		//1 - Sélectionner les Student qui ont un âge supérieur à 20 ans ?
		studentList.stream()
				.filter(student -> student.getAge() > 20)
				.forEach(System.out::println);

		//2 - Transformer les Teacher en une liste de leurs noms ?
		teacherList.stream()
				.map(Teacher::getName)
				.toList()
				.forEach(System.out::println);

		//3 - Transformer les Teacher en une liste de leurs matières enseignées ?
		teacherList.stream()
				.map(Teacher::getDepartment)
				.toList()
				.forEach(System.out::println);

		//4 – Donnez-moi la liste des teachers en passant par les courses ?
		courseList.stream()
				.map(Course::getTeacher)
				.toList()
				.forEach(System.out::println);

		//5 - Calculer la somme de toutes les durées des cours ?
		System.out.println(courseList.stream()
				.mapToInt(Course::getDuration)
				.sum());


		//6 - Sélectionner les cours avec une durée supérieure à 11 heures, puis récupérer une liste de
		//leurs noms triée par ordre alphabétique ?
		courseList.stream()
				.filter(course -> course.getDuration() > 11)
				.map(Course::getName)
				.toList()
				.forEach(System.out::println);

		//7 - Regrouper les Student par âge, puis afficher le nombre d'étudiants dans chaque groupe ?
		studentList.stream()
				.collect(Collectors.groupingBy(Student::getAge))
				.forEach((age, list) -> System.out.println("Age" + age + " Student count: " + list.size()));


		//8 – En passant par Student, il faut récupérer une liste de Course et il faut garder les
		//doublons.
		studentList.stream()
				.map(Student::getCourses)
				.forEach(System.out::println);

		//9 - Regrouper les Teacher par année d'entrée en fonction, puis afficher le nombre
		//d'enseignants dans chaque groupe ? (vous pouvez utiliser une collection comme map pour
		//récupérer le résultat).
		teacherList.stream()
				.collect(Collectors.groupingBy(Teacher::getStartDate))
				.forEach((startDate, list) -> System.out.println("Start date:" + startDate + " Teacher count: " + list.size()));


		//10 - Sélectionner les Student avec un âge compris entre 18 et 20 ans, puis récupérer une liste
		//de leurs Course triée par ordre alphabétique ?
		studentList.stream()
				.filter(student -> student.getAge() <= 20 && student.getAge() >= 18)
				.flatMap(student -> student.getCourses().stream())
				.distinct()
				.sorted(Comparator.comparing(Course::getName))
				.forEach(System.out::println);


		//11 - Compter le nombre d'étudiants dans chaque cours, puis récupérer une Map associant
		//chaque Course à son nombre d'étudiants ?


		//12 - Quel est le nombre moyen de cours suivis par les étudiants de plus de 20 ans


		//13 - Quels sont les noms des étudiants qui ont suivi tous les cours ?
		System.out.println(studentList.stream()
				.filter(student -> student.getCourses().containsAll(courseList))
				.map(Student::getName)
				.toList());
	}
}
