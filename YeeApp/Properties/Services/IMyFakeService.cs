using System;
using YeeApp.Models;
using YeeApp.Properties.Services;

namespace YeeApp.Properties.Services
{
    public interface IMyFakeService
    {
     
        List<Instructor> InstructorList{ get; }
    }
}
