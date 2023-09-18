using Microsoft.AspNetCore.Mvc;
using YeeApp.Models;


namespace YeeApp.Controllers
{
    public class studentController : Controller
    {
        List<Student> StudentList = new List<Student>
            {
                new Student()
                {
                    Id= 1,FirstName = "Juan Delacr",LastName = "Montano", Course = Course.IT, AdmissionDate = DateTime.Parse("2022-08-26"), studentStatus = studentStatus.Permanent
                },
                new Student()
                {
                    Id= 2,FirstName = "Pogi Nation",LastName = "Montano", Course = Course.IT, AdmissionDate = DateTime.Parse("2020-08-26"), studentStatus = studentStatus.Irregular
                },
        
                
            };
        public IActionResult Index()
        {

            return View(StudentList);
        }

        public IActionResult ShowDetail(int id)
        {
            //Search for the student whose id matches the given id
            Student? student = StudentList.FirstOrDefault(st => st.Id == id);

            if (student != null)//was an student found?
                return View(student);

            return NotFound();
        }
        [HttpGet]
        public IActionResult EditDetails(int id)
        {
            //Search for the student whose id matches the given id
            Student? student = StudentList.FirstOrDefault(st => st.Id == id);

            if (student != null)
                return View(student);

            return NotFound();

        }

        [HttpPost]
        public IActionResult EditDetails(Student studentChange)
        {
            Student? student = StudentList.FirstOrDefault(st => st.Id == studentChange.Id);

            if (student != null)
            {
                student.Id = studentChange.Id;
                student.FirstName = studentChange.FirstName;
                student.LastName = studentChange.LastName;
                student.Course = studentChange.Course;
                student.studentStatus = studentChange.studentStatus;
                student.AdmissionDate = studentChange.AdmissionDate;

            }
            return View("Index", StudentList);
        }
        [HttpGet]
        public IActionResult AddStudent()
        {
            return View();
        }
        [HttpPost]
        public IActionResult AddStudent(Student newStudent)
        {
            StudentList.Add(newStudent);
            return View("Index", StudentList);
        }

    }
}
