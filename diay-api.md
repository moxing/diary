## User

endpoint: /user

- POST /user 
新建用户
request { name:string, password:string, email:string }

- PUT /user/{id}/leader/{leaderId} 
指派组长

- GET /user/{id} 
查看用户信息

- GET /user/name/{name} 
查看用户信息 根据用户名

- GET /user/noleader 
查看无组长用户

- DELETE /user/{id}/leader/{leaderId} 
删除用户 如果id为组长 leaderId为新组长
