CONTINUOUS INTEGRATION AND CONTINUOUS DELIVERY USING DevOps (Skill Oriented Course)
===================================================================================
Get an understanding of the stages in software development lifecycle, the process models, values and principles of agility and the need for agile software development. This will enable you to work in projects following an agile approach to software development.
Essential Points in Software Development Lifecycle (SDLC)
==========================================================
1.	Planning: Define objectives, scope, resources, and timeline.
2.	Requirements Analysis: Gather and document stakeholder requirements.
3.	Design: Create system architecture and design specifications.
4.	Implementation: Code the software following standards.
5.	Testing: Validate software through various testing methods.
6.	Deployment: Release and monitor the software in the live environment.
7.	Maintenance: Provide ongoing support and updates.
8.	===================================================
Key Process Models
------------------
1.	Waterfall: Linear, sequential approach.
2.	Iterative: Develop in repeated cycles, allowing for feedback.
3.	Agile: Iterative, incremental development with a focus on flexibility and customer collaboration.
4.	=================================================================================================
Core Values of Agility
-----------------------
1.	Individuals and Interactions over processes and tools.
2.	Working Software over comprehensive documentation.
3.	Customer Collaboration over contract negotiation.
4.	Responding to Change over following a plan.
5.	====================================================
Need for Agile Development
==========================
1.	Flexibility: Adapt to changes throughout the project.
2.	Customer Satisfaction: Continuous delivery meets user needs.
3.	Quality Improvement: Regular testing and feedback loops.
4.	Team Morale: Empowered teams with higher productivity.
5.	=====================================================
Agile Practices
===============
1.	Daily Standups: Short meetings to discuss progress and obstacles.
2.	Sprint Planning: Plan work for the next iteration.
3.	Retrospectives: Reflect on and improve the last iteration.
4.	Continuous Integration/Continuous Deployment (CI/CD): Automate testing and deployment.

Applying SDLC and Agile Principles to a Spring Boot Example
==========================================================
SDLC Stages
1.	Planning:
o	Objective: Develop a RESTful web service for product management.
o	Scope: CRUD operations for the product entity.
o	Resources: Team, Spring Boot, H2 database.
-----------------------------------------------
o	Timeline: 2 weeks.
3.	Requirements Analysis:
--------------------------
o	Gather and document CRUD functionality and REST endpoints.
4.	Design:
-----------
o	Architecture: Spring Boot backend, H2 database.
o	Models: Product entity.
o	Endpoints: Define GET, POST, PUT, DELETE for /api/products.
5.	Implementation:
------------------
o	Set up project, develop Product, ProductRepository,  and ProductController.
o	Implement CRUD operations and conduct code reviews.
6.	Testing:
--------------
o	Perform unit and integration tests.
o	Test APIs using tools like Postman.
7.	Deployment:
---------------
o	Deploy to a local or cloud environment.
o	Prepare deployment scripts and monitor the application.
8.	Maintenance:
----------------
o	Bug fixes, new features, regular updates.
Agile Principles
----------------
Core Values in Action:
1.	Individuals and Interactions:
o	Daily standups, continuous collaboration.
2.	Working Software:
o	Regular delivery of working increments.
3.	Customer Collaboration:
o	Regular feedback and requirement adjustments.
4.	Responding to Change:
o	Adapt to changes and flexible planning.
---------------------------------------
Key Agile Practices:
===================
1.	Daily Standups:
o	Discuss progress and blockers.
2.	Sprint Planning:
o	Plan iterations, define user stories and tasks.
3.	Retrospectives:
o	Reflect on and improve the last iteration.
4.	CI/CD:
o	Automate testing and deployment.
5.	Backlog Grooming:
o	Prioritize and update the product backlog.
Need for Agile Development:
---------------------------
1.	Flexibility: Adapt to late changes.
2.	Customer Satisfaction: Engage and satisfy customers with regular releases.
3.	Quality Improvement: Catch and fix issues early.
4.	Team Morale: Foster collaboration and productivity.
Example Agile Workflow
-----------------------
1.	Sprint Planning:
o	Define user stories and break down into tasks.
2.	Daily Standups:
o	Discuss progress and blockers.
3.	Sprint Review:
o	Demonstrate and gather feedback on working software.
4.	Retrospective:
o	Discuss improvements.
By integrating SDLC stages with Agile principles, you can effectively manage and deliver a Spring Boot project that meets user requirements and adapts to changes efficiently.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Required  softwares :spring tool suite(sts), postman , jdk 17, apache maven etc.




Open the sts tool 
File->new->spring starter project ->
Name: citizenvaccinationservice
Type: Maven                       packaging: Jar
Java version :17                   Language: Java
Group: com.citizen
Artifact: citizenvaccinationservice
Version : 0.0.1-SNAPSHOT
Description: storethevaccinationdetails
Package : com.citizen
Click on Next 
Add the following dependencies
1)Spring Web  2)Spring Boot DevTools  3)Spring Data Jpa  4)H2 Database
Click on finish

