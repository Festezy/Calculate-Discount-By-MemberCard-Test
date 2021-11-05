import java.text.NumberFormat
import java.util.*

private fun main() {
    val yourPayment = 749999
    val point = 500
    println("MemberCard: ${getMember2(point)} ($point point)")
    println("Your Payment: ${getMyCurrency(yourPayment)}")
    println("Discount You get: ${getDiscount2(getMember2(point))}%")
//    println("Price you should pay: ${afterDiscount(yourPayment, getDiscount2(getMember2(point)))}")
    afterDiscount(yourPayment, getDiscount2(getMember2(point)))

}
private fun getTotalDiskon2(total: Int, diskon: Int) = total - (total *diskon / 100)

private fun afterDiscount(payment: Int, point: Int){
    val discount: Int
    val member: String

    if (point in 0..1000){
        member = getMember2(point)
        discount = getDiscount2(member)

        println("Price you should pay: ${myCurrency(getTotalDiskon2(payment, discount))}")
    }
//    return getTotalDiskon2(payment, discount)
}
private fun getMyCurrency(value: Int): String{
    val myCurrency = NumberFormat
        .getCurrencyInstance(Locale("in", "ID"))
    myCurrency.minimumFractionDigits = 0
    return myCurrency.format(value)
}
private fun getMember2(point: Int):String{
    val member: String
    if (point in 500..1000){
        member = "Platinum"
    } else if (point in 300..500){
        member = "Gold"
    } else if (point in 100..300){
        member = "Silver"
    } else if (point in 0..100){
        member = "Bronze"
    } else{
        member = "NaN"
    }
//    println("Member: $member ($point point)")
    return member
}
private fun getDiscount2(member: String): Int{
    val discount: Int
    when (member){
        "Bronze" -> discount = 5
        "Silver" -> discount = 10
        "Gold" -> discount = 15
        "Platinum" -> discount = 30
        else -> discount = 0
    }
//    println("Discount You get: $discount%")
    return discount
}
