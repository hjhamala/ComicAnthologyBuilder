import json
import requests

stories = [{
    "comic" : "2000 AD",
    "issue" : "PROG 1740",
    "releaseDate" : "2011-06-28",
    "stories" : [ 
        {
            "series" : "Judge Dredd",
            "story" : "The Further Dasterdly Deeds of P.J.Maybe",
            "part" : 1,
            "startingPage" : 3,
            "endingPage" : 8
        }, 
        {
            "series" : "Sinister Dexter",
            "arc" : "Apocalypse Shtick",
            "story" : "Charon's Crossing",
            "part" : 1,
            "startingPage" : 10,
            "endingPage" : 14
        }, 
        {
            "series" : "Savage",
            "arc" : "Book 7",
            "story" : "Secret City ",
            "part" : 1,
            "startingPage" : 15,
            "endingPage" : 20
        }, 
        {
            "series" : "Tharg's 3rillers present",
            "story" : "The Silver Tongued Exploits of Cosmo Nibs",
            "part" : 1,
            "startingPage" : 21,
            "endingPage" : 25
        }, 
        {
            "series" : "Zombo",
            "story" : "The Day the Zombo Died",
            "part" : 1,
            "startingPage" : 26,
            "endingPage" : 30
        }
    ]
},{    
    "comic" : "2000 AD",
    "issue" : "PROG 1741",
    "release_date" : "2011-07-06",
    "stories" : [ 
        {
            "series" : "Judge Dredd",
            "story" : "The Further Dasterdly Deeds of P.J.Maybe",
            "part" : 2,
            "startingPage" : 3,
            "endingPage" : 8
        }, 
        {
            "series" : "Sinister Dexter",
            "arc" : "Apocalypse Shtick",
            "story" : "Charon's Crossing",
            "part" : 2,
            "startingPage" : 10,
            "endingPage" : 14
        }, 
        {
            "series" : "Savage",
            "arc" : "Book 7",
            "story" : "Secret City ",
            "part" : 2,
            "startingPage" : 15,
            "endingPage" : 20
        }, 
        {
            "series" : "Tharg's 3rillers present",
            "story" : "The Silver Tongued Exploits of Cosmo Nibs",
            "part" : 2,
            "startingPage" : 21,
            "endingPage" : 25
        }, 
        {
            "series" : "Zombo",
            "story" : "The Day the Zombo Died",
            "part" : 2,
            "startingPage" : 26,
            "endingPage" : 30
        }
    ]
},
{
    
    "comic" : "2000 AD",
    "issue" : "PROG 1742",
    "release_date" : "2011-07-13",
    "stories" : [ 
        {
            "series" : "Judge Dredd",
            "story" : "The Further Dasterdly Deeds of P.J.Maybe",
            "part" : 3,
            "startingPage" : 3,
            "endingPage" : 8
        }, 
        {
            "series" : "Sinister Dexter",
            "arc" : "Apocalypse Shtick",
            "story" : "Charon's Crossing",
            "part" : 3,
            "startingPage" : 10,
            "endingPage" : 14
        }, 
        {
            "series" : "Savage",
            "arc" : "Book 7",
            "story" : "Secret City ",
            "part" : 3,
            "startingPage" : 15,
            "endingPage" : 20
        }, 
        {
            "series" : "Tharg's 3rillers present",
            "story" : "The Silver Tongued Exploits of Cosmo Nibs",
            "part" : 3,
            "startingPage" : 21,
            "endingPage" : 25
        }, 
        {
            "series" : "Zombo",
            "story" : "The Day the Zombo Died",
            "part" : 3,
            "startingPage" : 26,
            "endingPage" : 30
        }
    ]
},
{
    "comic" : "2000 AD",
    "issue" : "PROG 1743",
    "release_date" : "2011-07-20",
    "stories" : [ 
        {
            "series" : "Judge Dredd",
            "arc" : "Day of Chaos",
            "story" : "Nadia",
            "part" : 1,
            "startingPage" : 3,
            "endingPage" : 8
        }, 
        {
            "series" : "Tharg's 3rillers present",
            "story" : "Six Brothers",
            "part" : 1,
            "startingPage" : 10,
            "endingPage" : 14
        }, 
        {
            "series" : "Savage",
            "arc" : "Book 7",
            "story" : "Secret City ",
            "part" : 4,
            "startingPage" : 15,
            "endingPage" : 20
        }, 
        {
            "series" : "Sinister Dexter",
            "arc" : "Apocalypse Shtick",
            "story" : "Charon's Crossing",
            "part" : 4,
            "startingPage" : 21,
            "endingPage" : 25
        }, 
        {
            "series" : "Zombo",
            "story" : "The Day the Zombo Died",
            "part" : 4,
            "startingPage" : 26,
            "endingPage" : 30
        }
    ]
},
{
    "comic" : "2000 AD",
    "issue" : "PROG 1744",
    "release_date" : "2011-07-27",
    "stories" : [ 
        {
            "series" : "Judge Dredd",
            "arc" : "Day of Chaos",
            "story" : "Nadia",
            "part" : 2,
            "startingPage" : 3,
            "endingPage" : 8
        }, 
        {
            "series" : "Savage",
            "arc" : "Book 7",
            "story" : "Secret City ",
            "part" : 5,
            "startingPage" : 9,
            "endingPage" : 14
        }, 
        {
            "series" : "Tharg's 3rillers present",
            "story" : "Six Brothers",
            "part" : 2,
            "startingPage" : 15,
            "endingPage" : 20
        }, 
        {
            "series" : "Sinister Dexter",
            "arc" : "Apocalypse Shtick",
            "story" : "Charon's Crossing",
            "part" : 5,
            "startingPage" : 21,
            "endingPage" : 25
        }, 
        {
            "series" : "Zombo",
            "story" : "The Day the Zombo Died",
            "part" : 5,
            "startingPage" : 26,
            "endingPage" : 30
        }
    ]
},
{
    "comic" : "2000 AD",
    "issue" : "PROG 1745",
    "release_date" : "2011-08-03",
    "stories" : [ 
        {
            "series" : "Judge Dredd",
            "arc" : "Day of Chaos",
            "story" : "Nadia",
            "part" : 3,
            "startingPage" : 3,
            "endingPage" : 8
        }, 
        {
            "series" : "Tharg's 3rillers present",
            "story" : "Six Brothers",
            "part" : 3,
            "startingPage" : 10,
            "endingPage" : 14
        }, 
        {
            "series" : "Savage",
            "arc" : "Book 7",
            "story" : "Secret City ",
            "part" : 6,
            "startingPage" : 15,
            "endingPage" : 20
        }, 
        {
            "series" : "Sinister Dexter",
            "arc" : "Apocalypse Shtick",
            "story" : "Inverse Ninja Rules",
            "part" : 1,
            "startingPage" : 21,
            "endingPage" : 26
        }, 
        {
            "series" : "Zombo",
            "story" : "The Day the Zombo Died",
            "part" : 6,
            "startingPage" : 27,
            "endingPage" : 31
        }
    ]
},
{    
    "comic" : "2000 AD",
    "issue" : "PROG 1746",
    "release_date" : "2011-08-10",
    "stories" : [ 
        {
            "series" : "Judge Dredd",
            "arc" : "Day of Chaos",
            "story" : "Nadia",
            "part" : 4,
            "startingPage" : 3,
            "endingPage" : 8
        }, 
        {
            "series" : "Tharg's 3rillers present",
            "story" : "Wolves",
            "part" : 1,
            "startingPage" : 10,
            "endingPage" : 14
        }, 
        {
            "series" : "Savage",
            "arc" : "Book 7",
            "story" : "Secret City ",
            "part" : 7,
            "startingPage" : 15,
            "endingPage" : 20
        }, 
        {
            "series" : "Sinister Dexter",
            "arc" : "Apocalypse Shtick",
            "story" : "The Dead-End Job",
            "part" : 1,
            "startingPage" : 21,
            "endingPage" : 26
        }, 
        {
            "series" : "Zombo",
            "story" : "The Day the Zombo Died",
            "part" : 7,
            "startingPage" : 27,
            "endingPage" : 31
        }
    ]
},
{
    "comic" : "2000 AD",
    "issue" : "PROG 1747",
    "release_date" : "2011-08-17",
    "stories" : [ 
        {
            "series" : "Judge Dredd",
            "arc" : "Day of Chaos",
            "story" : "Nadia",
            "part" : 5,
            "startingPage" : 3,
            "endingPage" : 8
        }, 
        {
            "series" : "Tharg's 3rillers present",
            "story" : "Wolves",
            "part" : 2,
            "startingPage" : 9,
            "endingPage" : 14
        }, 
        {
            "series" : "Savage",
            "arc" : "Book 7",
            "story" : "Secret City ",
            "part" : 8,
            "startingPage" : 15,
            "endingPage" : 20
        }, 
        {
            "series" : "Sinister Dexter",
            "arc" : "Apocalypse Shtick",
            "story" : "The Dead-End Job",
            "part" : 2,
            "startingPage" : 21,
            "endingPage" : 26
        }, 
        {
            "series" : "Zombo",
            "story" : "The Day the Zombo Died",
            "part" : 8,
            "startingPage" : 27,
            "endingPage" : 31
        }
    ]
},
{
    "comic" : "2000 AD",
    "issue" : "PROG 1748",
    "release_date" : "2011-08-24",
    "stories" : [ 
        {
            "series" : "Judge Dredd",
            "arc" : "Day of Chaos",
            "story" : "Nadia",
            "part" : 6,
            "startingPage" : 3,
            "endingPage" : 8
        }, 
        {
            "series" : "Tharg's 3rillers present",
            "story" : "Wolves",
            "part" : 3,
            "startingPage" : 10,
            "endingPage" : 14
        }, 
        {
            "series" : "Savage",
            "arc" : "Book 7",
            "story" : "Secret City ",
            "part" : 9,
            "startingPage" : 15,
            "endingPage" : 20
        }, 
        {
            "series" : "Sinister Dexter",
            "arc" : "Apocalypse Shtick",
            "story" : "The Dead-End Job",
            "part" : 3,
            "startingPage" : 21,
            "endingPage" : 26
        }, 
        {
            "series" : "Zombo",
            "story" : "The Day the Zombo Died",
            "part" : 9,
            "startingPage" : 27,
            "endingPage" : 31
        }
    ]
},{
    "comic" : "2000 AD",
    "issue" : "PROG 1749",
    "release_date" : "2011-08-31",
    "stories" : [ 
        {
            "series" : "Judge Dredd",
            "arc" : "Day of Chaos",
            "story" : "Nadia",
            "part" : 7,
            "startingPage" : 3,
            "endingPage" : 9
        }, 
        {
            "series" : "Savage",
            "arc" : "Book 7",
            "story" : "Secret City ",
            "part" : 10,
            "startingPage" : 10,
            "endingPage" : 15
        }, 
        {
            "series" : "Zombo",
            "story" : "The Day the Zombo Died",
            "part" : 10,
            "startingPage" : 16,
            "endingPage" : 20
        }, 
        {
            "series" : "Sinister Dexter",
            "arc" : "Apocalypse Shtick",
            "story" : "The Dead-End Job",
            "part" : 4,
            "startingPage" : 21,
            "endingPage" : 26
        }, 
        {
            "series" : "Judge Dredd",
            "arc" : "Day of Chaos",
            "story" : "Nadia",
            "part" : 8,
            "startingPage" : 27,
            "endingPage" : 32
        }
    ]
}]


url = "http://localhost:8080/comic"

for story in stories:
	data_json = json.dumps(story)
	headers = {'Content-type': 'application/json'}	
	response = requests.post(url, data=data_json, headers=headers)
	print response


