package com.timhore.raionhackjam2021.data

import com.timhore.raionhackjam2021.R
import com.timhore.raionhackjam2021.model.Event
import com.timhore.raionhackjam2021.model.Plant
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

object Dummy {

    fun getAllPlants(): Flow<List<Plant>> = flow {
        val listOfPlants = arrayListOf<Plant>(
            Plant(
                "PLANT001",
                "Lidah Buaya",
                "Aloe Vera",
                "Tanaman ini termasuk kedalam salah satu jenis sukulen yang juga termasuk " +
                    "salah satu jenis yang mudah ditemui di rumah-rumah. Selain mudah soal perawatan, " +
                    "aloe vera sendiri terkenal akan manfaatnya bagi kesehatan dan kecantikan seperti " +
                    "membantu menyembuh bekas luka bakar",
                "2-3 minggu sekali",
                "20 - 23 C",
                "Outdoor and indoor",
                20000,
                R.drawable.dummy_plant,
                "Kota Malang",
                4.8,
                23
            ),

            Plant(
                "PLANT002",
                "Janda Bolong",
                "Monstera",
                "monstera atau janda bolong tanaman hias saat ini menjadi salah satu tanaman " +
                    "hias yang paling populer dan banyak digandrungi karena keunikan bentuk daunnya " +
                    "yang bolong-bolong. Tanaman ini hidup dengan baik di tempat lembab seperti di tropis " +
                    "dan tidak dapat terlalu terkena matahari",
                "1-2 minggu sekali",
                "23 - 30 C",
                "Indoor",
                150000,
                R.drawable.dummy_plant2,
                "Kota Blitar",
                5.0,
                100
            ),

            Plant(
                "PLANT003",
                "Kuping Gajah",
                "Anthurium Crystallinum",
                "Tanaman kuping gajah atau Anthurium crystallinum adalah tanaman yang " +
                    "berasal dari Amerika Tengah dan Selatan. Ia adalah tanaman yang sangat cantik " +
                    "dengan daun berbentuk hati. Daunnya yang indah berwarna hijau tua atau ungu " +
                    "kemerahan juga memiliki urat putih dalam yang membuatnya semakin menonjol secara visual",
                "Sehari 1 kali",
                "+- 27 C",
                "Outdoor/Indoor",
                120000,
                R.drawable.dummy_plant3,
                "Kota Surabaya",
                4.8,
                19
            ),

            Plant(
                "PLANT004",
                "Aglaonema Red Ruby",
                "Aglaonema Red Ruby",
                "Aglaonema memiliki banyak sekali jenis, salah satunya adalah Red Ruby yang " +
                    "memiliki ciri khas warna merah ruby dan sedikit hijau nya. Tanaman ini cukup " +
                    "mudah untuk dirawat dan memiliki umur panjang",
                "Sehari 1 kali",
                "+- 27 C",
                "Indoor",
                180000,
                R.drawable.dummy_plant4,
                "Kota Surabaya",
                4.6,
                10
            ),

            Plant(
                "PLANT005",
                "Cactus Golden Barrel",
                "Echinocactus Grusonii",
                "Kaktus ini sering disebut dengan golden barell atau gentong emas seperti " +
                    "warnanya yang kuning keemasan. Kaktus ini unik soalnya memiliki duri berwarna " +
                    "keemasan. Banyak duri di sekitar batangnya",
                "3 bulan sekali",
                "16—34 C",
                "Outdoor/Indoor",
                100000,
                R.drawable.dummy_plant5,
                "Kota Malang",
                4.8,
                21
            ),

            Plant(
                "PLANT006",
                "Keladi Amazon",
                "Caladium",
                "Salah satu tanaman hias yang sedang populer belakangan ini adalah tanaman " +
                    "keladi. Tanaman keladi sendiri adalah tanaman tropis dengan daun yang berukuran " +
                    "cukup besar",
                "1-2 hari sekali",
                "21-29 C",
                "Outdoor/Indoor",
                125000,
                R.drawable.dummy_plant,
                "Kota Trenggalek",
                4.9,
                36
            ),

            Plant(
                "PLANT007",
                "Begonia Polkadot",
                "Begonia Malculata",
                "Begonia Maculata yang biasa disebut Begonia Polkadot, tidak diragukan lagi " +
                    "adalah salah satu spesies tanaman dalam ruangan yang sangat cantik. Tumbuhan " +
                    "eksotis ini mendapatkan namanya dari daun berbintik perak yang unik dan bagian " +
                    "bawah merahnya",
                "Jika dirasa kurang lembab",
                "18 hingga 22 C",
                "Indoor",
                160000,
                R.drawable.dummy_plant2,
                "Kota Bekasi",
                4.5,
                10
            ),

            Plant(
                "PLANT008",
                "Klatea",
                "Calathea Rattlesnake",
                "Tanaman hias Calathea atau kalatea kini sedang naik daun. Warna dan bentuk " +
                    "daun yang cantik membuat Calathea banyak dipilih menghiasi pekarangan hingga sudut ruangan",
                "1-2 seminggu sekali",
                "18 - 25 C",
                "Indoor",
                55000,
                R.drawable.dummy_plant3,
                "Kota Jakarta",
                4.9,
                30
            ),

            Plant(
                "PLANT009",
                "Karet Kebo",
                "Ficus elastica",
                "Karet Kebo menjadi salah satu tanaman hias primadona di kalangan penghobi " +
                    "karena mudah dalam perawatan. Selain mudah, tanaman ini juga tetap indah di liat, " +
                    "memiliki kesan minimalis, dan juga memiliki berbagai manfaat",
                "1- 3 hari sekali",
                "18 - 23 C",
                "Indoor",
                220000,
                R.drawable.dummy_plant4,
                "Kota Kediri",
                4.4,
                20
            ),

            Plant(
                "PLANT0010",
                "Kayu Putih",
                "Eucalyptus",
                "banyak pemilik rumah menghias ruangan dengan tanaman eucalyptus. Tanaman " +
                    "ini dapat tumbuh tinggi, memberikan efek dramatis dan estetis ke dalam ruangan." +
                    "Selain penampilannya yang menarik, tanaman eucalyptus di dalam pot juga bisa " +
                    "mengharumkan ruangan di rumah",
                "1- 2 hari sekali",
                "27–30 C",
                "Indoor",
                200000,
                R.drawable.dummy_plant5,
                "Kota Malang",
                4.9,
                25
            )
        )
        emit(listOfPlants)
    }.flowOn(Dispatchers.IO)

