using System;
using System.ComponentModel.DataAnnotations;

namespace ITELEC.Models
{
    public enum Status
    {
        Probationary, Permanent
    }

    public class Instructor
    {
        [Display(Name = "First name")]
        public string? FirstName { get; set; }
        [Required(ErrorMessage ="last name is required")]
        [Display(Name = "Last name")]
        public string? LastName { get; set; }
        [Display(Name = "Hiring date" )]
        [DataType (DataType.Date)]
        public DateTime Birthday { get; set; }
        [Display(Name = "Is tenured")]
        public bool IsTenured { get; set; }
      
        [EmailAddress]
        [Display(Name = "Email address")]
        public string? Email { get; set; }

        [Required]
        public int Id { get; set; }
    }
}

