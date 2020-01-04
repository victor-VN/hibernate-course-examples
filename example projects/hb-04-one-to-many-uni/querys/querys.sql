SELECT * FROM instructor_detail;

SELECT * FROM instructor;

SELECT * FROM course;

SELECT * FROM student;

SELECT * FROM course_student;

/*this join gets all information when the FK matchs with the PK in 
another table.
*/

SELECT * FROM 
instructor AS i
JOIN instructor_detail AS d ON i.id = d.id;

SELECT * FROM 
instructor AS i
JOIN instructor_detail AS d ON i.id = d.id;

SELECT * FROM 
course AS c
JOIN instructor AS i ON c.instructor_id = i.id;

SELECT * FROM 
review as r
JOIN course as c ON r.course_id = c.id where c.id = 10;

SELECT * FROM 
review as r
JOIN course as c ON r.course_id = c.id;