    fun getAllTrendingEvents(): Flow<List<Event>> = flow {
        val listOfTrendingEvents: List<Event> = arrayListOf(
            Event(
                "EVENT001",
                "TANAM",
                R.drawable.article1
            ),

            Event(
                "EVENT002",
                "TANAM",
                R.drawable.article2
            ),

            Event(
                "EVENT003",
                "TANAM",
                R.drawable.article3
            ),
        )
        emit(listOfTrendingEvents)
    }.flowOn(Dispatchers.IO)

    fun getAllTrendingPlants(): Flow<List<Plant>> = flow {
        val listOfTrendingPlants = arrayListOf<Plant>(
            Plant(
                "PLANT006",
                "Keladi Amazon",
                "Caladium",
                "Salah satu tanaman hias yang sedang populer belakangan ini adalah tanaman " +
                    "keladi. Tanaman keladi sendiri adalah tanaman tropis dengan daun yang berukuran " +
                    "cukup besar",
                "1-2 hari sekali",
                "21-29 C",
                "Outdoor/Indoor",
                125000,
                R.drawable.dummy_plant
            ),

            Plant(
                "PLANT007",
                "Begonia Polkadot",
                "Begonia Malculata",
                "Begonia Maculata yang biasa disebut Begonia Polkadot, tidak diragukan lagi " +
                    "adalah salah satu spesies tanaman dalam ruangan yang sangat cantik. Tumbuhan " +
                    "eksotis ini mendapatkan namanya dari daun berbintik perak yang unik dan bagian " +
                    "bawah merahnya",
                "Jika dirasa kurang lembab",
                "18 hingga 22 C",
                "Indoor",
                160000,
                R.drawable.dummy_plant2
            ),

            Plant(
                "PLANT009",
                "Karet Kebo",
                "Ficus elastica",
                "Karet Kebo menjadi salah satu tanaman hias primadona di kalangan penghobi " +
                    "karena mudah dalam perawatan. Selain mudah, tanaman ini juga tetap indah di liat, " +
                    "memiliki kesan minimalis, dan juga memiliki berbagai manfaat",
                "1- 3 hari sekali",
                "18 - 23 C",
                "Indoor",
                220000,
                R.drawable.dummy_plant4
            ),
        )

        emit(listOfTrendingPlants)
    }.flowOn(Dispatchers.IO)

    fun getDetailPlant(plantId: String) = flow<Plant> {
        getAllPlants().map { listPlants ->
            listPlants.forEach { plant ->
                if (plant.id == plantId) {
                    emit(plant)
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    fun getPlantsSearch(query: String) = flow<List<Plant>> {
        val results = ArrayList<Plant>()

        getAllPlants().map { list ->
            list.forEach { plant ->
                if (plant.name.contains(query))
                    results.add(plant)
            }
            emit(results)
        }

    }.flowOn(Dispatchers.IO)

    fun getProductsSearch(query: String) = flow<List<Plant>> {
        val results = ArrayList<Plant>()

        getAllPlants().map { list ->
            list.forEach { plant ->
                if (plant.name.contains(query, true))
                    results.add(plant)
            }
            emit(results)
        }
    }

    fun getArticleSearch(query: String) = flow<List<Plant>> {
        val results = ArrayList<Plant>()

        getAllPlants().map { list ->
            list.forEach { plant ->
                if (plant.name.contains(query))
                    results.add(plant)
            }
            emit(results)
        }
    }

    
}