//main function
fun main(args: Array<String>){
  val price = 2177

  CoinFinder().find_coins(price)
}
class CoinFinder(){
  fun find_coins(price: Int){
    val coins = arrayListOf(500,100,50,10,5,1)
    var answers = arrayListOf(0,0,0,0,0,0)
    var num = price

    // 値が大きい硬貨から順に評価する
    for(i in 0..coins.size - 1){
      //各硬貨毎にbooleanをリセットする
      var bool = true
      // 対象硬貨で残金を割り算し、
      // 1以上の場合は対象硬貨を使用出来ると判断する。
      // 0以下の場合はループから抜ける。
      while(bool){
        if(num / coins[i] <= 0){
          bool = false
        } else{
          answers[i] = answers[i] + 1
          num = num - coins[i]
        }
      }
    }
    println("price: $price")
    println("coin: $coins")
    println("answers: $answers")
  }
}
