import java.text.NumberFormat
import java.util.*

fun main() {
    val harga = 749999
    val poin = 500
    val diskon: Int
    val member: String
    val totalHarga: String

    if(poin in 500..1000){
        member="Platinum"; diskon = 30
    } else if (poin in 300..500){
        member="Gold"; diskon = 15
    } else if (poin in 100..300){
        member="Silver"; diskon = 5
    } else if (poin in 0..100){
        member="Bronze"; diskon = 0
    } else {
        member="NaN"; diskon= 0
    }
    /** Format number */
    totalHarga =
        if (member !="NaN" ){
        NumberFormat.getCurrencyInstance(Locale("in", "ID"))
            .format(harga-((harga * diskon)/100))
    } else {
        NumberFormat.getCurrencyInstance(Locale("in", "ID")).format(0)
    }
    println("Member : $member (${poin} point)")
    println("Harga : ${NumberFormat.getCurrencyInstance(Locale("in", "ID")).format(harga)}")
    println("Diskon : ${diskon}%")
    println("Total Harga : $totalHarga")
}
