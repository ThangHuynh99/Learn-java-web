use newservlet10month2020; 

INSERT INTO role(name, code) values("Quản Trị Hệ Thống","ADMIN");
INSERT INTO role(name, code) values("Người Dùng","USER");

insert into user(username, password, fullname, status, roleid) values("thang", "172304", "Huỳnh Bá Thắng", 1, 1);
insert into user(username, password, fullname, status, roleid) values("thuy", "172304", "Phạm Thị Minh Thủy", 1, 2);
insert into user(username, password, fullname, status, roleid) values("rickie", "172304", "Rickie", 1, 2);
insert into user(username, password, fullname, status, roleid) values("nick", "172304", "Nick", 1, 2);