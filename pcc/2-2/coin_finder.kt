//main function
fun main(args: Array<String>){
  val in_pocket = arrayListOf(args[0].toInt(),args[1].toInt(),args[2].toInt(),args[3].toInt(),args[4].toInt(),args[5].toInt())
  CoinFinder().find_coins(in_pocket, args[6].toInt())
}

class CoinFinder(){
  fun find_coins(in_pocket: ArrayList<Int>, price: Int){
    var coins = in_pocket
    val coinsList = arrayListOf(500,100,50,10,5,1)
    var answers = arrayListOf(0,0,0,0,0,0)
    var num = price

    // 値が大きい硬貨から順に評価する
    for(i in 0..coinsList.size - 1){
      //各硬貨毎にbooleanをリセットする
      var bool = true
      // 対象硬貨で残金を割り算し、
      // 1以上の場合は対象硬貨を使用出来ると判断する。
      // 0以下の場合はループから抜ける。
      while(bool){
        if(num / coinsList[i] <= 0 || coins[i] == 0){
          bool = false
        } else{
          coins[i] = coins[i] - 1
          answers[i] = answers[i] + 1
          num = num - coinsList[i]
        }
      }
    }
    println("price: $price")
    println("coinsList: $coinsList")
    println("coins: $coins")
    println("answers: $answers")
  }
}
