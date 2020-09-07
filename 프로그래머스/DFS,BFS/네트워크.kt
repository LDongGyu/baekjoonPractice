class Solution {

    lateinit var matrix: Array<IntArray>
    lateinit var list: MutableList<Int>
    var size = 0

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        matrix = computers
        list = MutableList(n,{i->i})
        size = n

        for(i in 0..size-1) {
            if(list.contains(i)) {
                list.remove(i)
                dfs(i)
                answer++
            }
        }

        return answer
    }

    fun dfs(index: Int){
        for(i in 0..size-1){
            if(matrix[index][i] == 1 && list.contains(i)) {
                list.remove(i)
                dfs(i)
            }
        }
    }
}

fun main(){
    var sol = Solution()
    var result= sol.solution(5,arrayOf(intArrayOf(1,0,0,0,1) ,intArrayOf(0,1,0,0,0),intArrayOf(0,0,1,1,0),intArrayOf(0,0,1,1,1),intArrayOf(1,0,0,1,1)))
    print(result)
}