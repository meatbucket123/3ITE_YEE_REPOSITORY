using System;
using System.Threading.Tasks;
using ITELEC.Data;
using ITELEC.Models;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.ModelBinding;
using Microsoft.EntityFrameworkCore.Metadata.Internal;

namespace ITELEC.Controllers
{
    public class AccountController : Controller
    {


        private readonly SignInManager<User> _signInManager;
        private readonly UserManager<User> _userManager;

        public AccountController(SignInManager<User> signInManager, UserManager<User> userManager)
        {
            _signInManager = signInManager;
            _userManager = userManager;
        }
        public IActionResult login()
        {
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> Login(LoginViewModel loginInfo)
        {
            var result = await _signInManager.PasswordSignInAsync(loginInfo.UserName, loginInfo.Password, loginInfo.RememberMe, false);

            if (result.Succeeded)
            {
                return RedirectToAction("Index", "Instructor");

            }
            else
            {
                ModelState.AddModelError("", "Failed to login");

            }
            return View(loginInfo);
        }
        public async Task<IActionResult> Logout()
        {
            await _signInManager.SignOutAsync();
            return RedirectToAction("Index", "Instructor");
        }

        [HttpPost]
        public async Task<IActionResult> Register(RegisterViewModel userEnteredData)
        {
            if (!ModelState.IsValid)
            {
                User newUser = new User();
                newUser.UserName = userEnteredData.UserName;
                newUser.Firstname = userEnteredData.FirstName;
                newUser.Lastname = userEnteredData.LastName;
                newUser.Email = userEnteredData.Email;

                var result = await _userManager.CreateAsync(newUser, userEnteredData.Password);

                if (result.Succeeded)
                {
                    return RedirectToAction("Index", "Instructor");

                }
                else
                {
                    foreach (var error in result.Errors)
                    {
                        ModelState.AddModelError("", error.Description);

                    }
                }
            }
            return View(userEnteredData);
        }
    }



   
}

