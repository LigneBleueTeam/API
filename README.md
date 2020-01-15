# API | http://lignebleue.sytes.net:8080/api

## USER

GET >> /api/user/{id} : Get a user by id<br/>
GET >> /api/user/all: Get all users<br/>
POST >> /api/user/save : Create a new user<br/>
	### EXAMPLE :<br/>
		{
        "firstName": "Anass",
        "lastName": "Tboguissa",
        "email": "anass@tboguissa.mb",
        "password": "AZE124-*/",
        "typeUser": "Adult",
		"height":172.8,
		"weight":78.40,
		"phoneNumber":"0755060213",
        "roles": [
            {
                "id": 1,
                "role": "USER"
            }
        ]
		}
		
	### RESPONSE :
		#### SUCCESS --------------
		{
		"timestamp": "2019-12-26T14:13:15.727+0000",
		"success": true,
		"message": "Utilisateur crée avec succès."
		}
		
		#### FAIL --------------
		{
		"timestamp": "2019-12-26T14:13:52.799+0000",
		"success": false,
		"message": "Paramètre manquant ou invalide.",
		"path": "uri=/api/user/save",
		"details": "Paramètre manquant ou invalide."
		}
		
PUT >> /api/user/{id} : Update a user info with desired params<br/>
	### EXAMPLE :<br/>
		{
        "password": "&é'(--è-*/"
		}
	
	### RESPONSE :
		#### SUCCESS --------------
		{
		"timestamp": "2019-12-26T14:15:13.849+0000",
		"success": true,
		"message": "Utilisateur modifié avec succès."
		}
		
## ACTIVITY

GET >> /api/activity/{id} : Get an activity by id<br/>
GET >> /api/activity/all: Get all activities<br/>
POST >> /api/activity/save : Create a new activity<br/>
	### EXAMPLE :<br/>
		{
		"level":1,
		"location":"Zone 1",
		"name":"Push ups",
		"time":"20",
		"type":"Type 4"
		}
		
	### RESPONSE :
		#### SUCCESS --------------
		{
		"timestamp": "2019-12-26T14:16:10.991+0000",
		"success": true,
		"message": "Activité créée avec succès."
		}
		
		#### FAIL --------------
		{
		"timestamp": "2019-12-26T14:17:00.341+0000",
		"success": false,
		"message": "Paramètre manquant ou invalide.",
		"path": "uri=/api/activity/save",
		"details": "Paramètre manquant ou invalide."
		}
		
PUT >> /api/activity/{id} : Update an activity<br/>
	### EXAMPLE :<br/>
		{
        "level": "2",
		"time":"70"
		}
		
	### RESPONSE :
		#### SUCCESS --------------
		{
		"timestamp": "2019-12-26T14:08:37.251+0000",
		"success": true,
		"message": "Activité modifiée avec succès."
		}

## PROGRAM

GET >> /api/program/{id} : Get a program by id<br/>
GET >> /api/program/all: Get all programs<br/>
POST >> /api/program/save : Create a new program<br/>
	### EXAMPLE :<br/>
		{
		"level":2,
		"name":"Programme 1",
		"objective":2
		}
		
	### RESPONSE :
		#### SUCCESS --------------
		{
		"timestamp": "2019-12-26T14:21:30.980+0000",
		"success": true,
		"message": "Programme crée avec succès."
		}
		
		#### FAIL --------------
		{
		"timestamp": "2019-12-26T14:21:56.824+0000",
		"success": false,
		"message": "Paramètre manquant ou invalide.",
		"path": "uri=/api/program/save",
		"details": "Paramètre manquant ou invalide."
		}
		
PUT >> /api/program/{id} : Update a program<br/>
	### EXAMPLE :<br/>
		{
        "level": 3
		}
		
	### RESPONSE :
		#### SUCCESS --------------
		{
		"timestamp": "2019-12-26T14:22:44.969+0000",
		"success": true,
		"message": "Programme modifié avec succès."
		}
