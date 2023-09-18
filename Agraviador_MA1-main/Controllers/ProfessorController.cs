using Microsoft.AspNetCore.Mvc;
using Agraviador_MA1.Models;

namespace Agraviador_ITELEC1C.Controllers
{
    public class ProfessorController : Controller
    {
        List<Professor> ProfessorList = new List<Professor>
            {
                new Professor()
                {
                    FirstName = "Maria",LastName = "Edang", Birthday = DateTime.Parse("1992-01-04"), IsTenured = true, SalaryPerHour = 1200, Id = 1, PrelimGrade = 95, FinalGrade = 90
                },
                new Professor()
                {
                    FirstName = "Jobert",LastName = "Magtamo",  Birthday = DateTime.Parse("1994-08-26"), IsTenured = false, SalaryPerHour = 750, Id = 2, PrelimGrade = 89, FinalGrade = 94
                },
                new Professor()
                {
                    FirstName = "Sinturon",LastName = "Dela Cruz", Birthday = DateTime.Parse("1997-04-16"), IsTenured = false, SalaryPerHour = 750, Id = 3, PrelimGrade = 97, FinalGrade = 87
                }
            };
        public IActionResult Index()
        {

            return View(ProfessorList);
        }

        public IActionResult ShowDetail(int id)
        {
            //Search for the student whose id matches the given id
            Professor? professor = ProfessorList.FirstOrDefault(st => st.Id == id);

            if (professor != null)//was an student found?
                return View(professor);

            return NotFound();
        }
       
    }
}