START TRANSACTION;

ALTER TABLE awardmanagement.user AUTO_INCREMENT = 8;

INSERT INTO awardmanagement.user(id, username, dni, firstName, lastName, role, password)
SELECT id, username, dni, firstName, lastName, role, password
FROM (
	SELECT 7 id, 'poloagustin' username, '123456789' dni, 'Agustin' firstName, 'Polo' lastName, 2 role, 'thestral' password UNION ALL
	SELECT 1 id, 'botiukfranco' username, '123456789' dni, 'Franco' firstName, 'Botiuk' lastName, 2 role, 'password' password UNION ALL
	SELECT 2 id, 'majericfernando' username, '123456789' dni, 'Fernando' firstName, 'Majeric' lastName, 2 role, 'password' password UNION ALL
	SELECT 3 id, 'test01' username, '123456789' dni, 'Carla' firstName, 'Damiani' lastName, 0 role, 'test' password UNION ALL
	SELECT 4 id, 'test02' username, '123456789' dni, 'Matias' firstName, 'Perez' lastName, 1 role, 'test' password UNION ALL
	SELECT 5 id, 'test03' username, '123456789' dni, 'Juan' firstName, 'Garcia' lastName, 1 role, 'test' password UNION ALL
	SELECT 6 id, 'test04' username, '123456789' dni, 'Jorge' firstName, 'Marco' lastName, 1 role, 'test' password
) aux;

ALTER TABLE awardmanagement.product AUTO_INCREMENT = 6;

INSERT INTO awardmanagement.product(id, ammount, name, saleCommission)
SELECT id, ammount, name, saleCommission
FROM (
	SELECT 5 id, 100 ammount, 'Producto01' name, 150 saleCommission UNION ALL
	SELECT 1 id, 150 ammount, 'Producto02' name, 100 saleCommission UNION ALL
	SELECT 2 id, 200 ammount, 'Producto03' name, 50 saleCommission UNION ALL
	SELECT 3 id, 250 ammount, 'Producto04' name, 300 saleCommission UNION ALL
	SELECT 4 id, 300 ammount, 'Producto05' name, 450 saleCommission
) aux;

ALTER TABLE awardmanagement.salecommission AUTO_INCREMENT = 5;

INSERT INTO awardmanagement.salecommission(id, maximumSalesAmount, minimumSalesAmount, saleCommission)
SELECT id, maximumSalesAmount, minimumSalesAmount, saleCommission
FROM (
	SELECT 4 id, 5 maximumSalesAmount, 1 minimumSalesAmount, 200 saleCommission UNION ALL
	SELECT 1 id, 10 maximumSalesAmount, 6 minimumSalesAmount, 400 saleCommission UNION ALL
	SELECT 2 id, 15 maximumSalesAmount, 11 minimumSalesAmount, 700 saleCommission UNION ALL
	SELECT 3 id, null maximumSalesAmount, 16 minimumSalesAmount, 1000 saleCommission
) aux;

ALTER TABLE awardmanagement.sale AUTO_INCREMENT = 21;

INSERT INTO awardmanagement.sale(id, date, number, salesman_id)
SELECT id, date, number, salesman_id
FROM (
	SELECT	20	id, '2014/01/29' date, '0001' number, 	4	salesman_id UNION ALL
	SELECT	1   id, '2014/01/30' date, '0002' number, 	5	salesman_id UNION ALL
	SELECT	2	id, '2014/01/31' date, '0003' number, 	6	salesman_id UNION ALL
	SELECT	3	id, '2014/02/01' date, '0004' number, 	4	salesman_id UNION ALL
	SELECT	4	id, '2014/02/02' date, '0005' number, 	5	salesman_id UNION ALL
	SELECT	5	id, '2014/02/03' date, '0006' number, 	6	salesman_id UNION ALL
	SELECT	6	id, '2014/02/04' date, '0007' number, 	4	salesman_id UNION ALL
	SELECT	7	id, '2014/02/05' date, '0008' number, 	5	salesman_id UNION ALL
	SELECT	8	id, '2014/02/06' date, '0009' number, 	6	salesman_id UNION ALL
	SELECT	9	id, '2014/02/07' date, '0010' number, 	4	salesman_id UNION ALL
	SELECT	10	id, '2014/02/08' date, '0011' number, 	5	salesman_id UNION ALL
	SELECT	11	id, '2014/02/09' date, '0012' number, 	6	salesman_id UNION ALL
	SELECT	12	id, '2014/02/10' date, '0013' number, 	4	salesman_id UNION ALL
	SELECT	13	id, '2014/02/11' date, '0014' number, 	5	salesman_id UNION ALL
	SELECT	14	id, '2014/02/12' date, '0015' number, 	6	salesman_id UNION ALL
	SELECT	15	id, '2014/02/13' date, '0016' number, 	4	salesman_id UNION ALL
	SELECT	16	id, '2014/02/14' date, '0017' number, 	5	salesman_id UNION ALL
	SELECT	17	id, '2014/02/15' date, '0018' number, 	6	salesman_id UNION ALL
	SELECT	18	id, '2014/02/16' date, '0019' number, 	4	salesman_id UNION ALL
	SELECT	19	id, '2014/02/17' date, '0020' number, 	5	salesman_id 
) aux;

ALTER TABLE awardmanagement.saleitem AUTO_INCREMENT = 54;

