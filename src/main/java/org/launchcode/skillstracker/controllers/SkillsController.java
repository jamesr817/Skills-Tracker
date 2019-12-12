package org.launchcode.skillstracker.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "skills-tracker")
public class SkillsController {

    String skillsList = "<h1> Skills Tracker</h1>" +
            "<h2>Here are some skills to learn</h2>" +
            "<ol>" +
            "<li>Python</li>" +
            "<li>C++</li>" +
            "<li>C#</li>" +
            "<li>JavaScript</li>" +
            "<li>Java</li>" +
            "</ol>";

    String languageOptions = "<option value =\"C++\">C++</option>\n" +
                             "<option value =\"C#\">C#</option>\n" +
                             "<option value =\"Java\">Java</option>\n" +
                             "<option value =\"JavaScript\">JavaScript</option>\n" +
                             "<option value =\"Python\">Python</option>\n";

    String skills_form = "<html>" +
                          "<body>" +
                          "<form method = 'post' action = 'formSubmit'>" +

                          "<h3>Name:</h3>" +
                          "<input type = 'text' name = 'name'>" +

                          "<h3>My Favorite Language</h3>" +
                          "<select name = 'firstChoice'>\n" +
                          languageOptions +
                          "</select>" +

                          "<h3>My SecondFavorite Language</h3>" +
                          "<select name = 'secondChoice'>\n" +
                          languageOptions +
                          "</select>" +

                          "<h3>My Third Favorite Language</h3>" +
                          "<select name = 'thirdChoice'>\n" +
                          languageOptions +
                          "</select><br>" +

                          "<input type = 'submit' value = 'Submit'>" +
                          "</form>" +
                          "</body>" +
                          "</html>" ;

    @GetMapping
    public String listSkills() {
        return skillsList;
    }

    @GetMapping("form")
    public String skillsForm() {

        return skills_form;
    }

    @RequestMapping(value ="formSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String giveResponse(@RequestParam(defaultValue = "Coder") String name,
                               @RequestParam(defaultValue = "Java") String firstChoice,
                               @RequestParam(defaultValue = "JavaScript")String secondChoice,
                               @RequestParam(defaultValue = "Python")String thirdChoice){
        return "<h1>" + name + "</h1>" +
                "<h2>Your Favorite Languages</h2>" +
                "<h3><ol>" +
                "<li>" + firstChoice + "</li>" +
                "<li>" + secondChoice + "</li>" +
                "<li>" + thirdChoice + "</li>" +
                "</h3></ol>";
    }
}
