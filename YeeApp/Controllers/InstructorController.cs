using Microsoft.AspNetCore.Mvc;
using YeeApp.Models;
using YeeApp.Properties.Services;

namespace YeeApp.Controllers
{
    public class InstructorController : Controller
    {
        private readonly IMyFakeService _fakeService;
        private List<Instructor> InstructorList;

    public InstructorController(IMyFakeService fakeService)
        {
            _fakeService = fakeService;
            InstructorList = _fakeService.InstructorList;
        }
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
        [HttpGet]
        public IActionResult deleteDetail(int id)
        {
            Instructor? instructor = InstructorList.FirstOrDefault(st => st.Id == id);
              if (instructor != null)
                return View(instructor);

            return NotFound();
        }

        [HttpPost]
        public IActionResult deleteDetail(Instructor instructorDelete)
        {
            Instructor? instructor = InstructorList.FirstOrDefault(st => st.Id == instructorDelete.Id);

            if (instructor != null)
            {
                InstructorList.Remove(instructor);

            }
            return View("Index", InstructorList);
        }

        [HttpGet]
        public IActionResult EditDetails(int id)
        {
            //Search for the student whose id matches the given id
            Instructor? instructor = InstructorList.FirstOrDefault(st => st.Id == id);

            if (instructor != null)
                return View(instructor);

            return NotFound();

        }

        [HttpPost]
        public IActionResult EditDetails(Instructor instructorChange)
        {
            Instructor? instructor = InstructorList.FirstOrDefault(st => st.Id == instructorChange.Id);

            if (instructor != null)
            {
                instructor.Id = instructorChange.Id;
                instructor.FirstName = instructorChange.FirstName;
                instructor.LastName = instructorChange.LastName;
                instructor.Rank = instructorChange.Rank;
                instructor.HiringDate = instructorChange.HiringDate;
                
            }
            return View("Index", InstructorList);
        }
        [HttpGet]public IActionResult AddInstructor()
        {
            return View();
        }
		[HttpPost]public IActionResult AddInstructor(Instructor newInstructor)
		{
			InstructorList.Add(newInstructor);
			return View("Index", InstructorList);
		}

	}
}
