# Playlist Project REST API Documentation
Source : https://playlistprojectrestapidocumentation.docs.apiary.io

Playlist Project API is a REST service which enables access and basic operations
with data described below.

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
                    "error_type": "ResourceNotFound",
                    "error_description": "Object Not Found"
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
                    "error_type": "ResourceNotFound",
                    "error_description": "Object Not Found"
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
        
+ Response 404 (application/json)

        {
            "errors": [
                {
                    "error_type": "ResourceNotFound",
                    "error_description": "Object Not Found"
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
                    "error_type": "ResourceNotFound",
                    "error_description": "Object Not Found"
                }
            ]
        }
        
### Add Track To Playlist [PATCH /{id}]

+ Parameters
    + id (required, String, `2a56bd72-f94a-4e2a-aa7a-ebce7e237ad2`) ... `id` of playlist - 
    
+ Request (application/json)

        {
              "name": "Track Z",
              "length": "2.46",
              "artist": "Artist K"
        }
        
+ Response 204 (application/json)

+ Response 404 (application/json)

        {
            "errors": [
                {
                    "error_type": "ResourceNotFound",
                    "error_description": "Object Not Found"
                }
            ]
        }
        
### Remove Track To Playlist [PATCH /r/{id}]

+ Parameters
    + id (required, String, `2a56bd72-f94a-4e2a-aa7a-ebce7e237ad2`) ... `id` of playlist - 
    
+ Request (application/json)

        {
              "name": "Track Z",
              "length": "2.46",
              "artist": "Artist K"
        }
        
+ Response 204 (application/json)

+ Response 404 (application/json)

        {
            "errors": [
                {
                    "error_type": "ResourceNotFound",
                    "error_description": "Object Not Found"
                }
            ]
        }
