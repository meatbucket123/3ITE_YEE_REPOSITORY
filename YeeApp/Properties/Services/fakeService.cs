using Microsoft.AspNetCore.Mvc;
using YeeApp.Models;

namespace YeeApp.Properties.Services { 



    public class fakeService : IMyFakeService
    {
        public List<Instructor> InstructorList { get; }
    public fakeService()
    {
         InstructorList = new List<Instructor>
            {
                new Instructor()
                {
                    Id= 1,FirstName = "yes",LastName = "Montano", Rank = Rank.Professor, HiringDate = DateTime.Parse("2022-08-26"), IsTenured = true
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

    }
       
    }
}

