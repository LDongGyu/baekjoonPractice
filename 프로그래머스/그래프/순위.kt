import java.util.*

class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        var graph = Array<IntArray>(n,{i-> IntArray(n,{i->0})})

        for(result in results){
            graph[result[1]-1][result[0]-1] = 1
        }

        var visited = BooleanArray(n)
        var queue: Queue<Int> = LinkedList()
        var cnt = 0
        var now = 0

        for(i in 0..n-1) { //n 명
            queue.clear()
            queue.offer(i)
            visited.fill(false)
            visited[i] = true
            while (!queue.isEmpty()) {
                now = queue.poll()
                for(j in 0..n-1){
                    if(graph[now][j]==1 && !visited[j]){
                        cnt++
                        visited[j] = true
                        queue.offer(j)
                    }
                }
            }

            queue.clear()
            queue.offer(i)
            visited[i] = true
            while (!queue.isEmpty()) {
                now = queue.poll()
                for(j in 0..n-1){
                    if(graph[j][now]==1 && !visited[j]){
                        cnt++
                        visited[j] = true
                        queue.offer(j)
                    }
                }
            }
            if(cnt == n-1) answer++
            cnt = 0
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution(5,
            arrayOf(intArrayOf(1,2),intArrayOf(2,3),intArrayOf(3,4),
                    intArrayOf(4,5)))

    print(result)
}