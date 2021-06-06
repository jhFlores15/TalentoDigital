insert into producto (nombre,codigo,descripcion,precio,cantidad) values ('mostaza',15236,'',800,500);
select * from producto where codigo = 15236;
update producto set nombre = 'Mostaza' where id_producto = 7;
delete from producto where id_producto = 7;
