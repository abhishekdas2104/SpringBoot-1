package com.abhishek.demo.Portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPortfolio {

    @GetMapping("/mySelf")
    public String Myself() {
        return """
            <h1>Myself</h1>
            <p> Dedicated and Passionate about leaning new technologies everyday </p>
            <ul>
            <li>gitHub Link : https://github.com/abhishekdas2104</li>
            <li>Leetcode Link : https://leetcode.com/u/abhishekdas21/
                                             </li>
            </ul>
            """;
    }

    @GetMapping("/education")
    public String getEducation() {
        return """
                <h2>Education</h2>
                <ul>
                    <li><b>BTech Computer Science and Engineering</b></li>
                    <li>Semester: 7th</li>
                    <li>Background: Non-Technical (Successfully transitioned into Software Development)</li>
                </ul>
                """;
    }

    @GetMapping("/skills")
    public String getSkills() {
        return """
                <h2>Technical Skills</h2>
                <ul>
                    <li>Java</li>
                    <li>Spring Core</li>
                    <li>Spring Boot</li>
                    <li>Spring MVC</li>
                    <li>Spring Data JPA</li>
                    <li>Hibernate</li>
                    <li>REST API Development</li>
                    <li>MySQL</li>
                    <li>H2 Database</li>
                    <li>Maven</li>
                    <li>Git & GitHub</li>
                    <li>HTML</li>
                    <li>CSS</li>
                    <li>JavaScript</li>
                    <li>React</li>
                </ul>
                """;
    }

    @GetMapping("/projectname")
    public String getProjects() {
        return """
                <h2>Projects</h2>
                <ol>
                    <li><b>Hospital Management System</b> - Build using MERN stack, REST API</li>
                    <li><b>Artisan Bakery Website</b> - Node.js, Express.js, MongoDB, and EJS.</li>
                    <li><b>Examination Management System</b> - Spring Boot + Spring Data JPA + H2/MySQL.</li>
                </ol>
                """;
    }

    @GetMapping("/contact")
    public String getContact() {
        return """
                <h2>Contact</h2>
                <ul>
                    <li>Name: Abhishek Das</li>
                    <li>Role: Full stack web developer</li>
                    <li>GitHub: https://github.com/abhishekdas2104</li>
                    <li>LinkedIn: https://www.linkedin.com/in/abhishek-das-cse/</li>
                    <li>Email: abhishekdas2104@gmail.com</li>
                </ul>
                """;
    }

}