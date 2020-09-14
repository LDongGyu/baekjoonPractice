import java.util.*

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        var edgeList = Array<MutableList<Int>>(n,{i-> mutableListOf()})

        for(e in edge){
            edgeList[e[0]-1].add(e[1]-1)
            edgeList[e[1]-1].add(e[0]-1)
        }

        var cnt = IntArray(n)
        var visited = BooleanArray(n)
        var queue:Queue<Int> = LinkedList()

        queue.add(0)
        visited[0] = true

        var now = 0
        while(!queue.isEmpty()){
            now = queue.poll()
            for(node in edgeList[now]){
                if(!visited[node]){
                    cnt[node] = cnt[now] + 1
                    visited[node] = true
                    queue.add(node)
                }
            }
        }

        var max = 0
        for (c in cnt){
            if(max < c){
                max = c
                answer = 1
            }
            else if(max == c) answer++
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution(6,
            arrayOf(intArrayOf(3,6),intArrayOf(4,3),intArrayOf(3,2),
                    intArrayOf(1,3),intArrayOf(1,2),intArrayOf(2,4),
                    intArrayOf(5,2)))

    print(result)
}

//class Solution {
//    lateinit var map:Array<IntArray>
//    lateinit var visit:BooleanArray
//    var nodeN = 0
//    var min = Integer.MAX_VALUE
//
//    fun solution(n: Int, edge: Array<IntArray>): Int {
//        var answer = 0
//        map = Array<IntArray>(n,{i->IntArray(n,{i->0})})
//
//        for(line in edge){
//            map[line[0]-1][line[1]-1] = 1
//            map[line[1]-1][line[0]-1] = 1
//        }
//        nodeN = n
//        visit = BooleanArray(n,{i->false})
//        visit[0] = true
//
//        var list = mutableListOf<Int>()
//
//        for(i in 1..n-1) {
//            dfs(0, i, 0)
//            list.add(min)
//            min = Integer.MAX_VALUE
//        }
//
//        list.forEach {
//            if(it == list.max()) answer++
//        }
//
//        return answer
//    }
//
//    fun dfs(start: Int, end: Int, cnt: Int){
//        if(start == end){
//            if(min > cnt){
//                min = cnt
//            }
//            return
//        }
//        if(cnt > nodeN) return
//
//        for(i in 1..nodeN-1){
//            if(!visit[i] && map[start][i] == 1){
//                visit[i] = true
//                dfs(i,end,cnt+1)
//                visit[i] = false
//            }
//        }
//    }
//}