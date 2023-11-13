using Microsoft.AspNetCore.Mvc;
using ITELEC.Models;
using ITELEC.Services;
using ITELEC.Data;
using System.Linq;

namespace ITELEC.Controllers
{
    public class InstructorController : Controller
    {
        private readonly AppDbContext _dbContext;

        public InstructorController(AppDbContext dbContext)
        {
            _dbContext = dbContext;
        }
        public IActionResult Index()
        {

            return View(_dbContext.Instructors);
        }

        public IActionResult ShowDetail(int id)
        {
            //Search for the student whose id matches the given id
            Instructor? instructor = _dbContext.Instructors.FirstOrDefault(st => st.Id == id);

            if (instructor != null)//was an student found?
                return View(instructor);

            return NotFound();
        }
        [HttpGet]

        public IActionResult AddInstructor()
        {
            return View();
        }

        [HttpPost]

        public IActionResult AddInstructor(Instructor newInstructor)
        {
            if (!ModelState.IsValid)
                return View();

            _dbContext.Instructors.Add(newInstructor);
            return RedirectToAction("Index");
            _dbContext.Instructors.Add(newInstructor);
            _dbContext.SaveChanges();          
            return RedirectToAction("Index");
        }

        [HttpGet]
        public IActionResult EditDetail(int id)
        {
            //Search for the student whose id matches the given id
            Instructor? instructor = _dbContext.Instructors.FirstOrDefault(st => st.Id == id);

            if (instructor != null)//was an student found?
                return View(instructor);

            return NotFound();

        }

        [HttpPost]
        public IActionResult EditDetail(Instructor instructorChange)
        {
            Instructor? instructor = _dbContext.Instructors.FirstOrDefault(st => st.Id == instructorChange.Id);

            if (instructor != null)
            {
                instructor.Id = instructorChange.Id;
                instructor.FirstName = instructorChange.FirstName;
                instructor.LastName = instructorChange.LastName;
                instructor.Email = instructorChange.Email;
             
                instructor.Birthday = instructorChange.Birthday;
           
            }
            _dbContext.SaveChanges();
            return RedirectToAction("Index");
        }

    }
}