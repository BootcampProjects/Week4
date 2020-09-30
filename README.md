# Playlist Project REST API Documentation
Source : https://playlistprojectrestapidocumentation.docs.apiary.io

Playlist Project API is a REST service which enables access and basic operations
with data described below.

HOST: https://<span></span>polls.apiblueprint.org/api/v1/

## Playlists Collection [/playlists]

### Create Playlist [POST /]

+ Request (application/json)

        {
            "name" : "Playlist A",
            "description" : "Desc Playlist A",
            "userId" : "1a96bd32-f96a-4e2a-aa7a-ebce6e233ac3"
              
        }
        
+ Response 201 (application/json)

    + Headers

            Location: /playlists/2a56bd72-f94a-4e2a-aa7a-ebce7e237ad2
            
+ Response 404 (application/json)

        {
            "errors": [
                {
                    "description": "Resource Not Found",
                    "message": "Document with the given id not found",
                    "date": "2020-09-29T20:08:10.612+00:00"
                }
            ]
        }
        
+ Response 500 (application/json)

        {
            "errors": [
                {
                    "description": "Internal Server Error",
                    "message": "Unable to connect to the remote server",
                    "date": "2020-09-29T20:08:10.612+00:00"
                }
            ]
        }
        
### Find By Id [GET /{id}]

+ Parameters
    + id (required, String, `2a56bd72-f94a-4e2a-aa7a-ebce7e237ad2`) ... `id` of playlist - 

+ Response 200 (application/json)

        {
            "data:" : {
                "id": "2a56bd72-f94a-4e2a-aa7a-ebce7e237ad2",
                "name": "Playlist A",
                "description": "Desc Playlist A",
                "followersCount":  1,
                "tracks": [
                    {
                        "name": "Track X",
                        "length": "3.41",
                        "artist": "Artist I"
                    },
                    {
                        "name": "Track Y",
                        "length": "3.18",
                        "artist": "Artist J"
                    }
                ],
                "trackCount": 2,
                "userId" : "1a96bd32-f96a-4e2a-aa7a-ebce6e233ac3"
            }
        }
        
+ Response 404 (application/json)

        {
            "errors": [
                {
                    "description": "Resource Not Found",
                    "message": "Document with the given id not found",
                    "date": "2020-09-29T20:08:10.612+00:00"
                }
            ]
        }
        
+ Response 500 (application/json)

        {
            "errors": [
                {
                    "description": "Internal Server Error",
                    "message": "Unable to connect to the remote server",
                    "date": "2020-09-29T20:08:10.612+00:00"
                }
            ]
        }
        
### Find All By User Id [GET /u/{userId}{?offset,limit}]

+ Parameters
    + userId (required, String, `1a96bd32-f96a-4e2a-aa7a-ebce6e233ac3`) ... `id` of user - 
    + offset (int, optional, `5`) ... Page offset for result -
    + limit (int, optional, `3`) ... Page size for result -
+ Response 200 (application/json)

        {
            "pagination": {
                "offset": 5,
                "limit": 3,
                "total": 22,
            },
            "data:" : [
                {
                    "id": "2a56bd72-f94a-4e2a-aa7a-ebce7e237ad2",
                    "name": "Playlist A",
                    "description": "Desc Playlist A",
                    "followersCount":  1,
                    "tracks": [
                        {
                            "name": "Track X",
                            "length": "3.41",
                            "artist": "Artist I"
                        },
                        {
                            "name": "Track Y",
                            "length": "3.18",
                            "artist": "Artist J"
                        }
                    ],
                    "trackCount": 2,
                    "userId" : "1a96bd32-f96a-4e2a-aa7a-ebce6e233ac3",
                },
                {
                    "id": "2a56bd72-f94a-4e2a-aa7a-ebce7e237ad3",
                    "name": "Playlist B",
                    "description": "Desc Playlist B",
                    "followersCount":  1,
                    "tracks": [
                        {
                            "name": "Track X",
                            "length": "3.41",
                            "artist": "Artist I"
                        },
                        {
                            "name": "Track Y",
                            "length": "3.18",
                            "artist": "Artist J"
                        }
                    ],
                    "trackCount": 2,
                    "userId" : "1a96bd32-f96a-4e2a-aa7a-ebce6e233ac3",
                },
                {
                    "id": "2a56bd72-f94a-4e2a-aa7a-ebce7e237ad4",
                    "name": "Playlist C",
                    "description": "Desc Playlist C",
                    "followersCount":  1,
                    "tracks": [
                        {
                            "name": "Track X",
                            "length": "3.41",
                            "artist": "Artist I"
                        },
                        {
                            "name": "Track Y",
                            "length": "3.18",
                            "artist": "Artist J"
                        }
                    ],
                    "trackCount": 2,
                    "userId" : "1a96bd32-f96a-4e2a-aa7a-ebce6e233ac3",
                }
            ]
        }
        
+ Response 500 (application/json)

        {
            "errors": [
                {
                    "description": "Internal Server Error",
                    "message": "Unable to connect to the remote server",
                    "date": "2020-09-29T20:08:10.612+00:00"
                }
            ]
        }
        
### Delete Playlist [DELETE /{id}]

+ Parameters
    + id (required, String, `2a56bd72-f94a-4e2a-aa7a-ebce7e237ad4`) ... `id` of playlist - 
    
+ Response 204 (application/json)

+ Response 404 (application/json)

        {
            "errors": [
                {
                    "description": "Resource Not Found",
                    "message": "Document with the given id not found",
                    "date": "2020-09-29T20:08:10.612+00:00"
                }
            ]
        }
        
+ Response 500 (application/json)

        {
            "errors": [
                {
                    "description": "Internal Server Error",
                    "message": "Unable to connect to the remote server",
                    "date": "2020-09-29T20:08:10.612+00:00"
                }
            ]
        }
        
### Add Track To Playlist [PATCH /{id}/t]

+ Parameters
    + id (required, String, `2a56bd72-f94a-4e2a-aa7a-ebce7e237ad2`) ... `id` of playlist - 
    
+ Request (application/json)

        {
              "id": "4t578bd72-f94a-872a-aa7a-ei8ce7e6f3ue1",
              "name": "Track Z",
              "length": "2.46",
              "artist": "Artist K"
        }
        
+ Response 204 (application/json)

+ Response 404 (application/json)

        {
            "errors": [
                {
                    "description": "Resource Not Found",
                    "message": "Document with the given id not found",
                    "date": "2020-09-29T20:08:10.612+00:00"
                }
            ]
        }
        
+ Response 500 (application/json)

        {
            "errors": [
                {
                    "description": "Internal Server Error",
                    "message": "Unable to connect to the remote server",
                    "date": "2020-09-29T20:08:10.612+00:00"
                }
            ]
        }
        
### Remove Track To Playlist [PATCH /{id}/t/{trackId}]

+ Parameters
    + id (required, String, `2a56bd72-f94a-4e2a-aa7a-ebce7e237ad2`) ... `id` of playlist - 
    + trackId (required, String, `4t578bd72-f94a-872a-aa7a-ei8ce7e6f3ue1`) ... `id` of track - 
        
+ Response 204 (application/json)

+ Response 404 (application/json)

        {
            "errors": [
                {
                    "description": "Resource Not Found",
                    "message": "Document with the given id not found",
                    "date": "2020-09-29T20:08:10.612+00:00"
                }
            ]
        }
        
+ Response 500 (application/json)

        {
            "errors": [
                {
                    "description": "Internal Server Error",
                    "message": "Unable to connect to the remote server",
                    "date": "2020-09-29T20:08:10.612+00:00"
                }
            ]
        }