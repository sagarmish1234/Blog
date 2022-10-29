const articles = [
  {
    "id": 75,
    "author_id": 4,
    "title": "The Menacing Eye",
    "image": "http://dummyimage.com/111x100.png/ff4444/ffffff",
    "wordCount": 39,
    "story": "This is just a long sequence of characters",
    "createdAt": "8/19/2022",
    "views": 11
  },
  {
    "id": 19,
    "author_id": 37,
    "title": "(Absolutions) Pipilotti's Mistakes ((Entlastungen) Pipilottis Fehler)",
    "image": "http://dummyimage.com/240x100.png/dddddd/000000",
    "wordCount": 3,
    "story": "This is just a long sequence of characters",
    "createdAt": "10/30/2021",
    "views": 73
  },
  {
    "id": 3,
    "author_id": 48,
    "title": "Blood Shack",
    "image": "http://dummyimage.com/121x100.png/dddddd/000000",
    "wordCount": 86,
    "story": "This is just a long sequence of characters",
    "createdAt": "4/9/2022",
    "views": 87
  },
  {
    "id": 17,
    "author_id": 70,
    "title": "Mean Machine",
    "image": "http://dummyimage.com/164x100.png/ff4444/ffffff",
    "wordCount": 90,
    "story": "This is just a long sequence of characters",
    "createdAt": "5/3/2022",
    "views": 46
  },
  {
    "id": 72,
    "author_id": 27,
    "title": "Final Countdown, The",
    "image": "http://dummyimage.com/138x100.png/dddddd/000000",
    "wordCount": 93,
    "story": "This is just a long sequence of characters",
    "createdAt": "12/20/2021",
    "views": 50
  },
  {
    "id": 57,
    "author_id": 62,
    "title": "Black Rose Ascension (Kurobara shôten)",
    "image": "http://dummyimage.com/157x100.png/cc0000/ffffff",
    "wordCount": 69,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/10/2022",
    "views": 4
  },
  {
    "id": 49,
    "author_id": 78,
    "title": "Throw Momma from the Train",
    "image": "http://dummyimage.com/245x100.png/dddddd/000000",
    "wordCount": 82,
    "story": "This is just a long sequence of characters",
    "createdAt": "5/5/2022",
    "views": 2
  },
  {
    "id": 17,
    "author_id": 17,
    "title": "Wake Up, Ron Burgundy",
    "image": "http://dummyimage.com/181x100.png/5fa2dd/ffffff",
    "wordCount": 45,
    "story": "This is just a long sequence of characters",
    "createdAt": "11/24/2021",
    "views": 52
  },
  {
    "id": 51,
    "author_id": 8,
    "title": "So Young (Zhi wo men zhong jiang shi qu de qing chun)",
    "image": "http://dummyimage.com/141x100.png/5fa2dd/ffffff",
    "wordCount": 34,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/29/2022",
    "views": 43
  },
  {
    "id": 69,
    "author_id": 81,
    "title": "Macao",
    "image": "http://dummyimage.com/193x100.png/ff4444/ffffff",
    "wordCount": 18,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/15/2022",
    "views": 59
  },
  {
    "id": 45,
    "author_id": 21,
    "title": "Dead Fury",
    "image": "http://dummyimage.com/226x100.png/ff4444/ffffff",
    "wordCount": 85,
    "story": "This is just a long sequence of characters",
    "createdAt": "7/12/2022",
    "views": 80
  },
  {
    "id": 77,
    "author_id": 34,
    "title": "Bloodtide",
    "image": "http://dummyimage.com/211x100.png/dddddd/000000",
    "wordCount": 45,
    "story": "This is just a long sequence of characters",
    "createdAt": "3/13/2022",
    "views": 12
  },
  {
    "id": 47,
    "author_id": 37,
    "title": "Standing Still",
    "image": "http://dummyimage.com/104x100.png/dddddd/000000",
    "wordCount": 35,
    "story": "This is just a long sequence of characters",
    "createdAt": "4/29/2022",
    "views": 65
  },
  {
    "id": 55,
    "author_id": 87,
    "title": "Year Ago in Winter, A (Im Winter ein Jahr)",
    "image": "http://dummyimage.com/204x100.png/cc0000/ffffff",
    "wordCount": 39,
    "story": "This is just a long sequence of characters",
    "createdAt": "7/5/2022",
    "views": 41
  },
  {
    "id": 8,
    "author_id": 63,
    "title": "We Are Marshall",
    "image": "http://dummyimage.com/244x100.png/ff4444/ffffff",
    "wordCount": 99,
    "story": "This is just a long sequence of characters",
    "createdAt": "12/2/2021",
    "views": 17
  },
  {
    "id": 21,
    "author_id": 19,
    "title": "Final Analysis",
    "image": "http://dummyimage.com/235x100.png/ff4444/ffffff",
    "wordCount": 48,
    "story": "This is just a long sequence of characters",
    "createdAt": "12/7/2021",
    "views": 55
  },
  {
    "id": 16,
    "author_id": 44,
    "title": "Sonny",
    "image": "http://dummyimage.com/130x100.png/ff4444/ffffff",
    "wordCount": 22,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/14/2022",
    "views": 69
  },
  {
    "id": 5,
    "author_id": 8,
    "title": "Affliction",
    "image": "http://dummyimage.com/171x100.png/dddddd/000000",
    "wordCount": 96,
    "story": "This is just a long sequence of characters",
    "createdAt": "9/28/2021",
    "views": 94
  },
  {
    "id": 58,
    "author_id": 94,
    "title": "Whales of August, The",
    "image": "http://dummyimage.com/227x100.png/dddddd/000000",
    "wordCount": 97,
    "story": "This is just a long sequence of characters",
    "createdAt": "7/23/2022",
    "views": 43
  },
  {
    "id": 47,
    "author_id": 22,
    "title": "Suicide Killers",
    "image": "http://dummyimage.com/130x100.png/dddddd/000000",
    "wordCount": 62,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/28/2022",
    "views": 11
  },
  {
    "id": 38,
    "author_id": 74,
    "title": "Serbian Film, A (Srpski film)",
    "image": "http://dummyimage.com/185x100.png/ff4444/ffffff",
    "wordCount": 89,
    "story": "This is just a long sequence of characters",
    "createdAt": "6/18/2022",
    "views": 90
  },
  {
    "id": 66,
    "author_id": 1,
    "title": "Shit Year",
    "image": "http://dummyimage.com/243x100.png/dddddd/000000",
    "wordCount": 7,
    "story": "This is just a long sequence of characters",
    "createdAt": "7/23/2022",
    "views": 46
  },
  {
    "id": 96,
    "author_id": 82,
    "title": "Incident at Loch Ness",
    "image": "http://dummyimage.com/109x100.png/cc0000/ffffff",
    "wordCount": 67,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/19/2022",
    "views": 15
  },
  {
    "id": 92,
    "author_id": 99,
    "title": "Antichrist",
    "image": "http://dummyimage.com/218x100.png/ff4444/ffffff",
    "wordCount": 62,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/20/2022",
    "views": 13
  },
  {
    "id": 54,
    "author_id": 74,
    "title": "Nothing",
    "image": "http://dummyimage.com/108x100.png/cc0000/ffffff",
    "wordCount": 71,
    "story": "This is just a long sequence of characters",
    "createdAt": "11/23/2021",
    "views": 6
  },
  {
    "id": 43,
    "author_id": 8,
    "title": "Bloomington",
    "image": "http://dummyimage.com/178x100.png/cc0000/ffffff",
    "wordCount": 81,
    "story": "This is just a long sequence of characters",
    "createdAt": "5/17/2022",
    "views": 80
  },
  {
    "id": 100,
    "author_id": 70,
    "title": "Poseidon",
    "image": "http://dummyimage.com/146x100.png/ff4444/ffffff",
    "wordCount": 16,
    "story": "This is just a long sequence of characters",
    "createdAt": "12/7/2021",
    "views": 75
  },
  {
    "id": 64,
    "author_id": 66,
    "title": "Tears of April (Käsky)",
    "image": "http://dummyimage.com/166x100.png/ff4444/ffffff",
    "wordCount": 89,
    "story": "This is just a long sequence of characters",
    "createdAt": "10/11/2021",
    "views": 17
  },
  {
    "id": 37,
    "author_id": 53,
    "title": "Blonde and Blonder",
    "image": "http://dummyimage.com/142x100.png/cc0000/ffffff",
    "wordCount": 15,
    "story": "This is just a long sequence of characters",
    "createdAt": "10/17/2021",
    "views": 41
  },
  {
    "id": 45,
    "author_id": 81,
    "title": "Main Hoon Na",
    "image": "http://dummyimage.com/189x100.png/ff4444/ffffff",
    "wordCount": 33,
    "story": "This is just a long sequence of characters",
    "createdAt": "9/24/2021",
    "views": 25
  },
  {
    "id": 54,
    "author_id": 6,
    "title": "Black Hand",
    "image": "http://dummyimage.com/224x100.png/dddddd/000000",
    "wordCount": 15,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/29/2022",
    "views": 34
  },
  {
    "id": 11,
    "author_id": 97,
    "title": "Hunchback of Notre Dame, The (Notre Dame de Paris)",
    "image": "http://dummyimage.com/127x100.png/ff4444/ffffff",
    "wordCount": 89,
    "story": "This is just a long sequence of characters",
    "createdAt": "6/9/2022",
    "views": 45
  },
  {
    "id": 45,
    "author_id": 84,
    "title": "Seabiscuit",
    "image": "http://dummyimage.com/211x100.png/ff4444/ffffff",
    "wordCount": 70,
    "story": "This is just a long sequence of characters",
    "createdAt": "11/1/2021",
    "views": 82
  },
  {
    "id": 94,
    "author_id": 12,
    "title": "Man on the Flying Trapeze",
    "image": "http://dummyimage.com/141x100.png/ff4444/ffffff",
    "wordCount": 71,
    "story": "This is just a long sequence of characters",
    "createdAt": "6/11/2022",
    "views": 59
  },
  {
    "id": 8,
    "author_id": 29,
    "title": "Eye In The Sky (Gun chung)",
    "image": "http://dummyimage.com/117x100.png/cc0000/ffffff",
    "wordCount": 63,
    "story": "This is just a long sequence of characters",
    "createdAt": "2/5/2022",
    "views": 96
  },
  {
    "id": 11,
    "author_id": 25,
    "title": "Hunter, The",
    "image": "http://dummyimage.com/238x100.png/ff4444/ffffff",
    "wordCount": 8,
    "story": "This is just a long sequence of characters",
    "createdAt": "4/3/2022",
    "views": 28
  },
  {
    "id": 41,
    "author_id": 38,
    "title": "The Fabulous Baron Munchausen",
    "image": "http://dummyimage.com/158x100.png/dddddd/000000",
    "wordCount": 87,
    "story": "This is just a long sequence of characters",
    "createdAt": "8/12/2022",
    "views": 3
  },
  {
    "id": 78,
    "author_id": 75,
    "title": "Little Nicky",
    "image": "http://dummyimage.com/214x100.png/dddddd/000000",
    "wordCount": 89,
    "story": "This is just a long sequence of characters",
    "createdAt": "5/1/2022",
    "views": 39
  },
  {
    "id": 99,
    "author_id": 65,
    "title": "Better Luck Tomorrow",
    "image": "http://dummyimage.com/214x100.png/dddddd/000000",
    "wordCount": 48,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/4/2022",
    "views": 88
  },
  {
    "id": 83,
    "author_id": 37,
    "title": "Spider-Man 2",
    "image": "http://dummyimage.com/118x100.png/ff4444/ffffff",
    "wordCount": 70,
    "story": "This is just a long sequence of characters",
    "createdAt": "12/8/2021",
    "views": 100
  },
  {
    "id": 55,
    "author_id": 26,
    "title": "Associate, The",
    "image": "http://dummyimage.com/160x100.png/ff4444/ffffff",
    "wordCount": 3,
    "story": "This is just a long sequence of characters",
    "createdAt": "7/8/2022",
    "views": 80
  },
  {
    "id": 31,
    "author_id": 9,
    "title": "Little Dorrit",
    "image": "http://dummyimage.com/126x100.png/ff4444/ffffff",
    "wordCount": 27,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/20/2022",
    "views": 83
  },
  {
    "id": 92,
    "author_id": 15,
    "title": "Game of Chance (Onnenpeli)",
    "image": "http://dummyimage.com/202x100.png/5fa2dd/ffffff",
    "wordCount": 40,
    "story": "This is just a long sequence of characters",
    "createdAt": "9/19/2021",
    "views": 4
  },
  {
    "id": 88,
    "author_id": 8,
    "title": "Sessions, The (Surrogate, The)",
    "image": "http://dummyimage.com/167x100.png/dddddd/000000",
    "wordCount": 85,
    "story": "This is just a long sequence of characters",
    "createdAt": "10/13/2021",
    "views": 76
  },
  {
    "id": 72,
    "author_id": 100,
    "title": "Brainstorm",
    "image": "http://dummyimage.com/129x100.png/5fa2dd/ffffff",
    "wordCount": 6,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/21/2022",
    "views": 39
  },
  {
    "id": 89,
    "author_id": 28,
    "title": "In the Electric Mist",
    "image": "http://dummyimage.com/230x100.png/ff4444/ffffff",
    "wordCount": 34,
    "story": "This is just a long sequence of characters",
    "createdAt": "8/22/2022",
    "views": 5
  },
  {
    "id": 38,
    "author_id": 71,
    "title": "Ghost Rider: Spirit of Vengeance",
    "image": "http://dummyimage.com/208x100.png/5fa2dd/ffffff",
    "wordCount": 89,
    "story": "This is just a long sequence of characters",
    "createdAt": "12/12/2021",
    "views": 45
  },
  {
    "id": 32,
    "author_id": 88,
    "title": "Rock-a-Bye Baby",
    "image": "http://dummyimage.com/102x100.png/ff4444/ffffff",
    "wordCount": 96,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/23/2022",
    "views": 5
  },
  {
    "id": 37,
    "author_id": 56,
    "title": "Heavenly Body, The",
    "image": "http://dummyimage.com/209x100.png/ff4444/ffffff",
    "wordCount": 17,
    "story": "This is just a long sequence of characters",
    "createdAt": "6/1/2022",
    "views": 82
  },
  {
    "id": 17,
    "author_id": 48,
    "title": "3 Worlds of Gulliver, The",
    "image": "http://dummyimage.com/230x100.png/cc0000/ffffff",
    "wordCount": 59,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/29/2022",
    "views": 49
  },
  {
    "id": 22,
    "author_id": 13,
    "title": "Miss Zombie",
    "image": "http://dummyimage.com/196x100.png/dddddd/000000",
    "wordCount": 10,
    "story": "This is just a long sequence of characters",
    "createdAt": "5/11/2022",
    "views": 96
  },
  {
    "id": 50,
    "author_id": 3,
    "title": "Invisible Waves",
    "image": "http://dummyimage.com/101x100.png/ff4444/ffffff",
    "wordCount": 59,
    "story": "This is just a long sequence of characters",
    "createdAt": "8/27/2022",
    "views": 22
  },
  {
    "id": 8,
    "author_id": 48,
    "title": "Somewhere in Time",
    "image": "http://dummyimage.com/198x100.png/5fa2dd/ffffff",
    "wordCount": 13,
    "story": "This is just a long sequence of characters",
    "createdAt": "8/17/2022",
    "views": 21
  },
  {
    "id": 80,
    "author_id": 44,
    "title": "Death Sentence",
    "image": "http://dummyimage.com/239x100.png/5fa2dd/ffffff",
    "wordCount": 40,
    "story": "This is just a long sequence of characters",
    "createdAt": "10/31/2021",
    "views": 1
  },
  {
    "id": 92,
    "author_id": 20,
    "title": "Wishmaster",
    "image": "http://dummyimage.com/174x100.png/cc0000/ffffff",
    "wordCount": 95,
    "story": "This is just a long sequence of characters",
    "createdAt": "10/17/2021",
    "views": 47
  },
  {
    "id": 93,
    "author_id": 95,
    "title": "Adventurer, The",
    "image": "http://dummyimage.com/206x100.png/dddddd/000000",
    "wordCount": 25,
    "story": "This is just a long sequence of characters",
    "createdAt": "11/20/2021",
    "views": 79
  },
  {
    "id": 67,
    "author_id": 41,
    "title": "Holes in My Shoes",
    "image": "http://dummyimage.com/238x100.png/cc0000/ffffff",
    "wordCount": 49,
    "story": "This is just a long sequence of characters",
    "createdAt": "6/25/2022",
    "views": 68
  },
  {
    "id": 18,
    "author_id": 91,
    "title": "Shed No Tears (Känn ingen sorg)",
    "image": "http://dummyimage.com/153x100.png/cc0000/ffffff",
    "wordCount": 74,
    "story": "This is just a long sequence of characters",
    "createdAt": "3/5/2022",
    "views": 95
  },
  {
    "id": 27,
    "author_id": 77,
    "title": "Gory Gory Hallelujah",
    "image": "http://dummyimage.com/209x100.png/dddddd/000000",
    "wordCount": 41,
    "story": "This is just a long sequence of characters",
    "createdAt": "6/13/2022",
    "views": 76
  },
  {
    "id": 92,
    "author_id": 47,
    "title": "Muriel's Wedding",
    "image": "http://dummyimage.com/235x100.png/ff4444/ffffff",
    "wordCount": 3,
    "story": "This is just a long sequence of characters",
    "createdAt": "12/16/2021",
    "views": 27
  },
  {
    "id": 94,
    "author_id": 66,
    "title": "How Hitler Lost the War",
    "image": "http://dummyimage.com/221x100.png/cc0000/ffffff",
    "wordCount": 23,
    "story": "This is just a long sequence of characters",
    "createdAt": "4/10/2022",
    "views": 18
  },
  {
    "id": 45,
    "author_id": 27,
    "title": "Speedy",
    "image": "http://dummyimage.com/222x100.png/dddddd/000000",
    "wordCount": 23,
    "story": "This is just a long sequence of characters",
    "createdAt": "7/15/2022",
    "views": 95
  },
  {
    "id": 35,
    "author_id": 63,
    "title": "The Magic Box",
    "image": "http://dummyimage.com/232x100.png/ff4444/ffffff",
    "wordCount": 64,
    "story": "This is just a long sequence of characters",
    "createdAt": "10/16/2021",
    "views": 75
  },
  {
    "id": 2,
    "author_id": 14,
    "title": "Moebius Redux: A Life in Pictures",
    "image": "http://dummyimage.com/113x100.png/5fa2dd/ffffff",
    "wordCount": 91,
    "story": "This is just a long sequence of characters",
    "createdAt": "6/19/2022",
    "views": 94
  },
  {
    "id": 24,
    "author_id": 66,
    "title": "Fantastic Mr. Fox",
    "image": "http://dummyimage.com/135x100.png/cc0000/ffffff",
    "wordCount": 82,
    "story": "This is just a long sequence of characters",
    "createdAt": "11/26/2021",
    "views": 66
  },
  {
    "id": 17,
    "author_id": 44,
    "title": "Retro Puppet Master (Puppet Master 7)",
    "image": "http://dummyimage.com/135x100.png/5fa2dd/ffffff",
    "wordCount": 19,
    "story": "This is just a long sequence of characters",
    "createdAt": "9/17/2021",
    "views": 23
  },
  {
    "id": 86,
    "author_id": 64,
    "title": "Madhouse",
    "image": "http://dummyimage.com/117x100.png/dddddd/000000",
    "wordCount": 85,
    "story": "This is just a long sequence of characters",
    "createdAt": "12/29/2021",
    "views": 90
  },
  {
    "id": 41,
    "author_id": 13,
    "title": "Night of the Zombies (a.k.a. Batallion of the Living Dead)",
    "image": "http://dummyimage.com/144x100.png/cc0000/ffffff",
    "wordCount": 83,
    "story": "This is just a long sequence of characters",
    "createdAt": "8/23/2022",
    "views": 17
  },
  {
    "id": 99,
    "author_id": 25,
    "title": "Fifty Dead Men Walking",
    "image": "http://dummyimage.com/108x100.png/dddddd/000000",
    "wordCount": 76,
    "story": "This is just a long sequence of characters",
    "createdAt": "10/25/2021",
    "views": 61
  },
  {
    "id": 50,
    "author_id": 73,
    "title": "Afternoon Delight",
    "image": "http://dummyimage.com/118x100.png/cc0000/ffffff",
    "wordCount": 53,
    "story": "This is just a long sequence of characters",
    "createdAt": "2/5/2022",
    "views": 68
  },
  {
    "id": 78,
    "author_id": 63,
    "title": "Inauguration of the Pleasure Dome",
    "image": "http://dummyimage.com/226x100.png/ff4444/ffffff",
    "wordCount": 10,
    "story": "This is just a long sequence of characters",
    "createdAt": "6/6/2022",
    "views": 33
  },
  {
    "id": 14,
    "author_id": 45,
    "title": "Hatfields & McCoys",
    "image": "http://dummyimage.com/146x100.png/dddddd/000000",
    "wordCount": 67,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/8/2022",
    "views": 77
  },
  {
    "id": 91,
    "author_id": 34,
    "title": "Article 99",
    "image": "http://dummyimage.com/227x100.png/5fa2dd/ffffff",
    "wordCount": 30,
    "story": "This is just a long sequence of characters",
    "createdAt": "4/11/2022",
    "views": 33
  },
  {
    "id": 33,
    "author_id": 29,
    "title": "Kokowääh",
    "image": "http://dummyimage.com/157x100.png/dddddd/000000",
    "wordCount": 8,
    "story": "This is just a long sequence of characters",
    "createdAt": "6/9/2022",
    "views": 63
  },
  {
    "id": 88,
    "author_id": 47,
    "title": "Little Darlings",
    "image": "http://dummyimage.com/108x100.png/ff4444/ffffff",
    "wordCount": 56,
    "story": "This is just a long sequence of characters",
    "createdAt": "4/1/2022",
    "views": 3
  },
  {
    "id": 69,
    "author_id": 83,
    "title": "The Man Who Could Cheat Death",
    "image": "http://dummyimage.com/158x100.png/ff4444/ffffff",
    "wordCount": 98,
    "story": "This is just a long sequence of characters",
    "createdAt": "2/13/2022",
    "views": 74
  },
  {
    "id": 65,
    "author_id": 48,
    "title": "Raise the Red Lantern (Da hong deng long gao gao gua)",
    "image": "http://dummyimage.com/147x100.png/ff4444/ffffff",
    "wordCount": 36,
    "story": "This is just a long sequence of characters",
    "createdAt": "5/29/2022",
    "views": 75
  },
  {
    "id": 65,
    "author_id": 100,
    "title": "While You Were Sleeping",
    "image": "http://dummyimage.com/247x100.png/dddddd/000000",
    "wordCount": 79,
    "story": "This is just a long sequence of characters",
    "createdAt": "12/28/2021",
    "views": 62
  },
  {
    "id": 73,
    "author_id": 14,
    "title": "Sonny",
    "image": "http://dummyimage.com/178x100.png/dddddd/000000",
    "wordCount": 2,
    "story": "This is just a long sequence of characters",
    "createdAt": "12/4/2021",
    "views": 14
  },
  {
    "id": 34,
    "author_id": 78,
    "title": "I Know What You Did Last Summer",
    "image": "http://dummyimage.com/239x100.png/dddddd/000000",
    "wordCount": 63,
    "story": "This is just a long sequence of characters",
    "createdAt": "12/9/2021",
    "views": 56
  },
  {
    "id": 29,
    "author_id": 79,
    "title": "Bambi Meets Godzilla",
    "image": "http://dummyimage.com/111x100.png/dddddd/000000",
    "wordCount": 81,
    "story": "This is just a long sequence of characters",
    "createdAt": "5/18/2022",
    "views": 88
  },
  {
    "id": 22,
    "author_id": 5,
    "title": "Taming the Fire (Ukroshcheniye ognya)",
    "image": "http://dummyimage.com/122x100.png/ff4444/ffffff",
    "wordCount": 69,
    "story": "This is just a long sequence of characters",
    "createdAt": "6/5/2022",
    "views": 83
  },
  {
    "id": 91,
    "author_id": 57,
    "title": "Raging Bull",
    "image": "http://dummyimage.com/104x100.png/5fa2dd/ffffff",
    "wordCount": 82,
    "story": "This is just a long sequence of characters",
    "createdAt": "6/26/2022",
    "views": 68
  },
  {
    "id": 24,
    "author_id": 89,
    "title": "Liebelei",
    "image": "http://dummyimage.com/142x100.png/cc0000/ffffff",
    "wordCount": 99,
    "story": "This is just a long sequence of characters",
    "createdAt": "4/3/2022",
    "views": 7
  },
  {
    "id": 12,
    "author_id": 60,
    "title": "Efectos secundarios",
    "image": "http://dummyimage.com/116x100.png/5fa2dd/ffffff",
    "wordCount": 14,
    "story": "This is just a long sequence of characters",
    "createdAt": "4/23/2022",
    "views": 43
  },
  {
    "id": 46,
    "author_id": 92,
    "title": "Death and the Maiden",
    "image": "http://dummyimage.com/149x100.png/ff4444/ffffff",
    "wordCount": 46,
    "story": "This is just a long sequence of characters",
    "createdAt": "11/24/2021",
    "views": 66
  },
  {
    "id": 97,
    "author_id": 49,
    "title": "Apple Jack",
    "image": "http://dummyimage.com/170x100.png/ff4444/ffffff",
    "wordCount": 75,
    "story": "This is just a long sequence of characters",
    "createdAt": "11/25/2021",
    "views": 94
  },
  {
    "id": 66,
    "author_id": 87,
    "title": "Fires Were Started",
    "image": "http://dummyimage.com/221x100.png/dddddd/000000",
    "wordCount": 8,
    "story": "This is just a long sequence of characters",
    "createdAt": "9/25/2021",
    "views": 72
  },
  {
    "id": 57,
    "author_id": 33,
    "title": "All Is Lost",
    "image": "http://dummyimage.com/209x100.png/dddddd/000000",
    "wordCount": 92,
    "story": "This is just a long sequence of characters",
    "createdAt": "12/18/2021",
    "views": 59
  },
  {
    "id": 7,
    "author_id": 22,
    "title": "Survival Island (Three)",
    "image": "http://dummyimage.com/184x100.png/ff4444/ffffff",
    "wordCount": 63,
    "story": "This is just a long sequence of characters",
    "createdAt": "12/3/2021",
    "views": 55
  },
  {
    "id": 19,
    "author_id": 33,
    "title": "This Man Must Die (Que la bête meure)",
    "image": "http://dummyimage.com/242x100.png/5fa2dd/ffffff",
    "wordCount": 72,
    "story": "This is just a long sequence of characters",
    "createdAt": "4/4/2022",
    "views": 10
  },
  {
    "id": 10,
    "author_id": 88,
    "title": "Chemical Brothers: Don't Think, The",
    "image": "http://dummyimage.com/132x100.png/ff4444/ffffff",
    "wordCount": 39,
    "story": "This is just a long sequence of characters",
    "createdAt": "11/28/2021",
    "views": 18
  },
  {
    "id": 17,
    "author_id": 15,
    "title": "K2",
    "image": "http://dummyimage.com/215x100.png/dddddd/000000",
    "wordCount": 19,
    "story": "This is just a long sequence of characters",
    "createdAt": "1/23/2022",
    "views": 81
  },
  {
    "id": 39,
    "author_id": 39,
    "title": "Legend of the Lost",
    "image": "http://dummyimage.com/169x100.png/cc0000/ffffff",
    "wordCount": 18,
    "story": "This is just a long sequence of characters",
    "createdAt": "8/14/2022",
    "views": 52
  },
  {
    "id": 37,
    "author_id": 15,
    "title": "Go for Broke!",
    "image": "http://dummyimage.com/121x100.png/cc0000/ffffff",
    "wordCount": 53,
    "story": "This is just a long sequence of characters",
    "createdAt": "11/15/2021",
    "views": 10
  },
  {
    "id": 60,
    "author_id": 21,
    "title": "24 Hours on Craigslist",
    "image": "http://dummyimage.com/195x100.png/cc0000/ffffff",
    "wordCount": 53,
    "story": "This is just a long sequence of characters",
    "createdAt": "2/23/2022",
    "views": 57
  },
  {
    "id": 59,
    "author_id": 43,
    "title": "Unfaithful, The",
    "image": "http://dummyimage.com/207x100.png/5fa2dd/ffffff",
    "wordCount": 93,
    "story": "This is just a long sequence of characters",
    "createdAt": "4/21/2022",
    "views": 57
  },
  {
    "id": 42,
    "author_id": 35,
    "title": "Kiler",
    "image": "http://dummyimage.com/140x100.png/cc0000/ffffff",
    "wordCount": 65,
    "story": "This is just a long sequence of characters",
    "createdAt": "7/12/2022",
    "views": 62
  },
  {
    "id": 85,
    "author_id": 48,
    "title": "Splinterheads",
    "image": "http://dummyimage.com/134x100.png/5fa2dd/ffffff",
    "wordCount": 13,
    "story": "This is just a long sequence of characters",
    "createdAt": "3/13/2022",
    "views": 82
  },
  {
    "id": 48,
    "author_id": 45,
    "title": "Fantastic Mr. Fox",
    "image": "http://dummyimage.com/150x100.png/5fa2dd/ffffff",
    "wordCount": 76,
    "story": "This is just a long sequence of characters",
    "createdAt": "7/9/2022",
    "views": 13
  }
]

export default articles