insert into cliente (id, nombres, apellidos, dni, telefono ,email) values (1,'Juan','Perez','78986545','056346587','jperez@gmail.com');
insert into producto(id, nombre, precio) values (1,'Mouse', 15.00);
insert into producto(id, nombre, precio) values (2,'Teclado', 35.50);
insert into venta(id, id_cliente, fecha) values (1,1,'2023-02-01');
insert into detalle_venta(id, id_venta, id_producto, cantidad) values (1, 1,1,1);
insert into detalle_venta(id, id_venta, id_producto, cantidad) values (2, 1,2,2);
