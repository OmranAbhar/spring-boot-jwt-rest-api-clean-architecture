
```
INSERT INTO 
	public.user_tbl(email, password, user_name)
	VALUES ( 'admin@admin.com', 'Gcwt8YVTqjqWKeRFGxQqnnv+pylE7C2WwSx9NXMhDsJzTf0aVo2PsiXN+Ujd3lFO', 'Admin');
  ```
  
```
POST:  http://localhost:9100/api/auth/signin
BODY:  {
        "password": "123321",
        "email": "admin@admin.com"
        }
```
