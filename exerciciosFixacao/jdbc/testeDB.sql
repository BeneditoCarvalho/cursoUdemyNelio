select seller.*, department.Name as DepName 
FROM seller 
INNER JOIN department 
ON seller.DepartmentId = department.Id
where seller.id = '1';
