INSERT INTO awardmanagement.user(username, dni, firstName, lastName, role, password)
SELECT username, dni, firstName, lastName, role, password
FROM (
	SELECT 'poloagustin' username, '123456789' dni, 'Agustin' firstName, 'Polo' lastName, 2 role, 'thestral' password UNION ALL
	SELECT 'botiukfranco' username, '123456789' dni, 'Franco' firstName, 'Botiuk' lastName, 2 role, 'password' password UNION ALL
	SELECT 'majericfernando' username, '123456789' dni, 'Fernando' firstName, 'Majeric' lastName, 2 role, 'password' password UNION ALL
	SELECT 'test01' username, '123456789' dni, 'Test' firstName, 'Test' lastName, 0 role, 'test' password
) aux;
