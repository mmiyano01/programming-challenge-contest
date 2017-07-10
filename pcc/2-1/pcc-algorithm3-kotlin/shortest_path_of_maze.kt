//main function
fun main(args: Array<String>){
  val maze = arrayListOf(
    arrayListOf('#','S','#','#','#','#','#','#','.','#'),
    arrayListOf('.','.','.','.','.','.','#','.','.','#'),
    arrayListOf('.','#','.','#','#','.','#','#','.','#'),
    arrayListOf('.','#','.','.','.','.','.','.','.','.'),
    arrayListOf('#','#','.','#','#','.','#','#','#','#'),
    arrayListOf('.','.','.','.','#','.','.','.','.','#'),
    arrayListOf('#','#','#','#','#','#','#','#','.','#'),
    arrayListOf('.','.','.','#','.','.','.','.','.','.'),
    arrayListOf('.','#','#','#','#','.','#','#','#','.'),
    arrayListOf('.','.','.','.','#','.','.','.','G','#')
    )
  val n = maze[0].size
  val m = maze.size
  val start_n = 2
  val start_m = 1
  val goal_n = 9
  val goal_m = 10
  ShotestPathOfMaze(maze,n,m,start_n,start_m,goal_n,goal_m).find_path()
}

//迷路の最短路クラス
class ShotestPathOfMaze(val maze: ArrayList<ArrayList<Char>>, val n: Int, val m: Int, val start_n: Int, val start_m: Int, val goal_n: Int, val goal_m: Int){
  fun find_path(){
    //各マス毎に記録を残すための２次元配列
    var record = array2dOfNode(n,m)
    //移動途中の座標を保管するリスト
    var stack = mutableListOf<Coodinate>()

    //ゴールに到達した際のコストを保管するリスト
    var answers = mutableListOf<Int>()

    //スタート地点のNodeを生成、対象のマスに保持させる。
    record[start_n-1][start_m-1] = Node(0,true)

    //保管リストにスタート地点の座標を入れる。
    stack.add(Coodinate(start_n,start_m))

    //保管リストにデータがある限りループする。
    while (stack.size > 0) {
      //リストの頭からデータを取り出す。
      var coodinate = stack.removeAt(0)

      check4directions(coodinate.c_n, coodinate.c_m, record, stack, answers)
    }

    println("answers: $answers")
  }

  //4方向のマスの値をチェックし、通行可能な通路であり、通ったことがなければ保管リストに積む。
  //ゴールであれば、ゴールのリストに追加する。
  fun check4directions(target_n: Int, target_m: Int, record: Array<Array<Node?>>, stack: MutableList<Coodinate>, answers: MutableList<Int>){
    println("target_n: $target_n  target_m: $target_m")
    println("stack: $stack")
    var next_cost = record[target_n-1][target_m-1]!!.cost + 1
    var left = target_n - 1
    var right = target_n + 1
    var up = target_m - 1
    var down = target_m + 1

    //左
    if (left > 0){
      evaluateCoodinate(left, target_m, next_cost, record, stack, answers)
    }
    //右
    if (right <= n){
      evaluateCoodinate(right, target_m, next_cost, record, stack, answers)
    }
    //上
    if (up > 0){
      evaluateCoodinate(target_n, up, next_cost, record, stack, answers)
    }
    //下
    if (down <= m){
      evaluateCoodinate(target_n, down, next_cost, record, stack, answers)
    }
  }

  //次に進む候補の座標の中身をチェックする。
  fun evaluateCoodinate(target_n: Int, target_m: Int, next_cost: Int, record: Array<Array<Node?>>, stack: MutableList<Coodinate>, answers: MutableList<Int>){
    //ターゲットの座標上のCharをチェックする。
    when (maze[target_n - 1][target_m - 1]) {
      //通路だった場合
      '.' -> {
        //その座標に対してNodeクラスをnewしていない場合、未到達部分とする。(boolean visitedいらない?)
        if (record[target_n - 1][target_m - 1] !is Node) {
          //座標にそこまで到達するまでのコストを持たせたNodeを設定。
          record[target_n - 1][target_m - 1] = Node(next_cost, true)
          //移動可能な座標としてリストに登録しておく。
          stack.add(Coodinate(target_n, target_m))
        }
      }
      //ゴールだった場合、ゴールの一つとしてリストに登録しておく。
      'G' -> answers.add(next_cost)
    }
  }


  //Nodeを持つ２次元配列の宣言用function
  //Null safetyのためNode?を設定
  fun array2dOfNode(sizeOuter: Int, sizeInner: Int): Array<Array<Node?>>
    = Array(sizeOuter){arrayOfNulls<Node>(sizeInner)}
}

//Nodeクラス (座標毎に与えられるデータ)
//その座標に到達するまでのコスト、開拓済みかを判定するbooleanを保持する。
data class Node(var cost: Int, var visited: Boolean){
}

//座標クラス
//移動可能な座標でこのクラスをnewし、newしたクラスを移動可能リストに登録する。
data class Coodinate(var c_n: Int, var c_m: Int)
