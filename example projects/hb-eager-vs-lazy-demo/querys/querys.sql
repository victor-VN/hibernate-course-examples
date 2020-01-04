SELECT * FROM instructor_detail;

SELECT * FROM instructor;

SELECT * FROM course;

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