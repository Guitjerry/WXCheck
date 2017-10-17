INSERT INTO schooltask.tm_role (code, name) VALUES ('admin', '系统管理员(老师)');

INSERT INTO schooltask.tm_resource (DEPTH, PARENT_ID, LINK, ICON, IFCHECKED, NAME) VALUES (1, null, '', 'glyphicon glyphicon-glass', null, '权限管理');
INSERT INTO schooltask.tm_resource (DEPTH, PARENT_ID, LINK, ICON, IFCHECKED, NAME) VALUES (null, null, '', 'glyphicon glyphicon-envelope', null, '基本信息管理');
INSERT INTO schooltask.tm_resource (DEPTH, PARENT_ID, LINK, ICON, IFCHECKED, NAME) VALUES (2, 8, '/student/studentList?msg=student', 'glyphicon glyphicon-user', null, '学生管理');
INSERT INTO schooltask.tm_resource (DEPTH, PARENT_ID, LINK, ICON, IFCHECKED, NAME) VALUES (2, 8, '/kemu/kemuList?msg=kemu', 'glyphicon glyphicon-home', null, '科目管理');
INSERT INTO schooltask.tm_resource (DEPTH, PARENT_ID, LINK, ICON, IFCHECKED, NAME) VALUES (2, 8, '/banji/banjiList?msg=banji', 'glyphicon glyphicon-ok', null, '班级管理');
INSERT INTO schooltask.tm_resource (DEPTH, PARENT_ID, LINK, ICON, IFCHECKED, NAME) VALUES (1, null, '', 'glyphicon glyphicon-plus', null, '作业管理');
INSERT INTO schooltask.tm_resource (DEPTH, PARENT_ID, LINK, ICON, IFCHECKED, NAME) VALUES (2, 6, '/resource/resourceList?msg=resource', 'glyphicon glyphicon-music', null, '资源管理');
INSERT INTO schooltask.tm_resource (DEPTH, PARENT_ID, LINK, ICON, IFCHECKED, NAME) VALUES (2, 6, '/role/roleList?msg=role', 'glyphicon glyphicon-star-empty', null, '角色管理');
INSERT INTO schooltask.tm_resource (DEPTH, PARENT_ID, LINK, ICON, IFCHECKED, NAME) VALUES (2, 6, '/user/userList?msg=user', 'glyphicon glyphicon-user', null, '用户管理');
INSERT INTO schooltask.tm_resource (DEPTH, PARENT_ID, LINK, ICON, IFCHECKED, NAME) VALUES (2, 13, '/zuoye/zuoyeList?msg=index', 'glyphicon glyphicon-cloud', null, '布置作业');

INSERT INTO schooltask.tm_user (ACCOUNT, NAME, EMAIL, PHONE, PASSWORD, status) VALUES ('check', '检查员', '111@11.com', '18768786542', '202cb962ac59075b964b07152d234b70', 0);


INSERT INTO schooltask.tm_role_resource (ROLE_ID, RESOURCE_ID) VALUES (1, 10);
INSERT INTO schooltask.tm_role_resource (ROLE_ID, RESOURCE_ID) VALUES (1, 11);
INSERT INTO schooltask.tm_role_resource (ROLE_ID, RESOURCE_ID) VALUES (1, 12);
INSERT INTO schooltask.tm_role_resource (ROLE_ID, RESOURCE_ID) VALUES (1, 14);
INSERT INTO schooltask.tm_role_resource (ROLE_ID, RESOURCE_ID) VALUES (1, 15);
INSERT INTO schooltask.tm_role_resource (ROLE_ID, RESOURCE_ID) VALUES (1, 16);
INSERT INTO schooltask.tm_role_resource (ROLE_ID, RESOURCE_ID) VALUES (1, 17);