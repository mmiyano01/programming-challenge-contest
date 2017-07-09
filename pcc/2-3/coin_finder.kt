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

    for(i in 0..coins.size - 1){
      var bool = true
      while(bool){
        if(num / coins[i] <= 0){
          bool = false
        }
        if(num / coins[i] != 0){
          answers[i] = answers[i] + 1
          num = num - coins[i]
        }
      }
    }
    println("coin: $coins")
    println("answers: $answers")
  }
}
