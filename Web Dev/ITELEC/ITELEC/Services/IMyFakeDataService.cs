using ITELEC.Models;
using System.Collections.Generic;

namespace ITELEC.Services;


public interface IMyFakeDataService
{
    List<Student> StudentList { get; }
    List<Instructor> InstructorList { get; }
}