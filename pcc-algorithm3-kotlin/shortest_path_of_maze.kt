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
  ShotestPathOfMaze().find_path(maze,n,m,start_n,start_m,goal_n,goal_m)
}

//迷路の最短路クラス
class ShotestPathOfMaze(){
  fun find_path(maze: Any, n: Int, m: Int, start_n: Int, start_m: Int, goal_n: Int, goal_m: Int){
    //各マス毎に記録を残すための２次元配列を宣言
    var record = array2dOfNode(n,m)
    //var stack = arrayOf<Array<CharArray>>()
    record[start_n-1][start_m-1] = Node(0,true)
    println(record[1][0].cost)
  }

  //２次元配列の宣言用function
  fun array2dOfNode(sizeOuter: Int, sizeInner: Int): Array<Array<Any>>
    = Array(sizeOuter){Array<Any>(sizeInner,{Node::class})}
}

class Node(var cost: Int, var visited: Boolean){
}