INSERT INTO awardmanagement.saleitem(id, amount, product_id, sale_id)
SELECT id, amount, product_id, sale_id
FROM (
	SELECT 	53	id, 	1	 amount, 	5	 product_id, 	20	 sale_id UNION ALL
	SELECT 	1	id, 	2	 amount, 	1	 product_id, 	20	 sale_id UNION ALL
	SELECT 	2	id, 	3	 amount, 	2	 product_id, 	20	 sale_id UNION ALL
	SELECT 	3	id, 	4	 amount, 	3	 product_id, 	20	 sale_id UNION ALL
	SELECT 	4	id, 	5	 amount, 	4	 product_id, 	20	 sale_id UNION ALL
	SELECT 	5	id, 	6	 amount, 	5	 product_id, 	1	 sale_id UNION ALL
	SELECT 	6	id, 	7	 amount, 	1	 product_id, 	1	 sale_id UNION ALL
	SELECT 	7	id, 	1	 amount, 	2	 product_id, 	2	 sale_id UNION ALL
	SELECT 	8	id, 	2	 amount, 	3	 product_id, 	2	 sale_id UNION ALL
	SELECT 	9	id, 	3	 amount, 	4	 product_id, 	2	 sale_id UNION ALL
	SELECT 	10	id, 	4	 amount, 	5	 product_id, 	3	 sale_id UNION ALL
	SELECT 	11	id, 	5	 amount, 	1	 product_id, 	4	 sale_id UNION ALL
	SELECT 	12	id, 	6	 amount, 	2	 product_id, 	4	 sale_id UNION ALL
	SELECT 	13	id, 	7	 amount, 	3	 product_id, 	4	 sale_id UNION ALL
	SELECT 	14	id, 	1	 amount, 	4	 product_id, 	5	 sale_id UNION ALL
	SELECT 	15	id, 	2	 amount, 	5	 product_id, 	5	 sale_id UNION ALL
	SELECT 	16	id, 	3	 amount, 	1	 product_id, 	5	 sale_id UNION ALL
	SELECT 	17	id, 	4	 amount, 	2	 product_id, 	5	 sale_id UNION ALL
	SELECT 	18	id, 	5	 amount, 	3	 product_id, 	6	 sale_id UNION ALL
	SELECT 	19	id, 	6	 amount, 	4	 product_id, 	6	 sale_id UNION ALL
	SELECT 	20	id, 	7	 amount, 	5	 product_id, 	7	 sale_id UNION ALL
	SELECT 	21	id, 	1	 amount, 	1	 product_id, 	7	 sale_id UNION ALL
	SELECT 	22	id, 	2	 amount, 	2	 product_id, 	7	 sale_id UNION ALL
	SELECT 	23	id, 	3	 amount, 	3	 product_id, 	7	 sale_id UNION ALL
	SELECT 	24	id, 	4	 amount, 	4	 product_id, 	7	 sale_id UNION ALL
	SELECT 	25	id, 	5	 amount, 	5	 product_id, 	8	 sale_id UNION ALL
	SELECT 	26	id, 	6	 amount, 	1	 product_id, 	8	 sale_id UNION ALL
	SELECT 	27	id, 	7	 amount, 	2	 product_id, 	9	 sale_id UNION ALL
	SELECT 	28	id, 	1	 amount, 	3	 product_id, 	9	 sale_id UNION ALL
	SELECT 	29	id, 	2	 amount, 	4	 product_id, 	10	 sale_id UNION ALL
	SELECT 	30	id, 	3	 amount, 	5	 product_id, 	10	 sale_id UNION ALL
	SELECT 	31	id, 	4	 amount, 	1	 product_id, 	10	 sale_id UNION ALL
	SELECT 	32	id, 	5	 amount, 	2	 product_id, 	10	 sale_id UNION ALL
	SELECT 	33	id, 	6	 amount, 	3	 product_id, 	11	 sale_id UNION ALL
	SELECT 	34	id, 	7	 amount, 	4	 product_id, 	11	 sale_id UNION ALL
	SELECT 	35	id, 	1	 amount, 	5	 product_id, 	12	 sale_id UNION ALL
	SELECT 	36	id, 	2	 amount, 	1	 product_id, 	12	 sale_id UNION ALL
	SELECT 	37	id, 	3	 amount, 	2	 product_id, 	12	 sale_id UNION ALL
	SELECT 	38	id, 	4	 amount, 	3	 product_id, 	13	 sale_id UNION ALL
	SELECT 	39	id, 	5	 amount, 	4	 product_id, 	14	 sale_id UNION ALL
	SELECT 	40	id, 	6	 amount, 	5	 product_id, 	14	 sale_id UNION ALL
	SELECT 	41	id, 	7	 amount, 	1	 product_id, 	14	 sale_id UNION ALL
	SELECT 	42	id, 	1	 amount, 	2	 product_id, 	15	 sale_id UNION ALL
	SELECT 	43	id, 	2	 amount, 	3	 product_id, 	16	 sale_id UNION ALL
	SELECT 	44	id, 	3	 amount, 	4	 product_id, 	17	 sale_id UNION ALL
	SELECT 	45	id, 	4	 amount, 	5	 product_id, 	18	 sale_id UNION ALL
	SELECT 	46	id, 	5	 amount, 	1	 product_id, 	18	 sale_id UNION ALL
	SELECT 	47	id, 	6	 amount, 	2	 product_id, 	18	 sale_id UNION ALL
	SELECT 	48	id, 	7	 amount, 	3	 product_id, 	18	 sale_id UNION ALL
	SELECT 	49	id, 	1	 amount, 	4	 product_id, 	18	 sale_id UNION ALL
	SELECT 	50	id, 	2	 amount, 	5	 product_id, 	19	 sale_id UNION ALL
	SELECT 	51	id, 	3	 amount, 	1	 product_id, 	19	 sale_id UNION ALL
	SELECT 	52	id, 	4	 amount, 	2	 product_id, 	19	 sale_id 
) aux;

COMMIT;