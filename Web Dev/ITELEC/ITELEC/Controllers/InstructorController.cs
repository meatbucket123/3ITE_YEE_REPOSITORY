using Microsoft.AspNetCore.Mvc;
using ITELEC.Models;


namespace ITELEC.Controllers
{
    public class InstructorController : Controller
    {
        List<Instructor> InstructorList = new List<Instructor>
            {
                new Instructor()
                {
                    Id= 1,FirstName = "Juan Delacr",LastName = "Montano", Rank = Rank.Professor, HiringDate = DateTime.Parse("2022-08-26"), IsTenured = true
                },
                new Instructor()
                {
                    Id= 2,FirstName = "Pogi Nation",LastName = "Montano", Rank = Rank.AssistantProfessor, HiringDate = DateTime.Parse("2020-08-26"), IsTenured = false
                },
                new Instructor()
                {
                    Id= 3,FirstName = "Mark Jearard",LastName = "Montano", Rank = Rank.AssistantProfessor, HiringDate = DateTime.Parse("2021-08-26"), IsTenured = true
                }
            };
        public IActionResult Index()
        {

            return View(InstructorList);
        }

        public IActionResult ShowDetail(int id)
        {
            //Search for the student whose id matches the given id
            Instructor? instructor = InstructorList.FirstOrDefault(st => st.Id == id);

            if (instructor != null)//was an student found?
                return View(instructor);

            return NotFound();
        }

    }
}
