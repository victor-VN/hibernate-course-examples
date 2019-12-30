SELECT * FROM instructor_detail;

SELECT * FROM instructor;

/*this join gets all information when the FK matchs with the PK in 
another table.
*/

SELECT * FROM 
instructor AS i
JOIN instructor_detail AS d ON i.id = d.id;

SELECT * FROM 
instructor AS i
JOIN instructor_detail AS d ON i.id = d.id;