namespace YeeApp.Models
{
    public enum Course
    {
IT,IS, CS
    }

    public enum studentStatus
    {
Permanent, Irregular
    }

    public class Student
    {

        public int Id { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public studentStatus studentStatus { get; set; }
        public Course Course { get; set; }
        public DateTime AdmissionDate { get; set; }


    }
}
