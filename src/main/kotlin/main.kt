import java.util.Scanner

fun main(){

    val scan = Scanner(System.`in`)
    val myService = MyService()
    myService.loadData()

    while(true){
        println("1-> So'm to currency" +
                "\n2-> Currency to so'm" +
                "\n3-> Max Currency" + // sizdagi ma'lum davlat valyutasiga qancha so'm olish mumkin
                "\n4-> Max som-> currency") // sizdagi ma'lum bir so'mga, ma'lum bir davlatning qancha valyutasini
                                           //  olish mumkin

        when(scan.nextInt()){
            1-> myService.somToCurrency()
            2-> myService.currencyToSom()
            3-> myService.maxCurrency()
            4-> myService.maxSomCurrency()
        }
    }
}