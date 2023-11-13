using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.ModelBinding;
using System;
using System.ComponentModel.DataAnnotations;
using System.Threading.Tasks;
using ITELEC.Controllers;

namespace ITELEC.Models
{
    public class LoginViewModel
    {
        [Display(Name = "User name")]
        [Required(ErrorMessage = "a username is required")]
        public string UserName { get; set; }

        [DataType(DataType.Password)]
        [Required(ErrorMessage = "a password is required")]
        public string Password { get; set; }

        [Display(Name = "Remember me?")]
        public bool RememberMe { get; set; }




    }

}