This is main method
--------------------
package com.citizen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevopsLabExperiment1Application {

	public static void main(String[] args) {
		SpringApplication.run(DevopsLabExperiment1Application.class, args);
	}

}


This is model class
-------------------
package com.citizen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Citizen {
	
	@Id
	private String citizenId;
	private String citizenName;
	private String vaccineName;
	private String vaccineCenterId;
	private String vaccineCenterAddress;
	
	
	public Citizen() {
		super();
	}


	public Citizen(String citizenId, String citizenName, String vaccineName, String vaccineCenterId,
			String vaccineCenterAddress) {
		super();
		this.citizenId = citizenId;
		this.citizenName = citizenName;
		this.vaccineName = vaccineName;
		this.vaccineCenterId = vaccineCenterId;
		this.vaccineCenterAddress = vaccineCenterAddress;
	}


	public String getCitizenId() {
		return citizenId;
	}


	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}


	public String getCitizenName() {
		return citizenName;
	}


	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}


	public String getVaccineName() {
		return vaccineName;
	}


	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}


	public String getVaccineCenterId() {
		return vaccineCenterId;
	}


	public void setVaccineCenterId(String vaccineCenterId) {
		this.vaccineCenterId = vaccineCenterId;
	}


	public String getVaccineCenterAddress() {
		return vaccineCenterAddress;
	}


	public void setVaccineCenterAddress(String vaccineCenterAddress) {
		this.vaccineCenterAddress = vaccineCenterAddress;
	}


	@Override
	public String toString() {
		return "Citizen [citizenId=" + citizenId + ", citizenName=" + citizenName + ", vaccineName=" + vaccineName
				+ ", vaccineCenterId=" + vaccineCenterId + ", vaccineCenterAddress=" + vaccineCenterAddress + "]";
	}
	
	

}

----------------------------------------------------------------------------------------------------

This is repository
==================
package com.citizen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citizen.model.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, String>{

}


this is controller
-------------------

package com.citizen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizen.model.Citizen;
import com.citizen.repository.CitizenRepo;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	
	
	@Autowired
	private CitizenRepo repo;
	
	
	@PostMapping("/add")
	public Citizen add(@RequestBody Citizen model) {
		
		Citizen save = repo.save(model);
		
		return save;
	}
	
	@GetMapping("/list")
    public List<Citizen> getAllCitizens() {
        return repo.findAll();
    }
	
	@DeleteMapping("/delete/{id}")
    public void deleteCitizen(@PathVariable String id) {
        repo.deleteById(id);
    }

}

This is application.properties file
====================================
spring.application.name=devops_lab_experiment-1

server.port:7865


spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.sql.init.platform=h2


spring.h2.console.enabled=true
spring.h2.console.path=/h2-console


spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

this is pom.xml file
======================
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.3.2</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.citizen</groupId>
	<artifactId>collegeregistration</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>devops_lab_experiment-1</name>
	<description>springcloud</description>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
Open the main method 
->right click
->run as
->spring boot application
If everything is properly enter server is running in few seconds

After that open postman

Give the following url

http://localhost:7865/citizen/add

body->raw->json

{
    "citizenId":"abbas786",
    "citizenName":"abbas",
    "vaccineName":"covaxin",
    "vaccineCenterId":"1001",
    "vaccineCenterAddress":"1o-downing street,uk"
}

{
    "citizenId":"zaheer123",
    "citizenName":"zaheer",
    "vaccineName":"covaxin",
    "vaccineCenterId":"1001",
    "vaccineCenterAddress":"1o-downing street,uk"
}

If everything will be fine data successfully stored in h2 database.
You get status code 200 ok which means standard response for successful HTTP requests.

Open browser

Serach the following url

Localhost:7865/h2-console

Give the jdbc url: jdbc:h2:mem:testdb

Username:sa

Password:password

Click on connect

Enter SELECT * FROM CITIZEN CITIZEN ;

It will display the data.

If you want to see all users who are registerd for vaccine
http://localhost:7865/citizen/list
[
    {
        "citizenId": "abbas123",
        "citizenName": "abbas",
        "vaccineName": "covaxin",
        "vaccineCenterId": "1001",
        "vaccineCenterAddress": "10-downing street,uk"
    },
    {
        "citizenId": "rafi123",
        "citizenName": "rafi",
        "vaccineName": "covaxin",
        "vaccineCenterId": "1001",
        "vaccineCenterAddress": "narasaraopet"
    },
    {
        "citizenId": "umar123",
        "citizenName": "umar",
        "vaccineName": "covaxin",
        "vaccineCenterId": "1001",
        "vaccineCenterAddress": "guntur"
    }


If you want to delete the user based on id 
http://localhost:7865/citizen/delete/ abbas123
it will delete the entire record.






