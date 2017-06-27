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
class ShotestPathOfMaze(val maze: Any, val n: Int, val m: Int, val start_n: Int, val start_m: Int, val goal_n: Int, val goal_m: Int){
  fun find_path(){
    //maze: Any, n: Int, m: Int, start_n: Int, start_m: Int, goal_n: Int, goal_m: Int
    //各マス毎に記録を残すための２次元配列
    var record = array2dOfNode(n,m)
    //移動途中のマスを保管するリスト
    val stack = mutableListOf<Coodinate>()

    //スタート地点のNodeを生成、対象のマスに保持させる。
    record[start_n-1][start_m-1] = Node(0,true)

    stack.add(Coodinate(start_n-1,start_m-1))
    println(stack[0])
  }

  //4方向のマスの値をチェックし、
  fun check4directions(taget_n: Int, target_m: Int, record: Any){

  }

  //Nodeを持つ２次元配列の宣言用function
  //Null safetyのためNode?を設定
  fun array2dOfNode(sizeOuter: Int, sizeInner: Int): Array<Array<Node?>>
    = Array(sizeOuter){arrayOfNulls<Node>(sizeInner)}
}

data class Node(var cost: Int, var visited: Boolean){
}

data class Coodinate(var c_n: Int, var c_m: Int)

