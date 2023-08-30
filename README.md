# Spring-Boot-AbsencesManagement
# STD22064 - Josia ANDRIAMAHERILALA

## **Vous pouvez le tester l'OpenAPI sur Swagger UI en cliquant [ICI](https://petstore.swagger.io/?url=https://raw.githubusercontent.com/josiaJj/Spring-Boot-AbsencesManagement/main/openAPI-AbsencesManagement.yaml).**

### Exemples d'Endpoints :

## STUDENTS : 

> ### Liste de tous les étudiants avec le nombre total d'absences de l'étudiant
>> GET : [http://localhost:8080/students/ListOfAllStudents]

> ### Récupérer les étudiants selon un nombre d'absences minimun
>> GET : [http://localhost:8080/students/ListOfStudents?minAbsences=1]

> ### Ajouter un nouveau étudiant
>> POST : [http://localhost:8080/students/add]

    Headers : 
        Key : 
            Content-type
        Value : 
            application/json

    Body : 
        {
            "std": "STD22087",
            "firstname": "Kiala",
            "lastname": "Soa",
            "email": "hei.soa@gmail.com",
            "idGroup": 5
        }

> ### Changer le groupe de l'étudiant
>> PUT : 
[http://localhost:8080/students/STD22087/update-group?newGroup=H2]

> ### Effacer un étudiant par son Id
>> DELETE :
[http://localhost:8080/students/delete/STD22087]


## GROUPS : 

> ### Liste de tous les groupes avec le total d'absences de chaque groupe
>> GET : 
    [http://localhost:8080/groups/ListOfAllGroups]

> ### Liste des groupes avec le nombre d'absences d'une telle date
>> GET :
    [http://localhost:8080/groups/ListOfGroupsFromDate?date=2023-08-01]

> ### Ajouter un nouveau groupe
>> POST : 
    [http://localhost:8080/groups/add]

    Headers : 
        Key : 
            Content-type, 
            Value : application/json

    Body : 
        {
            "codeGroup": "I1"
        }

> ### Modifier le code d'un groupe
>> PUT : 
    [http://localhost:8080/2/update-code?newCode=G4]

> ### Supprimer un groupe par son code
>> DELETE :
    [http://localhost:8080/groups/delete/H4]


## SUBJECTS : 
> ### Liste de toutes les matières avec sa nombre d'absences
>> GET : 
    [http://localhost:8080/subjects/ListOfSubjects]

> ### La matière qui a eu le plus d'étudiants absents
>> GET :
    [http://localhost:8080/subjects/SubjectByMaxAbsentsStudents]

> ### Ajouter une matière 
>> POST : 
    [http://localhost:8080/subjects/add] 
    
    Headers : 
        Key : 
            Content-type, 
            Value : application/json

    Body : 
        {
            "idSubject": "PROG2",
            "name": "Langage Java et POO" 
        }

> ### Mettre à jour le nom de la matière en fonction de son ID ("WEB1", "PROG1", ...)
>> PUT :
    [http://localhost:8080/subjects/WEB1/update-name?newName=Nouveau%20Developpement%20WEB]

> ### Supprimer une matière par son Id
>> DELETE:
    [http://localhost:8080/subjects/delete/THEORIE1]

## COURSES : 

> ### Liste de tous les cours avec le nombres d'étudiants absents
>> GET : 
    [http://localhost:8080/courses/ListOfAllCourses]

> ### Le cours qui a eu le plus d'étudiats absents
>> GET :
    [http://localhost:8080/courses/CourseByMaxAbsentStudents]

> ### Insérer un cours en fournissant ses colonnes
>>POST : 
    [http://localhost:8080/courses/add]

    Headers : 
        Key : 
            Content-type, 
            Value : application/json

    Body : 
        {
            "idCourse": 11,
            "dateCourse": "2023-09-02",
            "idSubject": "THEORIE1"
        }

> ### Modifier la date d'un cours en fonction de l'ID du cours
>> PUT :
    [http://localhost:8080/courses/8/update-date?newDate=2023-09-02]

> ### Supprimer un cours par son ID 
>> DELETE : 
    [http://localhost:8080/courses/delete/10]

