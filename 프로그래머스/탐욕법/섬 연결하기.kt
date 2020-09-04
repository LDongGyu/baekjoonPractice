class Solution {

    lateinit var parent:Array<Int>

    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        var idx = 0
        var edge = 0

        costs.sortBy { it[2] }
        parent = Array(n, {i->i})

        for(cost in costs){
            if(!isCycle(cost[0],cost[1])){
                answer += cost[2]
                union(cost[0],cost[1])
            }
        }
        return answer
    }

    fun find(n: Int): Int{
        if(parent[n] == n) return n
        return find(parent[n])
    }

    fun union(to: Int, from: Int){
        var newTo = find(to)
        var newFrom = find(from)

        parent[Math.max(newTo,newFrom)] = Math.min(newTo,newFrom)
    }

    fun isCycle(node1:Int, node2:Int): Boolean{
        return find(node1) == find(node2)
    }
}

fun main(){
    var sol = Solution()
    var result= sol.solution(5,
            arrayOf(intArrayOf(0,4,1),intArrayOf(2,4,1),intArrayOf(0,1,8),intArrayOf(0,2,2),intArrayOf(1,2,5),
            intArrayOf(1,3,1),intArrayOf(2,3,8)))
    print(result)
}