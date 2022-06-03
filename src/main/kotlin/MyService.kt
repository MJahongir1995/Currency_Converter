import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.HttpURLConnection
import java.net.URL
import java.util.Scanner

class MyService: MyInterface {

    val scan = Scanner(System.`in`)
    val list = ArrayList<MyMoney>()

    override fun loadData() {

        try {
            val url = URL("http://cbu.uz/uzc/arkhiv-kursov-valyut/json/")
            val connection = url.openConnection() as HttpURLConnection
            connection.connect()

            val inputStream = connection.inputStream
            val bufferedReader = inputStream.bufferedReader()
            val gsonString = bufferedReader.readLine()
            val gson = Gson()
            val type = object : TypeToken<ArrayList<MyMoney>>(){}.type
            list.addAll(gson.fromJson(gsonString, type))
            println("Successful internet connection")
        }catch (e:java.lang.Exception){
            println("Internet connection failed")
        }
    }

    override fun somToCurrency() {
        println("Choose currency: ")
        for (i in list.indices){
            println("$i -> ${list[i].CcyNm_UZ}")
        }
        val index = scan.nextInt()
        println("Enter amount of money: ")

        val somM = scan.nextInt()

        val a = list[index].Rate

        val currency = somM / a

        println("$somM so'm = $currency ${list[index].CcyNm_UZ}")

    }

    override fun currencyToSom() {
        println("Choose currency: ")
        for (i in list.indices){
            println("$i -> ${list[i].CcyNm_UZ}")
        }
        val index = scan.nextInt()
        println("Enter amount of money: ")
        val cMoney = scan.nextInt()

        val som = cMoney * list[index].Rate
        println("$cMoney ${list[index].CcyNm_UZ} = $som so'm")
    }

    override fun maxCurrency() {
        println("Enter amount of money: ")
        val fMoney = scan.nextInt()

        list.sortByDescending { it.Rate }

        for (i in 0 until list.size){

            val som = fMoney * list[i].Rate

            println("$fMoney ${list[i].CcyNm_UZ} = $som so'm")
        }
    }

    override fun maxSomCurrency() {

        println("Enter amount of money: ")
        val somM = scan.nextInt()

        list.sortBy { it.Rate }

        for (i in 0 until list.size){

            val currency = somM / list[i].Rate

            println("$somM so'm = $currency ${list[i].CcyNm_UZ}")
        }
    }
}