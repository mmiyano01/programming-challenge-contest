fun main(args: Array<String>){
  val n = 5
  val s = arrayListOf(1,2,4,6,8)
  val t = arrayListOf(3,5,7,9,10)
  Scheduling().make_schedule(n, s, t)
}

class Scheduling(){
  fun make_schedule(n: Int, s: ArrayList<Int>, t: ArrayList<Int>){
    var time = 0
    val outer_array = ArrayList<ArrayList<Int>>()
    var job_count = ArrayList<Int>()

    for(i in 0..n-1){
      var inner_array = ArrayList<Int>()
      time = t[i]
      inner_array.add(i+1)

      for(j in i+1..n-1){
        if(time < s[j]){
          time = t[j]
          inner_array.add(j+1)
        }
      }
      outer_array.add(inner_array)
      job_count.add(inner_array.size)
    }

    val ans_jobs = outer_array[job_count.indexOf(job_count.max())].toString()
    val ans_count = job_count.max()
    println("$ans_count(仕事$ans_jobs を選択)" )
  }
}
