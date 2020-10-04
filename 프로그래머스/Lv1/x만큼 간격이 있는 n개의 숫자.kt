class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = LongArray(n)
        for(i in 0..n-1){
            answer[i] = x*(i+1).toLong()
        }
        return answer
    }
//    fun solution(x: Int, n: Int): LongArray = LongArray(n) { x.toLong() * (it + 1) }
}

fun main() {
    var sol = Solution()

    print(sol.solution(2,5))
}